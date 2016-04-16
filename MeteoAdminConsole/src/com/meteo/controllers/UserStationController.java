/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.controllers;

import com.meteo.models.UserStation;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author SALIM
 */
public class UserStationController extends AbstractPersistenceDesktop implements EntityService<UserStation> {

    @Override
    public void persist(UserStation t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    @Override
    public void edit(UserStation t) {
        em.getTransaction().begin();
        UserStation us = this.getItemByID(t.getId());
        us.setStation(t.getStation());
        us.setUser(t.getUser());
        em.getTransaction().commit();
    }

    @Override
    public void remove(Long id) {
        em.getTransaction().begin();
        em.remove(this.getItemByID(id));
        em.getTransaction().commit();
    }

    @Override
    public UserStation getItemByID(Long id) {
        return em.find(UserStation.class, id);
    }

    @Override
    public List<UserStation> keywordSearch(String keyword) {
        TypedQuery<UserStation> query = em.createQuery("SELECT us FROM user_stations us WHERE us.station.location LIKE '%" + keyword +"%' or us.station.number = '" + keyword + "%' or us.user.fname like '%" + keyword +"%' or us.user.lname like '%" + keyword + "%' or us.user.username like '%" + keyword + "%'", UserStation.class);
        return query.getResultList();
    }

    @Override
    public List<UserStation> getItems() {
        TypedQuery<UserStation> query = em.createQuery("SELECT us FROM user_stations us", UserStation.class);
        return query.getResultList();
    }
    
}
