/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.controllers;

import com.meteo.models.Station;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author SALIM
 */
public class StationController extends AbstractPersistence implements EntityService<Station> {

    @Override
    public void persist(Station t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void edit(Station t) {
        em.getTransaction().begin();
        Station stat = this.getItemByID(t.getId());
        stat.setLocation(t.getLocation());
        stat.setNumber(t.getNumber());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Long id) {
        em.getTransaction().begin();
        em.remove(this.getItemByID(id));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Station getItemByID(Long id) {
        return em.find(Station.class, id);
    }

    @Override
    public List<Station> keywordSearch(String keyword) {
TypedQuery<Station> query = em.createQuery("SELECT s FROM stations s where s.location like '%" + keyword + "%' or s.number = '" + keyword + "'" , Station.class);
        return query.getResultList();    }

    @Override
    public List<Station> getItems() {
        TypedQuery<Station> query = em.createQuery("SELECT s FROM stations s", Station.class);
        return query.getResultList();
    }
    public boolean NotstationExists(String station){
    TypedQuery<Station> query = em.createQuery("SELECT s FROM stations s WHERE s.number = '" + station + "' or s.location = '" + station + "'", Station.class);
    return query.getResultList().isEmpty();
    }
    public Station getStationByID(int id){
    Station station = null;
    TypedQuery<Station> query = em.createQuery("SELECT s FROM stations s WHERE s.id = " + id , Station.class);
    for (Station stat : query.getResultList()){
    station = stat;
    }
    return station;
    }
    
}
