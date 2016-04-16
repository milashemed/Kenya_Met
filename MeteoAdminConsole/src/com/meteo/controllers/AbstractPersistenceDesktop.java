/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author shemed
 */
public abstract class AbstractPersistenceDesktop {
   protected EntityManagerFactory emf = null;
   protected EntityManager em = null;  
     
public AbstractPersistenceDesktop(){
Properties properties = new Properties();
Map<String,String> params = new HashMap<>();    
        
    try {
        InputStream input = new FileInputStream("DatabaseConfig.properties");
        properties.load(input);
        params.put("javax.persistence.jdbc.url", properties.getProperty("javax.persistence.jdbc.url"));
        params.put("javax.persistence.jdbc.user", properties.getProperty("javax.persistence.jdbc.user"));
        params.put("javax.persistence.jdbc.driver", properties.getProperty("javax.persistence.jdbc.driver"));
        params.put("javax.persistence.jdbc.password", properties.getProperty("javax.persistence.jdbc.password"));
        params.put("javax.persistence.schema-generation.database.action", properties.getProperty("javax.persistence.schema-generation.database.action"));
        
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(AbstractPersistenceDesktop.class.getName()).log(Level.SEVERE, null, ex);
    }  catch (IOException ex) {
           Logger.getLogger(AbstractPersistenceDesktop.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        emf = Persistence.createEntityManagerFactory("MeteoAdminConsolePU", params);
        em = emf.createEntityManager();

           
        

   
    
}
}
