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
public class Login {
    // Object Attributes
    private String userName = "";
    private String password = "";
    private final int MinLength = 7;

    //Geters and setters for object attributes

    /**
     *
     * @return Username
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String UN) {
        this.userName = UN;
    }

    /**
     *
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String PW) {
        this.password = PW;
    }
    
    /*
    Login Validation methos used to validate 
    */

    /**
     *Password cannot be the same as the user name and the password must also 
     * contain @ least 7 characters or the validation will be failed(false
     * returned)
     * @return boolean
     */

    public boolean validate() {
        if(userName == null || userName.equals("")){
            userName = null;
            return false;
        }
        if (password == null || password.equals("") || password.length() < MinLength ||
                password == userName) {
            password = null;
            return false;
        }
        if(!password.matches(".*\\d.*")){
            password = null;
            return false;
        }
        return true;
    }
    
    @Override
        public boolean equals(Object obj){
            if(obj == null) return false;
            if(!(obj instanceof Login)) return false;
            Login login = (Login)obj;
            if(!this.userName.equals(login.getUserName())) return false;
            if(!this.password.equals(login.getPassword())) return false;
            return true;
    }
    
}
