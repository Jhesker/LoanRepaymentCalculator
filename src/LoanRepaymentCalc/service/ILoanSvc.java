/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanRepaymentCalc.service;

import LoanRepaymentCalc.domain.*;
import java.util.*;

/**
 *
 * @author jake
 */
public interface ILoanSvc {
    public Loan create(Loan loan);
    public List<Loan> retrieveAll();
    public Loan update(Loan loan);
    public Loan delete(Loan loan);
}
