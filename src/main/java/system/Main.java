/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import database.DBServer;

/**
 *
 * @author Eagle
 */
public class Main {
    public static void main(String args[]){
        System.out.println("Hello application !!!!");
        
         InitApp();
    }
    
    private static void InitApp(){
       
    }
    private static void connectDB(String username, String password, String db_url){
        DBServer db= new DBServer();
        db.setDatabase(username, password, db_url);
        if(db.connect()){

        }else{
            System.out.println("Database connect failed");
        }
    }
}
