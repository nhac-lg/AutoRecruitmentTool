/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

/**
 *
 * @author Eagle
 */
public class SelServices {
    public static Object oDriver = null; 
    
    public SelServices(){
        InitSelEnv("");
    }
    //sBrower is empty, the app will choose default browser of the machine 
    private boolean InitSelEnv(String sBrowser){
        return true;
    }
    
    
}
