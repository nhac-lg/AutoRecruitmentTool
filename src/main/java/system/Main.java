/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import common.Information;
import common.Utils;
import database.DBServer;
import selenium.SelServices;
/**
 *
 * @author Eagle
 */
public class Main {
    public static void main(String args[]){
        System.out.println("Hello application !!!!");
        SelServices sel= new SelServices();
        InitApp();
        
    }
    
    private static void InitApp(){
        Utils.ReadXML();
        System.out.println(Information.lstRecruiter.size());
        Information.Browser=Information.lstRecruiter.get(0).getURL() ;
        Information.Username=Information.lstRecruiter.get(0).oAccount.getAccName() ;
        Information.Password=Information.lstRecruiter.get(0).oAccount.getPW() ;
        System.out.println(Information.Browser);
        System.out.println(Information.Username);
        System.out.println(Information.Password);
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
