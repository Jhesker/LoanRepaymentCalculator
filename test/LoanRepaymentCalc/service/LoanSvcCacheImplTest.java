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
public class LoanSvcCacheImplTest {
    
    public LoanSvcCacheImplTest() {
    }

    @Test
    public void testLoanCRUD() {
        LoanSvcCacheImpl impl = new LoanSvcCacheImpl();
        List<Loan> loans = impl.retrieveAll();
        assertEquals(loans.size(), 0);
        
        Loan loan = new Loan();
        loan.setApr(2.25);
        loan.setLoanAmount(1000.00);
        loan.setLoanGroup("G");
        loan.setLoanHolder("Salle Mae");
        loan.setLoanName("Loan B");
        //testCreate
        loan = impl.create(loan);
        assertNotNull(loan);
        assertNotEquals(loan.getId(), 0);
        
        //test retrieveAll
        loans = impl.retrieveAll();
        assertEquals(loans.size(), 1);
        
        //testing update
        loan.setLoanGroup("F");
        loan = impl.update(loan);
        loans = impl.retrieveAll();
        assertEquals(loans.size(), 1);
        assertEquals(loan.getLoanGroup(), "F");
        
        //test delete 
        loan = impl.delete(loan);
        assertEquals(loans.size(), 0);
        
        
        
    }
    
}
