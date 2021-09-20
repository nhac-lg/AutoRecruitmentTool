/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import common.Information;
import common.Utils;
import datacenter.DBServer;
import datacenter.Data;
import filter.Recruitment;
import filter.Recruitment_VietNamWork;
import gui.App;
import javafx.application.Application;
import selenium.SelServices;
/**
 *
 * @author Eagle
 */
public class Main {
    public static void main(String args[]){
        
        InitApp();
        Application.launch(App.class, args);
        
    }
    
    private static void InitApp(){
        //Utils.ReadXML();
        Data.loadDefinitionData();
    }
    
 
}
