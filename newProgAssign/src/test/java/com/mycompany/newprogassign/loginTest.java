/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.newprogassign;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Bohal
 */
public class loginTest {
login input = new login();

    public loginTest() {
    }
 @Test
 public void checkUserName(){
    
    assertTrue(input.checkUsername("kyl_1"));
    assertFalse(input.checkUsername("kyle!!!!!!!"));
}
  @Test
 public void checkPasswordComplexity() {
    
    assertTrue(input.checkPasswordComplexity("Ch&&sec@ke99!"));
    assertFalse(input.checkPasswordComplexity("password"));
 }
 @Test
 public void checkPhoneNumber(){
    
    assertTrue(input.checkCellphoneNumber("+27838968976"));
    assertFalse(input.checkCellphoneNumber("08966533"));
}
 @Test
 public void testReturnStatus(){
    
    String expected = "A successful login.";
    String actual = input.returnLoginStatus(true);
    assertEquals(expected,actual);
}
 @Test
 public void testReturnStatusFailed(){
    
    String expected = "A failed login.";
    String actual = input.returnLoginStatus(false);
    assertEquals(expected,actual);
    
   } 
}
