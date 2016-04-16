/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.validators;

import com.meteo.controllers.UserController;
import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author SALIM
 */
public class UsernameVerifier extends InputVerifier {
JButton okButton;

    public UsernameVerifier(JButton okButton) {
        this.okButton = okButton;
    }
    @Override
    public boolean verify(JComponent input) {
JTextField textfield = (JTextField)input;
        UserController uc = new UserController();
        if (textfield.getText().isEmpty()){
        this.okButton.setEnabled(false);
        textfield.setBackground(Color.PINK);
        textfield.setToolTipText("Field Is Required");
        return false;
        }
        else if (!uc.userEmpty(textfield.getText())){
        this.okButton.setEnabled(false);
        textfield.setBackground(Color.PINK);
        textfield.setToolTipText("This Username is Already in Use");
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
