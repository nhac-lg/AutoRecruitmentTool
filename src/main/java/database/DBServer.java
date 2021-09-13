/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import dataobjects.*;


/**
 *
 * @author Eagle
 */
public class DBServer {
    public Account SrvAcc;
    
    public boolean ConnectServ(){
        return true;
    }
            
    public boolean AddCandidate(Candidate oCandidate)
    {
        return true;
    }    

    public boolean AddUser(User oUser){
        return true;
    }
    
    public boolean UpdInfo_Candidate(String id, Candidate oCandidate){
        return true;
    }
}
