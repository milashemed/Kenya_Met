/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.servlets;

import com.meteo.controllers.AbstractPersistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author SALIM
 */
@WebListener
public class PersistenceAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        AbstractPersistence.getInstance().closeEntityManagerFactory();
    }
    
}
