/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.utils;

import java.text.DateFormatSymbols;

/**
 *
 * @author SALIM
 */
public class DateUtils {
    public static String getMonth(int month){
        String[] monthnames = new DateFormatSymbols().getMonths();
String strmonth = monthnames[month];
return strmonth;
    }
  public static String getOrdinals(int date){
  if (date == 1 || date == 21 || date == 31){
  return "st";
  }
  else if (date == 2 || date == 22){
  return "nd";
  }
  else if (date == 3 || date == 23){
  return "rd";
  }
  else {
  
  return "th";
  }
  }  
}
