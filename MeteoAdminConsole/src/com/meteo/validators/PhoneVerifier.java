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
public class PhoneVerifier extends InputVerifier {
JButton okButton;

    public PhoneVerifier(JButton okbutton) {
        this.okButton = okbutton;
    }
    private boolean isPhone(String subject){
    try {
	if (subject.matches("07[0-9]{2}[0-9]{3}[0-9]{3}") || subject.matches("\\+2547[0-9]{2}[0-9]{3}[0-9]{3}")) {
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
        else if (!this.isPhone(textfield.getText())){
        this.okButton.setEnabled(false);
        textfield.setBackground(Color.PINK);
        textfield.setToolTipText("Incorrect Phone Number Format, Phone Number must be Either 0700123456 or +254700123456");
        return false;
        }
        else {
        this.okButton.setEnabled(true);
        textfield.setBackground(Color.WHITE);
        textfield.setToolTipText("");
        return true;
        }    }
    
}
