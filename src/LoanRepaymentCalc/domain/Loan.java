/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanRepaymentCalc.domain;

/**
 *
 * @author jake
 */
public class Loan {
    private int id = 0;
    private double Apr = 0;
    private double loanAmount = 0;
    private String loanType = "";
    private String loanName = "";
    private String loanHolder = "";
    private String loanGroup = "";
    private final int minChar = 5;
    private final int minGroup = 1;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getApr() {
        return Apr;
    }

    public void setApr(double Apr) {
        this.Apr = Apr;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getLoanHolder() {
        return loanHolder;
    }

    public void setLoanHolder(String loanHolder) {
        this.loanHolder = loanHolder;
    }

    public String getLoanGroup() {
        return loanGroup;
    }

    public void setLoanGroup(String loanGroup) {
        this.loanGroup = loanGroup;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
   
    public boolean validate(){
        if(loanName == null || loanName == "" || 
                loanName.length() < minChar){
            loanName = null;
            return false;
        }
        if(loanGroup == null || loanGroup == "" ||
                loanGroup.length() < minGroup){
            loanGroup = null;
            return false;
        }
        if(loanHolder == null || loanHolder == "" || 
                loanHolder.length() < minChar){
            loanHolder = null;
            return false;
        }
        if (loanAmount == 0) {
            loanAmount = 0;
            return false;
        }
        if(loanType == null || loanType == ""){
            loanType = null;
            return false;
        }
        if(loanType.compareToIgnoreCase("sub") != 0 && 
                loanType.compareToIgnoreCase("unsub") != 0 &&
                loanType.compareToIgnoreCase("personal") != 0)return false;
      
        if(Apr == 0 || Apr < 0){
            Apr = 0;
            return false;
        }
        return true;
        
    }
    
}
