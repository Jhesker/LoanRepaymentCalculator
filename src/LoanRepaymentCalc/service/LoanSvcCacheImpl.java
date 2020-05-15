/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanRepaymentCalc.service;

import LoanRepaymentCalc.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jake
 */
public class LoanSvcCacheImpl implements ILoanSvc{
    
    private List<Loan> loanCache = new ArrayList<>();
    private int nextId = 0;
    
    public Loan create(Loan loan){
        loan.setId(++nextId);
        loanCache.add(loan);
        return loan;
    }
    
    public List<Loan> retrieveAll(){
        return loanCache;
    }
    
    public Loan update (Loan loan){
        for(int i = 0; i < loanCache.size(); i++){
            Loan next = loanCache.get(i);
            if(next.getId() == loan.getId()){
                loanCache.set(i, loan);
                break;
            }
        }
        return loan;
    }
    
    public Loan delete (Loan loan){
        for(int i = 0; i < loanCache.size(); i++){
            Loan next = loanCache.get(i);
            if(next.getId() == loan.getId()){
                loanCache.remove(i);
                break;
            }
        }
        return loan;
    }
}
