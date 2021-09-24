/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import common.Utils;
import datacenter.Data;
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
        new SelServices();
        Application.launch(App.class, args);
    }
    
    private static void InitApp(){
       Utils.ReadXML();
       Data.loadDefinitionData();
       
    }
    
 
}
