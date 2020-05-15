/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanRepaymentCalc.Presentation;

import java.util.*;
import LoanRepaymentCalc.domain.*;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author jake
 */
public class LoanTableModel extends AbstractTableModel{
    private String[] columnNames = {"Loan Name", "Loan Holder", "Loan Amount"};
    
    private List<Loan> loans = new LinkedList<Loan>();
    public void setLoans(List<Loan> loans){
        this.loans = loans;
    }
    
    // returns loan from a given row
    public Loan getLoan(int row){
        Loan loan = loans.get(row);
        return loan;
    }
    
    public List<Loan> azLoans(){
        loans.sort(Comparator.comparing(Loan:: getLoanName));
        return loans;
    }
    
    public List<Loan> zaLoans(){
        loans.sort(Comparator.comparing(Loan:: getLoanName).reversed());
        return loans;
    }
    public List<Loan> azInterestLoans(){
        loans.sort(Comparator.comparing(Loan:: getApr).reversed());
        return loans;
    }
    
    public List<Loan> zaInterestLoans(){
        loans.sort(Comparator.comparing(Loan:: getApr));
        return loans;
    }
    
    public List<Loan> azAmountLoans(){
        loans.sort(Comparator.comparing(Loan:: getLoanAmount).reversed());
        return loans;
    }
    
    public List<Loan> zaAmountLoans(){
        loans.sort(Comparator.comparing(Loan:: getLoanAmount));
        return loans;
    }
    @Override
    public int getRowCount(){
        return loans.size();
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int row, int column){
        Loan loan = loans.get(row);
        switch (column) {
            case 0:
                return loan.getLoanName();
            case 1:
                return loan.getLoanHolder();
            case 2:
                return loan.getLoanAmount();
        
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
}
