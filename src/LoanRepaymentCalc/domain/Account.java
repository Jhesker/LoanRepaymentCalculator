/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanRepaymentCalc.domain;

import java.util.*;

/**
 *
 * @author jake
 */
public class Account {
    private int Id = 0;
    private String email = "";
    private Login login = new Login();  
    private final int minSize = 7;
    private List<Loan> loans = new LinkedList<Loan>();
    private int nextId = -1;
    
    public Loan add(Loan loan){
        loan.setId(nextId++);
        loans.add(loan);
        return loan;
    }

    public List getLoans(){
        return loans;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    /**
     *email Getter
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *email Setter
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *Login Getter
     * @return login 
     */
    public Login getLogin() {
        return login;
    }

    /**
     *Login Setter
     * @param login
     */
    public void setLogin(Login login) {
        this.login = login;
    }
    
    /**
     *Validate ensures that email ends with .com, .net, or.edu.
     * none of the values are null, or empty strings. They must also be 
     * greater than the minimum character size of 7. the password must not be
     * the same as the username or the email. 
     * @return boolean 
     */
    public boolean validate(){
       
        if(email == null || email == "" || email.length() < minSize ||
                email.contains("@") == false){
            email = null;
            return false;
        } 
            
        
        // updated and added here
        if (login == null || !login.validate()) return false;
        if(loans == null) return false;
        
        return true;
        
    }
}
