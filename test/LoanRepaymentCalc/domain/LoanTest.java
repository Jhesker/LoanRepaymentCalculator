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
public class LoanTest {
    

    @Test
    public void testLoan() {
        Loan loan = new Loan();
        // test Apr
        loan.setApr(0);
        loan.setLoanType("Sub");
        loan.setLoanAmount(100.00);
        loan.setLoanGroup("g");
        loan.setLoanHolder("Sallie mae");
        loan.setLoanName("loanTest");
        boolean result = loan.validate();
        assertFalse(result);
        // test loanAmount
        loan.setApr(2.4);
        loan.setLoanAmount(0);
        loan.setLoanType("Sub");
        loan.setLoanGroup("g");
        loan.setLoanHolder("Sallie mae");
        loan.setLoanName("loanTest");
        result = loan.validate();
        assertFalse(result);
        //test loanGroup
        loan.setApr(2.4);
        loan.setLoanAmount(100.00);
        loan.setLoanGroup("");
        loan.setLoanType("Sub");
        loan.setLoanHolder("Sallie mae");
        loan.setLoanName("loanTest");
        result = loan.validate();
        assertFalse(result);
        //test loan holder
        loan.setApr(2.4);
        loan.setLoanType("Sub");
        loan.setLoanAmount(100.00);
        loan.setLoanGroup("G");
        loan.setLoanHolder("Sal");
        loan.setLoanName("loanTest");
        result = loan.validate();
        assertFalse(result);
        //test loan name
        loan.setApr(2.4);
        loan.setLoanType("Sub");
        loan.setLoanAmount(100.00);
        loan.setLoanGroup("G");
        loan.setLoanHolder("Sallie mae");
        loan.setLoanName("lo");
        result = loan.validate();
        assertFalse(result);
        //test for true
        loan.setApr(2.4);
        loan.setLoanType("Sub");
        loan.setLoanAmount(100.00);
        loan.setLoanGroup("G");
        loan.setLoanHolder("Sallie mae");
        loan.setLoanName("loanTest");
        result = loan.validate();
        assertTrue(result);
        
    }
    
}
