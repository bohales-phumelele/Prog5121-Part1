package com.mycompany.ssbohale;

import java.io.FileWriter;
import java.util.regex.*;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import java.io.FileWriter;
//Handles saving errors
import java.io.IOException;
//Creates random Message ID
import java.util.Random;

public class SSBohale {

    public static void main(String[] args) {
        //Declaration
        
        // Welcome messages
        UIManager.put("OptionPane.okButtonText", "Continue");
        JOptionPane.showMessageDialog(
                null, "Welcome to ChatApp");
        
        UIManager.put("OptionPane.okButtonText", "OK");
        JOptionPane.showMessageDialog(
                null, "Click here to Register and Login-in.");
        
        UIManager.put("OptionPane.okButtonText", "Continue");
        JOptionPane.showMessageDialog(
                null, "Create an account by entering a username, password, and South African cellphone number.");
        
        // Get first and last name
        String firstname;
        firstname = JOptionPane.showInputDialog(
                null, "Please enter your first name");
        String lastname;
        lastname = JOptionPane.showInputDialog(
                null, "Please enter your last name");
        
        // The username must contain an underscore and be no more than five characters in length.
        String username;
        username = JOptionPane.showInputDialog(
                null, "Please enter your username");
        if (username != null 
                && username.contains("_") 
                && username.length() <= 5) {
            JOptionPane.showMessageDialog(
                    null, "Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(
                    null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
        }
        
        // Prompt the user to enter the password 
        String password = JOptionPane.showInputDialog(
                null, "Please enter a password");
        if (password != null &&
            password.length() >= 8 &&
            password.matches(".*[A-Z].*") &&
            password.matches(".*[0-9].*") &&
            password.matches(".*[!@#$%].*")) {
            
            JOptionPane.showMessageDialog(
                        null, "Password successfully captured");
        } else {
            JOptionPane.showMessageDialog(
                        null, "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }
        
        // Get cellphone number and validate with regex:
        String phoneNumber = JOptionPane.showInputDialog(
                null, "Please enter your cellphone number.");
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        
        
        if (phoneNumber != null && matcher.matches() && phoneNumber.length() == 12) {
            JOptionPane.showMessageDialog(
                        null, "Cellphone number successfully added");
        } else {
            JOptionPane.showMessageDialog(
                        null, "Cellphone number incorrectly formatted or does not contain international code");
        }
        
        // Verifying if the details are correct or not
        if (username != null && username.contains("_") && username.length() <= 5 &&
            password != null && password.length() >= 8 &&
            password.matches(".*[A-Z].*") &&
            password.matches(".*[0-9].*") &&
            password.matches(".*[!@#$%].*") &&
            phoneNumber != null && phoneNumber.matches("^\\+\\d{1,3}[ -]?\\d{10}$")) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstname + " " + lastname + " it is great to see you again.");
            
                    
        }
//part 2 begins
        JOptionPane.showMessageDialog(
                null, "Welcome to QuickChat.");
        
        
        // Ask the user how many messages they would wnat to send
        String numMessages;
        numMessages = JOptionPane.showInputDialog(
                null, "How many messages would you like to send?");
        
        int limit = 0;
        try {
            limit = Integer.parseInt(numMessages);
            if (limit <=0){
                JOptionPane.showMessageDialog(
                            null, "Invalid number.\n Try again!!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(
                    null, "Please enter a number greater than 0.");
        }
             // Options for the input dialog
        String[] options = {"1) Send message", "2) Show recently sent messages", "3) Quit"};
        String selectedOption;
        
            // Create a MessageTracker instance to manage messages
        //
        MessageTracker tracker = new MessageTracker();
            // Checks if the message is sent or stored or disregarded
                int msgProcessed = 0;   
                // checks the sent messagesd
                int msgSent = 0;
        while (true) {

        
            Object result = JOptionPane.showInputDialog(
                    null,
                    "Choose an option below",
                    "Welcome user",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            // Exit if the user cancels the dialog
            if (result == null) {
                break;
            }
            //for(int msgProcessed = 0, msgSent = 0; msgProcessed < limit){    
            selectedOption = result.toString();
            // if the user selects quit the program must exit
            if (selectedOption.contains("3) Quit")) {
                JOptionPane.showMessageDialog(
                        null, "Total messages sent: " + msgSent);
                // A goodbye message must dispaly and breaks thee loop.
                JOptionPane.showMessageDialog(
                        null, "Thank you for using QuickChat. Goodbye!");
                    break;
            }
            else if (selectedOption.contains("1) Send message")) {
                if (msgProcessed < limit) {
                        boolean sent = sendOneMessage(tracker, msgSent + 1);
                        msgProcessed++;
                        if (sent) {
                            msgSent++;
}
                    } else {
                       JOptionPane.showMessageDialog(
                               null, "You have reached your message limit."
                                + "\n Please try again.");
                        }
                } else if (selectedOption.contains("2) Show recently sent messages")) {
                    JOptionPane.showMessageDialog(
                            null, "Coming soon.");
                }
            }
    }
        private static boolean sendOneMessage(MessageTracker tracker,int messageNumber) {
        String recipient;
            recipient = JOptionPane.showInputDialog(
                    "Enter recipient phone number ( :");
                if (recipient == null) 
                    return false;
                    

            if (!recipient.matches("^\\+\\d{10,13}$")) {
                JOptionPane.showMessageDialog(
                        null, "Invalid phone number.");
                    return false;
        }
            
            int sent = 0;
            
            {
        String message;
            message = JOptionPane.showInputDialog("Enter your message( " + + sent + "):");
                if (message == null || message.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null, "Message is empty.");
                        return false;
        }
            
        // If the message length is 50 or more, reprompt until it is shorter.
        while (message.length() >= 250) {
            message = JOptionPane.showInputDialog("Message exceeds 250 characters. Please re-enter your message (less than 50 characters):");
            if(message == null || message.trim().isEmpty()){
                JOptionPane.showMessageDialog(
                        null, "Message is empty.");
                return false;
            }
        }
            
        
        // Ask the user to choose an action for the message.
        Object[] actions = {"Send Message", "Disregard Message", "Store Message to send later"};
        int action = JOptionPane.showOptionDialog(
                null,
                "Choose an action for this message:",
                "Message Option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                actions,
                actions[0]
        );
        
        if ( action == 0 ){
            //Used to create a 10 digit tandom number
            int messageId;
            messageId = (int)(Math.random()* 9000) + 1000000000;
            String messageHash = messageHarsh(messageId, messageNumber, message);
        tracker.addMessage("To " + recipient + ": " + message);
        
        // if the user selects sent the must must display the following.
        JOptionPane.showMessageDialog(
                null, "Message ID: "+ messageId + 
                "\n" + "Message Hash: " + messageHash + "\n" + "Recipient: " + recipient + 
                "\n" + "Message: " + 
                message);
        JOptionPane.showMessageDialog(null, "Message sent");
        return true;
    } else if (action == 1) {
        JOptionPane.showMessageDialog(null, "Message disregared");
        return false;
    } 
    else if (action == 2){
        JOptionPane.showMessageDialog(null, "Message is stored for " + recipient + ": " + message);
        return false;
    }
            }
            return true;
        }
            
public static String messageHarsh(int messageId, int messageNumber, String message){
    //Convert messageId to a String and take its first two digits.
        // If the messageId digits are less than 2, pad with leading zeros.
        String hash = Integer.toString(messageId);
        String firstTwo;
        if (hash.length() >= 2) {
            firstTwo = hash.substring(0, 2);
        } else {
            // Pad with leading zeros if necessary (e.g., 0 becomes "00")
            firstTwo = String.format("%02d", messageId);
        }


        // Convert message number to string.
        String messageNumberStr = Integer.toString(messageNumber);

        // Split the message into words.
        String[] words = message.trim().split("\\s+");
        if (words.length == 0) {
            // If for any reason the message is empty, return just the id and message number parts.
            return firstTwo + ":" + messageNumberStr + ":";
        }
        // Get the first and last words.
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        // Concatenate and change to upper case.
        String combinedWords = (firstWord + lastWord).toUpperCase();

        // Build the final hash.
        return firstTwo + ":" + messageNumberStr + ":" + combinedWords;
    }

     private String generateRandomMessageID() {
            long messageId = (long)(Math.random() * 9000000000L) + 1000000000L;
            return String.format("%010d", messageId);
     }
}



// Mock message tracker class
class MessageTracker {
    java.util.List<String> messages = new java.util.ArrayList<>();

    void addMessage(String msg) {
        messages.add(msg);
    }

    void displayMessages() {
        if (messages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages sent yet.");
            return;
        }

        StringBuilder sb = new StringBuilder("Recently Sent Messages:\n");
        for (String msg : messages) {
            sb.append(msg).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
    // --- NEW FEATURE: Save messages to a real JSON file ---
   public void storeMessage(String messageHash, String recipient, String messageText, String messageID) {

        try {

            //Create JSON File
            FileWriter file = new FileWriter("messages.json", true);

            //Write into JSON file
            file.write("{\n");
           
            file.write("\t\"MessageID\": \"" + messageID + "\",\n");
            file.write("\t\"MessageHash\": \"" + messageHash + "\",\n");
            file.write("\t\"Recipient\": \"" + recipient + "\",\n");
            file.write("\t\"Message\": \"" + messageText + "\"\n");
            file.write("}\n\n");

            //Close File
            file.close();
         //The import
        } catch (IOException e) {
        
            JOptionPane.showMessageDialog(null,"Error saving message.");
    }
   }
}
   /*This is a new assiagnment that i turned scanner to Joption pane..so part 1 is imported here as Joption not scanner just like the 
    first part 1
    */


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

-Math and Science(intoducing java methods)[YouTube] Published(2021)
 -https://www.youtube.com/watch?v=ejI4iHiumrg
 -Accessed 5 April 2026
 
 */     
        
 
