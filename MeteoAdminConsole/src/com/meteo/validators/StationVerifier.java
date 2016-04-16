/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.validators;

import com.meteo.controllers.StationController;
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
public class StationVerifier extends InputVerifier {
JButton btnsave;

    public StationVerifier(JButton btnsave) {
        this.btnsave = btnsave;
    }

    @Override
    public boolean verify(JComponent input) {
JTextField textfield = (JTextField)input;
StationController sc = new StationController();
        UserController uc = new UserController();
        if (textfield.getText().isEmpty()){
        this.btnsave.setEnabled(false);
        textfield.setBackground(Color.PINK);
        textfield.setToolTipText("Field Is Required");
        return false;
        }  
        else if (!sc.NotstationExists(textfield.getText())){
            this.btnsave.setEnabled(false);
        textfield.setBackground(Color.PINK);
        textfield.setToolTipText("This Station Already Exists");
        return false;
        }
        else {
            this.btnsave.setEnabled(true);
        textfield.setBackground(Color.WHITE);
        textfield.setToolTipText("");
        return true;
        }
    
    }
    
}
