/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Eagle
 */
public class SelServices {

    public static String driverType = "chrome";
    public static WebDriver oDriver = null;

    public SelServices() {
        InitSelEnv(driverType);
    }

    private void InitSelEnv(String sBrowser) {
        if (sBrowser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            oDriver = new ChromeDriver();
        }
        if (sBrowser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            oDriver = new FirefoxDriver();
        }
    }
}
