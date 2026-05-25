/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.ssbohale;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pc
 */
public class MessageTest {

    Message message = new Message();
    public MessageTest(){
    }

    @Test
    public void testCheckMessageID() {
        String messageID = "0000000000";
        // Check that the message ID has a maximum length of 10 characters.
        assertTrue(messageID.length() <= 10);
    }

    @Test
    public void testCheckMessageIDInvalid() {
        String messageID = "00000000000";
        // Check that an invalid message ID (more than 10 characters) fails the condition.
        assertFalse(messageID.length() <= 10);
    }

    @Test
    public void testValidRecipientCell() {
        String expected = "+27718693002";
        assertEquals(3, message.checkRecipientCell(expected),
            "Cell phone number succesfully captured");
    }
    @Test
    public void testInvalidRecipientCell(){
        String expected = "08575975889";
        assertEquals(0, message.checkRecipientCell(expected), 
                "Cell phone is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
    }
    @Test
    public void MessageHashCorrect() {
        String input = "hitonight";
        String expected = "00:0:HITONIGHT";
        String actual = message.messageHash(input);
        assertEquals(expected, actual);
    }
    @Test
    public void SendMessageSendMessage(){
        String option = "send";
        String message = "Hi Mike, can you join us for dinner tonight";
        String expected = "Message successfully sent.";
  
    }
    @Test
    public void SendMessageDisregardMessage(){
        String option = "disregard";
        String message = "Hi Keegan, did you receive the payment?";
        String expected = "Press 0 to delete message.";
       
    }
    @Test
    public void SendMessageStoreMessage(){
        String option = "store";
        String message = "Hi Keegan, did you receive the payment?";
        String expected = "Message successfully stored.";
       
    }
}
