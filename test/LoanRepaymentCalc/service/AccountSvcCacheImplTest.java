/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanRepaymentCalc.service;

import LoanRepaymentCalc.domain.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jake
 */
public class AccountSvcCacheImplTest {
    
    public AccountSvcCacheImplTest() {
    }

    @Test
    public void testCRUD() {
        //AccountSvcCacheImpl impl = new AccountSvcCacheImpl();
        AccountSvcCacheImpl impl = AccountSvcCacheImpl.getInstance();
        List<Account> accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 0);
        
        Account account = new Account();
        account.setEmail("jhesker@gmail.com");
        Login login = new Login();
        account.setLogin(login);
        // testing create
        account = impl.create(account);
        assertNotNull(account);
        assertNotEquals(account.getId(), 0);
        
        //test retrieveAll
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        //testing update
        account.setEmail("jhesker@regis.edu");
        account = impl.update(account);
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        assertEquals(account.getEmail(), "jhesker@regis.edu");
        //test delete
        account = impl.delete(account);
        assertEquals(accounts.size(), 0);
        
        Account account1 = new Account();
        account1.setEmail("jhesker@gmail.com");
        Login login1 = new Login();
        login1.setUserName("jhesker");
        login1.setPassword("1234567");
        account1.setLogin(login1);
        account1 = impl.create(account1);
        assertNotNull(account1);
        
        Account account2 = new Account();
        account2.setEmail("rstar@regis.edu");
        Login login2 = new Login();
        login2.setUserName("RingoStar");
        login2.setPassword("1234567");
        account2.setLogin(login2);
        account2 = impl.create(account2);
        assertNotNull(account2);
        
        Login login3 = new Login();
        login3.setUserName("11");
        login3.setPassword("123");
        Account authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);   // doesn't exist, so should be null
        
        login3.setUserName("jhesker");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);   // doesn't exist, so should be null
        
        login3.setPassword("1234567");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);    // exists, should not be null
        
        login3.setUserName("jmcdoee");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);   // doesn't exist, so should be null
        
        login3.setPassword("7890123");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);   // doesn't exist, so should be null
        
        login3.setUserName("RingoStar");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);   // doesn't exist, so should be null
        login3.setPassword("1234567");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);    // exists, should not be null
    }
    
}
