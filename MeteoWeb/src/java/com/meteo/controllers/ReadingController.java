/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.controllers;

import com.meteo.models.Reading;
import java.util.List;

/**
 *
 * @author SALIM
 */
public class ReadingController extends AbstractPersistence implements EntityService<Reading> {

    @Override
    public void persist(Reading t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void edit(Reading t) {
        em.getTransaction().begin();
        Reading reading = this.getItemByID(t.getId());
        reading.setTemperature(t.getTemperature());
        reading.setHumidity(t.getHumidity());
        reading.setPressure(t.getPressure());
        reading.setRainfall(t.getRainfall());
        reading.setEvaporation(t.getEvaporation());
        reading.setUser(t.getUser());
        reading.setStation(t.getStation());
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
    public Reading getItemByID(Long id) {
        return em.find(Reading.class, id);
    }

    @Override
    public List<Reading> keywordSearch(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reading> getItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
