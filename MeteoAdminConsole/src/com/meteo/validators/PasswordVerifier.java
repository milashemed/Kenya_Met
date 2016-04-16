/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.validators;

import java.awt.Color;
import java.util.regex.PatternSyntaxException;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author SALIM
 */
public class PasswordVerifier extends InputVerifier {
JButton okButton;

    public PasswordVerifier(JButton okButton) {
        this.okButton = okButton;
    }
    private boolean isComplex(String subject){
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
    @Override
    public boolean verify(JComponent input) {
        JTextField textfield = (JTextField)input;
        if (textfield.getText().isEmpty()){
        this.okButton.setEnabled(false);
        textfield.setBackground(Color.PINK);
        textfield.setToolTipText("Field Is Required");
        return false;
        }
        else if (!this.isComplex(textfield.getText())){
        this.okButton.setEnabled(false);
        textfield.setBackground(Color.PINK);
        textfield.setToolTipText("This Password is Weak, Password must be at least 8 characters long, Contain at least one upper case letter, one lower case letter and one Digit ");
        return false;
        }
        else {
        this.okButton.setEnabled(true);
        textfield.setBackground(Color.WHITE);
        textfield.setToolTipText("");
        return true;
        }  
    }
    
}
