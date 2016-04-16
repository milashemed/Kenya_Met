/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.validators;

import java.util.regex.PatternSyntaxException;

/**
 *
 * @author SALIM
 */
public class DataValidator {
public static boolean isComplex(String subject){
    try {
	if (subject.matches("\\A(?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9])\\S{8,}\\z")) {
		return true;
	} else {
	return false;
	} 
        } catch (PatternSyntaxException ex) {
	return false;
        }
    }    
}
