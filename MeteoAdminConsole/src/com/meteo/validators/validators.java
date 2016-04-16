/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.validators;


import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author shemed
 */
public class validators {
  static String Subject;
static Pattern phoneRegex = Pattern.compile("^\\+254[0-9]{3}[0-9]{3}[0-9]{3}$");
static Pattern phoneRegex2 = Pattern.compile("^[0-9]{4}[0-9]{3}[0-9]{3}$");
static Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public validators(String Subject) {
        this.Subject = Subject;
    }
   public static boolean isEmail(){
     return emailRegex.matcher(Subject).matches();
   }
   public static boolean isPhone(){
try {
	if (Subject.matches("07[0-9]{2}[0-9]{3}[0-9]{3}") || Subject.matches("\\+2547[0-9]{2}[0-9]{3}[0-9]{3}")) {
		return true;
	} else {
		return false;
	} 
} catch (PatternSyntaxException ex) {
	return false;
} 
   }
   
}
