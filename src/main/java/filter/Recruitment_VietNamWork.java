/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import common.Information;
import dataobjects.Candidate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.SelServices;

/**
 *
 * @author Eagle
 */
public class Recruitment_VietNamWork extends Recruitment {

    public static boolean existsElementbyid(String id) {
        try {
            SelServices.oDriver.findElement(By.id(id));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public static boolean existsElementbyxpath(String xpath) {
        try {
            SelServices.oDriver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public static void find_login(String username, String pass) {
        SelServices.oDriver.findElement(By.id("username")).sendKeys(username);
        SelServices.oDriver.findElement(By.id("password")).sendKeys(pass);
        SelServices.oDriver.findElement(By.id("btnLogin")).click();
    }

    public void Navigate() {
        String title = "VietnamWorks - Top employment and recruitment website in Vietnam.";
        SelServices.oDriver.manage().window().maximize();
        SelServices.oDriver.get(Information.Browser);
        if (SelServices.oDriver.getTitle().equals(title)) {
            System.out.println("Page VietNamWork exits");
        } else {
            System.out.println("Page VietNamWork doesn't exits");
        }
    }

    public boolean Login() {
        if (existsElementbyid("btnLogin")) {
            find_login(Information.User, Information.Pass);
            return true;
        }
        return false;
    }

    public void clicksearch() {
        SelServices.oDriver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[2]/span[1]")).click();
    }

    public static boolean set_categori(String text) {
        SelServices.oDriver.findElement(By.xpath("//input[@placeholder='Choose categories...']")).sendKeys(text);
        List<WebElement> List = SelServices.oDriver.findElements(By.xpath("//ul[@id='select2-category-results']/li"));
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    public static boolean set_working_location(String text) {
        SelServices.oDriver.findElement(By.xpath("//input[@placeholder='Choose locations...']")).sendKeys(text);
        List<WebElement> List = SelServices.oDriver.findElements(By.xpath("//ul[@id='select2-location-results']/li"));
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    public static boolean set_home_address(String text) {
        SelServices.oDriver.findElement(By.xpath("//span[@id='select2-homeaddress-container']")).click();
        SelServices.oDriver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='textbox']"))
                .sendKeys(text);
        List<WebElement> List = SelServices.oDriver.findElements(By.xpath("//ul[@id='select2-homeaddress-results']"));
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    public static boolean set_last_resume(String text) {
        SelServices.oDriver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/"
                + "div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/span[1]/span[1]/span[1]/span[1]")).click();
        List<WebElement> List = SelServices.oDriver.findElements(By.xpath("//*[@class='select2-results__options']/li"));
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    public static boolean set_job_level(String text) {
        SelServices.oDriver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/"
                + "div[1]/div[1]/div[1]/div[1]/div[2]/div[8]/span[1]/span[1]/span[1]/span[1]")).click();
        List<WebElement> List = SelServices.oDriver.findElements(By.xpath("//*[@class='select2-results__options']/li"));
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    static int count = 0;

    public static void all_print(int n) throws Exception {
        do {
            String MainWindow = SelServices.oDriver.getWindowHandle();
            System.out.println("Main window handle is " + MainWindow);
            WebDriverWait wait = new WebDriverWait(SelServices.oDriver, 10);
            List<WebElement> list = SelServices.oDriver
                    .findElements(By.xpath("//div[@class='list-resume']/div/div/div/div[2]"));
            wait.until(ExpectedConditions
                    .visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='list-resume']/div/div/div/div[2]")));
            System.out.println("so luong: " + (list.size() + count));
            for (int j = 0; j < list.size(); j++) {
                if (count < n) {
                    //String v = list.get(j).getText();
                    //ds.add(handing_string(v));
                    WebElement view = SelServices.oDriver.findElement(By.xpath("//body/div[8]/div[1]/div[1]/div[1]/div[2]/div[2]/div["
                            + (j + 1) + "]/div[1]/div[1]/div[3]/div[1]/a[1]"));
                    view.click();
                    ArrayList<String> newTab = new ArrayList<String>(SelServices.oDriver.getWindowHandles());
                    SelServices.oDriver.switchTo().window(newTab.get(1));
                    Thread.sleep(2000);
                    String src="";
                    List<WebElement> list1 = SelServices.oDriver.findElements(By.xpath("//iframe[@id='resumeIframe']"));
                    if (list1.size() > 0) {
                        System.out.println(SelServices.oDriver.findElement(By.xpath("//iframe[@id='resumeIframe']")).getAttribute("src"));
                        src=SelServices.oDriver.findElement(By.xpath("//iframe[@id='resumeIframe']")).getAttribute("src");
                        SelServices.oDriver.close();
                        SelServices.oDriver.switchTo().window(MainWindow);
                    } else {
                        System.out.println("no src");
                        SelServices.oDriver.close();
                        SelServices.oDriver.switchTo().window(MainWindow);
                    }
                    String v = list.get(j).getText()+"\\r?\\n"+src;
                    Recruitment.lstCandidates.add(handing_string(v));
                    JavascriptExecutor js = ((JavascriptExecutor) SelServices.oDriver);
                    js.executeScript("arguments[0].scrollIntoView();", view);
                    Thread.sleep(2000);
                }
                count++;
            }
            JavascriptExecutor js = ((JavascriptExecutor) SelServices.oDriver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebElement next = SelServices.oDriver
                    .findElement(By.xpath("//li[@class='page-item page-nav page-next']//a[@class='page-link']/i"));
            next.click();
            Thread.sleep(3000);
        } while (count < n);
    }

    public static Candidate handing_string(String str) {
        String name = "", pos = "", company = "", year = "", salary = "", location = "",link="";
        String[] lines = str.split("\\r?\\n");
        for (int i = 0; i < lines.length; i++) {
            name = lines[0];
            pos = lines[1];
            if (lines[i].equalsIgnoreCase("Latest company:")) {
                company = lines[i + 1];
            }
            if (lines[i].equalsIgnoreCase("Years of experience: ")) {
                year = lines[i + 1];
            }
            if (lines[i].equalsIgnoreCase("Expected salary:")) {
                salary = lines[i + 1];
            }
            if (lines[i].equalsIgnoreCase("Locations:")) {
                location = lines[i + 1];
            }
            link=lines[lines.length-1];
        }
        Candidate c = new Candidate(name, pos, company, year, salary, location, link);
        return c;
    }
    @Override
    public List<Candidate> Filter() {
        //Step 1: check page vietnamwork
        Navigate();
        //Step 2: check login or not
        if (Login() == true) {
            System.out.println("Login successful");
        } else {
            System.out.println("Logged in");
        }
        //Step 3: click search candidate
        if (existsElementbyxpath("//header/nav[1]/div[1]/div[1]/a[2]/span[1]")) {
            clicksearch();
        }
        Recruitment.lstCandidates= new ArrayList<>();
        try {
            all_print(2);
        } catch (Exception ex) {
            Logger.getLogger(Recruitment_VietNamWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Recruitment.lstCandidates;
    }

}
