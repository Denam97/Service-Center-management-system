/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceCenter;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ravindu
 */
public class Validations {
    //    returns true if ends with '.com' and contains only one '@'
    public boolean validateEmail(String input) {
        if (input.endsWith(".com") && countCharacter(input, '@') == 1) {
            return true;
        }
        return false;
    }
    public boolean validateEmail_v(String input) {
        if (input.endsWith(".com") && countCharacter(input, '@') == 1) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Invalid E-mail", "Error", 0);
        
        return false;
    }
//    returns true for alphanumeric inputs
    public boolean isAlphaNumeric(String input){
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }
    
//    returns true if input only contains letters
    public boolean isTextOnly(String input){
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
//    returns true if input is alpha numeric except for dash
    public boolean dash_only(String input){
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c) && !Character.isLetter(c) && c != '-') {
                return false;
            }
        }
        return true;
    }
    
//    returns true if NIC is valid
    public boolean validateNIC(String input){
        if(!(input.endsWith("V") || input.endsWith("v")) || input.length() != 10){
            return false;
        }
        for (int i = 0; i < input.length() - 1; i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        
        return true;
    }
    

     public boolean validateNIC_v(String input){
        if(!(input.endsWith("V") || input.endsWith("v")) || input.length() != 10){
            JOptionPane.showMessageDialog(null, "Invalid NIC", "Error", 0);
            return false;
        }
        for (int i = 0; i < input.length() - 1; i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                JOptionPane.showMessageDialog(null, "Invalid NIC", "Error", 0);
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isEmptyField(JTextField field, String err){
        if (field.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, (err + " cannot be empty"), "Error", 0);
            field.grabFocus();
            return true;
        }
        return false;
    }
    private int countCharacter(String text, char key){
        int count = 0;
        char c;
        
        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (c == key) {
                count++;
            }
        }
        return count;
    }
    public boolean ValidatePhone(String input){
        if(input.length() != 10){
            JOptionPane.showMessageDialog(null, "Invalid phone number ");
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            char c=input.charAt(i);
            if(!Character.isDigit(c)){
                 JOptionPane.showMessageDialog(null, "Invalid phone number ");
                return false;
            }
        }
        return true;
    }
}
