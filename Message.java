/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ssbohale;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author bohal
 */

 //Declaration
public class Message {
        //AbstractStringBuilder username;
    public boolean checkMessageID(String messageID){
        if (messageID == null){
            return false;
        }
        int maxLength = 250;
        return messageID.length() <= maxLength;
    }
   public int checkRecipientCell(String phoneNumber) {
       int length = 13;
       
       if (phoneNumber == null) {
            return 1; // Error
        }
       else if (phoneNumber.length() > length) {
            return 2; // the number is short
        }
       else if (phoneNumber.startsWith("+27")) {
            return 3;
        }
        return 0; // inValid cell number.
   }
   public String messageHash(String message){
       if (message == null){
           throw new IllegalArgumentException("It has to contain a message HAsh");
       }
       return "00:0:" + message.toUpperCase();
   }
    public String sendMessage(String option, String message) {
        if ("send".equalsIgnoreCase(option) && message != null && !message.isEmpty()) {
            return "Message successfully sent.";
        }
        return "Message failed to send.";
    }

   public String sentMessage(String option, String message) {
        if (option == null || message == null) {
            throw new IllegalArgumentException("Option and message cannot be null.");
        }
        switch (option.toLowerCase()) {
            case  "send":
                return "Message successfully sent.";
            case "store":
                return "Message successfully stored.";
            case "disregard":
                return "Press 0 to delete message.";
            default:
                return "Invalid option.";
        }
   }
        // List that keeps messages sent dwhile runnning
    private final List<String> messages = new ArrayList<>();

    public void addMessage(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Type a message");
        }
        messages.add(message);
    }
    public String printMessages(){
        return messages.stream()
                .collect(Collectors.joining("\n"));
    }
    public int returnTotalMessages(){
        return messages.size();
    }
    public String storeMessage() {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (int i = 0; i < messages.size(); i++) {
            json.append("\"").append(json(messages.get(i))).append("\"");
            if (i < messages.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }
    private String json(String json){
        return json.replace("", "");  
    }
    
    }

        
  
 
    




    

    
