/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.controllers;

import java.util.List;

/**
 *
 * @author SALIM
 */
public interface EntityService <T>{
    public void persist(T t);
    public void edit(T t);
    public void remove(Long id);
    public T getItemByID(Long id);
    public List<T> keywordSearch(String keyword);
    public List<T> getItems();
    
}
