/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanRepaymentCalc.domain;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import LoanRepaymentCalc.domain.*;

/**
 *
 * @author jhesk
 */
public class LoginTest {
    
    public LoginTest() {
    }
    @Test
    public void testValidate() {
        Login login = new Login();
        boolean result = login.validate();
        assertFalse(result);
        login.setUserName("JacobHesker");
        result = login.validate();
        assertFalse(result);
        login.setPassword("123456");
        assertFalse(result);
        login.setPassword("JacobHesker");
        result = login.validate();
        assertFalse(result);
        login.setPassword("TestPassword1");
        result = login.validate();
        assertTrue(result);
    }
    
    @Test
    public void testEquals(){
        Login login1 = new Login();
        login1.setUserName("jhesker");
        login1.setPassword("TestPassword1");
        
        Login login2 = new Login();
        login2.setUserName("lhesker");
        login2.setPassword("Test1234");
        
        assertFalse(login1.equals(login2));
        login2.setPassword("TestPassword1");
        assertFalse(login1.equals(login2));
        login2.setUserName("jhesker");
        assertTrue(login1.equals(login2));
    }
    
}
