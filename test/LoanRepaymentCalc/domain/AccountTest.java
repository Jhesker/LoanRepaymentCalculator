/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanRepaymentCalc.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jake
 */
public class AccountTest {
    
    public AccountTest() {
    }

    @Test
    public void testAccount() {
        Account account = new Account();
        boolean result = account.validate();
        assertFalse(result);
        account.setEmail("jheskergmail");
        result = account.validate();
        assertFalse(result);// check basic email
        result = account.validate();
        assertFalse(result);
        account.setEmail("jhesker@gmail.com");
        result = account.validate();
        assertFalse(result);
        account.setEmail("jhesker@gmail.com");
        result = account.validate();
        assertFalse(result);
        
        // need to have the Login tested as well
        Login login = account.getLogin();
        login.setUserName("jhesker");
        result = account.validate();
        assertFalse(result);
        
        login.setPassword("TestPassword1");
        result = account.validate();
        assertTrue(result);
    }
    
}
