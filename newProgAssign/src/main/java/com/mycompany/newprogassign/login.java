/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newprogassign;

/**
 *
 * @author Bohal
 */
public class login {
    
    //method for checking user name
    public boolean checkUsername(String username){
        return username.contains("_") && username.length() <=5;
    }
    //method for checking the password
     public boolean checkPasswordComplexity (String password) {
         return password.matches(".*[0-9].*")&& password.matches(".*[A-Z].*") && password.length() >=8 && password.matches(".*[!@#$.*]");
     }
     //method for checking the cellphone
        public boolean checkCellphoneNumber (String CellphoneNumber){
         return CellphoneNumber.matches("^\\+\\d{1,3}\\d{1,10}$");
        }
         //method for checking the password,username
    public String registerUser (String username, String password) {
        if (username == null || !(username.contains("_") && username.length() <=5 )){
            return "The password is correctly formatted";
        }else if (!checkPasswordComplexity(password)) {
            return "The password is incorrect";
        }else {
            return " The Conditions have been met";
        }
        //this method verifys the login details matchs the details in the user registers
    }
        public boolean loginUser (String Password,String Username){
            return Username.equals(Username) && Password.equals(Password);
        }
//The message when login successful and when its not
          public String returnLoginStatus(boolean loginUser){
            if (loginUser) {
                return "A successful login";
        } else {
                return "A failed login";
            }
        }
}

