/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import common.Information;
import common.Utils;
import database.DBServer;
import filter.Recruitment;
import filter.Recruitment_Local;
import filter.Recruitment_VietNamWork;
import selenium.SelServices;
/**
 *
 * @author Eagle
 */
public class Main {
    public static void main(String args[]){
        System.out.println("Hello application !!!!");
        InitApp();
        SelServices se= new SelServices();
        String src="vietnamwork";
        //choose source trên GUI 
        Recruitment re;
        if(src.equalsIgnoreCase("vietnamwork")){
            re= new Recruitment_VietNamWork();
            re.Filter();
        }else{
            System.out.println("no find");
        }
        //Recruitment re= new Recruitment_VietNamWork();
        //re.Filter();
        //System.out.println("so luong: "+re.Filter().size());
    }
    
    private static void InitApp(){
        Utils.ReadXML();
        System.out.println(Information.lstRecruiter.size());
//        if(Utils.find("vietnamwork")!=null){
//            Information.Browser=Utils.find("vietnamwork").getURL();
//            Information.User=Utils.find("vietnamwork").getoAccount().getAccName();
//            Information.Pass=Utils.find("vietnamwork").getoAccount().getPW();
//        }else{
//            System.out.println("Recruiter doesn't exits");
//        }
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
