/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteo.validators;


import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author SALIM
 */
public class EmailVerifier extends InputVerifier {
JButton okButton;
JLabel lblerror;
static Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public EmailVerifier(JButton okButton){
    this.okButton = okButton;
    this.lblerror = lblerror;
}
    @Override
    public boolean verify(JComponent input) {
        
        JTextField txtemail = (JTextField)input;
        validators v = new validators(txtemail.getText());
        if (txtemail.getText().isEmpty()){
            input.setBackground(Color.PINK);
            okButton.setEnabled(false);
        txtemail.setToolTipText("Field Cannot Be Empty");
        return false;
        }
        else if (!emailRegex.matcher(txtemail.getText()).matches()){
            input.setBackground(Color.PINK);
        txtemail.setToolTipText("Incorrect Email Format");
        okButton.setEnabled(false);
        return false;
        }
        else {
            input.setBackground(Color.WHITE);
            input.setToolTipText("");
            okButton.setEnabled(true);
        return true;
        }
        
    }
    
}
