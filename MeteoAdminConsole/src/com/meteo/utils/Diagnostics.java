/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author SALIM
 */
public class Diagnostics {
public static boolean checkDBConnectivity() throws FileNotFoundException, IOException{
    Properties properties = new Properties();
Map<String,String> params = new HashMap<>(); 
try {
                InputStream input = new FileInputStream("DatabaseConfig.properties");
                properties.load(input);
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(properties.getProperty("javax.persistence.jdbc.url"), properties.getProperty("javax.persistence.jdbc.user"), properties.getProperty("javax.persistence.jdbc.password"));
                return true;
            }
            catch(ClassNotFoundException ce){
                ce.printStackTrace();
            return false;
            }
            catch (SQLException se){
                
            return false;
            }
}  

}