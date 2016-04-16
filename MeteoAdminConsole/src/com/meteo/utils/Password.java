/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.utils;

/**
 *
 * @author SALIM
 */
public class Password {
    public static String Generate_Password(){
    String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    int n = 8;
    int min = 0;
    int max = set.length()-1;
    StringBuilder sb = new StringBuilder();
    for (int i=0;i<n;i++){
    int k = min + (int)(Math.random()*(max-min));
    sb.append(set.charAt(k));
    }
    return sb.toString();
    } 
}
