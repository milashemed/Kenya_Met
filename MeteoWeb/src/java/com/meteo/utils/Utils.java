/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.utils;

import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author SALIM
 */
public class Utils {
    public static String JSONify(Map responseMap){
    String json = "{\n";
     Iterator it = responseMap.entrySet().iterator();
    int size  = responseMap.size();
    int i = 0;
    while(it.hasNext()){
        i+=1;
    Map.Entry pair = (Map.Entry)it.next();
    if (i==size){
        json += "\"" + pair.getKey() + "\":\"" + pair.getValue() + "\"\n";

    }
    else {
    json += "\"" + pair.getKey() + "\":\"" + pair.getValue() + "\",\n";
    }
    }
    json += "}\n";
     return json;
    }
}
