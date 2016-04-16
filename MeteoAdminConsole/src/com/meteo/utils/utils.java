/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.utils;

import java.util.UUID;

/**
 *
 * @author SALIM
 */
public class utils {
    public static String generateID(){
    return UUID.randomUUID().toString().split("-")[0];
    }
}
