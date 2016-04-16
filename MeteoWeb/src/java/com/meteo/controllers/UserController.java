/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.controllers;

import com.meteo.models.User;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author SALIM
 */
public class UserController extends AbstractPersistence implements EntityService<User> {

    @Override
    public void persist(User t) {
    em.getTransaction().begin();
    em.persist(t);
    em.getTransaction().commit();
    em.close();
    }

    @Override
    public void edit(User t) {
        em.getTransaction().begin();
        User user = this.getItemByID(t.getId());
        user.setFname(t.getFname());
        user.setLname(t.getLname());
        user.setUsername(t.getUsername());
        user.setPhone(t.getPhone());
        user.setEmail(t.getEmail());
        user.setType(t.getType());
        user.setPassword(t.getPassword());
        user.setStatus(t.getStatus());
        user.setPasschange(t.getPasschange());
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
    public User getItemByID(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> keywordSearch(String keyword) {
                TypedQuery<User> query = em.createQuery("SELECT u FROM users u WHERE u.fname like '%" + keyword + "%' or u.lname like '%" + keyword + "%' or u.username like '%" + keyword + "%'" , User.class);

        return query.getResultList();
    }

    @Override
    public List<User> getItems() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM users u", User.class);
        return query.getResultList();    
    }
    public List<User> getAdmins() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM users u where u.type = 'Administrator'"  , User.class);
        return query.getResultList();    
    }
    public  boolean userEmpty(String username){
    TypedQuery<User> query = em.createQuery("SELECT u FROM users u where u.username = '" + username + "'",User.class);
    return query.getResultList().isEmpty();
    }
    public boolean authenticate(User user, String password){
    return BCrypt.checkpw(password, user.getPassword());
   
    }
    public User getCurrentUser() throws FileNotFoundException, IOException, ClassNotFoundException{
    File profile = new File("profile.ser");
    InputStream pis = new FileInputStream(profile);
    InputStream buffer = new BufferedInputStream(pis);
    ObjectInput input = new ObjectInputStream(buffer);
    User user  = (User)input.readObject();
    return user;
    }
   public User getByUsername(String username){
   User user = null;
   TypedQuery<User> query = em.createQuery("SELECT u FROM users u where u.username = '" + username + "'",User.class);
  for (User us : query.getResultList()){
  user = us;
  }
  return user;
   } 
}
