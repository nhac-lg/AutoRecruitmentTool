/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataobjects;

/**
 *
 * @author Eagle
 */
public class Recruiter {
    public String URL ="";
    public Account oAccount = null;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Account getoAccount() {
        return oAccount;
    }

    public void setoAccount(Account oAccount) {
        this.oAccount = oAccount;
    }
    
    public Recruiter(){
    }
    public Recruiter(String sURL, Account oAcc){
        URL = sURL;
        oAccount = oAcc;
    }
    
    
    
}
