/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.utils;

import com.meteo.controllers.AbstractPersistenceDesktop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author SALIM
 */
public class Mailer {
 

   static Properties getProperty(){
    try {
        Properties properties = new Properties();
        InputStream input = new FileInputStream("MailConfig.properties");
        properties.load(input);
        return properties;
        
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(AbstractPersistenceDesktop.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }  catch (IOException ex) {
           Logger.getLogger(AbstractPersistenceDesktop.class.getName()).log(Level.SEVERE, null, ex);
           return null;
    }
    }
   public static boolean sendTextMail(String from,String to,String subject,String message){
   Properties props = getProperty();
   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(props.getProperty("username"),props.getProperty("password"));
    }
   });
   try{
   Message msg = new MimeMessage(session);
   msg.setFrom(new InternetAddress(from));
   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
   msg.setSubject(subject);
   msg.setText(message);
   Transport.send(msg);
   return true;
   
   }
   catch(MessagingException mex){
   return false;
   }
   } 
   public static boolean sendHTMLEmail(String from,String to,String subject,String message){
   Properties props = getProperty();
   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(props.getProperty("username"),props.getProperty("password"));
    }
   });
   try{
   MimeMessage msg = new MimeMessage(session);
   msg.setFrom(new InternetAddress(from));
   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
   msg.setSubject(subject);
   msg.setText(message,"utf-8","html");
   Transport.send(msg);
   return true;
   
   }
   catch(MessagingException mex){
   return false;
   }
   }
}
