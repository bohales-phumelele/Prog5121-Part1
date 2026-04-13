/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.newprogassign;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author Bohal
 */
public class NewProgAssign {

   

    public static void main(String[] args) {
        System.out.println("Welcome to the whatsapp chatBox!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("-|-|-> Registration <-|-|-");
        
        //Declaration
        //Prompt user to enter thier Username
        String Username;
       
        System.out.println("Create a username that contains an '_' and is no more than 5 characters long");
        Username = scanner.nextLine(); 
        if(Username.contains("_") && Username.length()<=5){
            System.out.println("Username succesfully captured");
        }else{
            System.out.println("Username incorrectly formatted; please ensure that your username contains an underscore and is no more than five characters in length. ");
        } 
         
        //Prompt user to enter thier password
        String Password ;
        
        System.out.println("Create a password it must contain atleast 8 characters,contain a capital letter,contain a number and a special character (example = @#$%^&*! and etc): ");
        Password = scanner.nextLine();
        if(Password.matches(".*[0-9].*")&& Password.matches(".*[A-Z].*") && Password.length() >=8 && Password.matches(".*[!@#$.%^&*]")) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted;please ensure that the password contains atleast eight characters,a capital letter,a number,and a special character.");
        }
      
        //Prompt user to enter thier cellphone number
        String CellphoneNumber ;
        
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Enter your cellphone number that starts +27 which must contain no more than ten characters (example +27671234567): ");
        CellphoneNumber = scanner.nextLine();
        Matcher matcher = pattern.matcher(CellphoneNumber);
        if(CellphoneNumber != null && matcher.matches() && CellphoneNumber.length() == 12 ){
            System.out.println ("Cell phone number successfully added");
        } else{
             System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        }

        //Asking for personal details
        //prompt user to enter thier firtname
        System.out.println(" Enter your firstname");
        String firstname = scanner.nextLine();
        
        //prompt user to enter thier lastname
        System.out.println(" Enter your lastname");
        String lastname = scanner.nextLine();
        
      //logining in
       Scanner input = new Scanner(System.in);
          
       System.out.println("-|-|-> LoGiN <-|-|-");
         for (int i = 1; i <= 3; i++) {
        
       System.out.println("Enter your username:");
       Username = input.nextLine();

       System.out.println("Enter your password:");
       Password = input.nextLine();
        
        if(Username.contains("_") && Username.length()<=5 && Password.matches(".*[0-9].*")&& Password.matches(".*[A-Z].*") && Password.length() >=8 && Password.matches(".*[!@#$.%^&*]")){
            System.out.println("Welcome " + firstname + " " + lastname + ", it is great to see you again.");
              break; //stops the loop if successful
        }else {
             System.out.println("Username or password incorrect, please try again.");
         }
      }
   }
}
    
 //-|-|-> Referrancing part <-|-|-
 /*
 - Name: Sphumelele
 - Assignment---> whatsapp chatBox.....for POE part 1 (prog5121)
 
 - W3Schools. Published(2024). 
 -https://www.w3schools.com/java/ref_string_matches.asp
 -Accessed 7 Appril 2026
 
 - GeeksforGeeks. Published(2023). 
 - https://www.geeksforgeeks.org/regular-expressions-in-java/
 -Accessed 25 March 2026
 
 -Bro Code  [YouTube] Published(2021)
 -https://www.youtube.com/watch?v=xk4_1vDrzzo
 -Accessed 2 April 2026
 
 -Sololearn. Published(2014)
 -https://www.sololearn.com/en/
 -Accessed 21 March 2026
        
 -Java Programming [TextBook]
 -Accessed from 26 February 2026
 
 */     
        
 
