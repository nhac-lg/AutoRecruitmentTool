/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Eagle
 */
public class SelServices {
    public static String driverType = "chrome";
    public static Object oDriver = null;

    public SelServices() {
        InitSelEnv();
    }

    private void InitSelEnv() {
        if (driverType == "chrome") {
            WebDriverManager.chromedriver().setup();
            oDriver = new ChromeDriver();
        }
        if (driverType == "firefox") {
            WebDriverManager.firefoxdriver().setup();
            oDriver = new FirefoxDriver();
        }
    }
}
