/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import common.Information;
import objmodels.Candidate;
import objmodels.Recruiter;
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

    Recruiter Recruiter_vnwork;
    By search = By.xpath("//header/nav[1]/div[1]/div[1]/a[2]/span[1]");
    By btnLogin = By.id("btnLogin");
    By user = By.id("username");
    By pass = By.id("password");
    By close = By.xpath("//button[@class='close']//span[@aria-hidden='true'][normalize-space()='×']");
    By categori = By.xpath("//input[@placeholder='Choose categories...']");
    By list_categori = By.xpath("//ul[@id='select2-category-results']/li");
    By input_working_location = By.xpath("//input[@placeholder='Choose locations...']");
    By list_working_location = By.xpath("//ul[@id='select2-location-results']/li");
    By home_address = By.xpath("//span[@id='select2-homeaddress-container']");
    By input_home_addr = By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='textbox']");
    By list_home_addr = By.xpath("//ul[@id='select2-homeaddress-results']");
    By last_resume = By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/span[1]/span[1]/span[1]/span[1]");
    By list_last_resume = By.xpath("//*[@class='select2-results__options']/li");
    By job_level = By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[8]/span[1]/span[1]/span[1]/span[1]");
    By list_job_level = By.xpath("//*[@class='select2-results__options']/li");
    By list_resume = By.xpath("//div[@class='list-resume']/div/div/div/div[2]");
    By link_src = By.xpath("//iframe[@id='resumeIframe']");
    By next_page = By.xpath("//li[@class='page-item page-nav page-next']//a[@class='page-link']/i");
    By input_year_from= By.xpath("//input[@class='rs-control year-from']");
    By input_year_to= By.xpath("//input[@class='rs-control year-to']");

    public Recruitment_VietNamWork() {
        Recruiter_vnwork = vnwork(Information.source);
    }

    private Recruiter vnwork(String vnwork) {
        for (Recruiter re : Information.lstRecruiter) {
            if (re.getName().equalsIgnoreCase(vnwork)) {
                return re;
            }
        }
        return null;
    }

    public boolean existsElementbyid(By id) {
        try {
            SelServices.oDriver.findElement(id);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean existsElementbyxpath(By xpath) {
        try {
            SelServices.oDriver.findElement(xpath);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean NavigateTome() {
        String title = "VietnamWorks - Top employment and recruitment website in Vietnam.";
        SelServices.oDriver.manage().window().maximize();
        SelServices.oDriver.get(Recruiter_vnwork.getURL());
        if (SelServices.oDriver.getTitle().equals(title)) {
            System.out.println("Page VietNamWork exits");
            return true;
        }
        return false;
    }

    public boolean Login() {
        if (existsElementbyid(btnLogin)) {
            SelServices.oDriver.findElement(user).sendKeys(Recruiter_vnwork.getoAccount().getAccName());
            SelServices.oDriver.findElement(pass).sendKeys(Recruiter_vnwork.getoAccount().getPW());
            SelServices.oDriver.findElement(btnLogin).click();
            return true;
        }
        return false;
    }

    public boolean clicksearch() {
        WebDriverWait wait = new WebDriverWait(SelServices.oDriver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(close));
        SelServices.oDriver.findElement(close).click();
        if (existsElementbyxpath(search)) {
            SelServices.oDriver.findElement(search).click();
            return true;
        }
        return false;
    }

    public boolean set_year_exp(String from, String to) {
        SelServices.oDriver.findElement(input_year_from).sendKeys(from);
        SelServices.oDriver.findElement(input_year_to).sendKeys(to);
        return true;
    }

    public boolean set_categori(String text) {
        SelServices.oDriver.findElement(categori).sendKeys(text);
        List<WebElement> List = SelServices.oDriver.findElements(list_categori);
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    public boolean set_working_location(String text) {
        SelServices.oDriver.findElement(input_working_location).sendKeys(text);
        List<WebElement> List = SelServices.oDriver.findElements(list_categori);
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    public boolean set_home_address(String text) {
        SelServices.oDriver.findElement(home_address).click();
        SelServices.oDriver.findElement(input_home_addr).sendKeys(text);
        List<WebElement> List = SelServices.oDriver.findElements(list_home_addr);
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    public boolean set_last_resume(String text) {
        SelServices.oDriver.findElement(last_resume).click();
        List<WebElement> List = SelServices.oDriver.findElements(list_last_resume);
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    public boolean set_job_level(String text) {
        SelServices.oDriver.findElement(job_level).click();
        List<WebElement> List = SelServices.oDriver.findElements(list_job_level);
        for (WebElement li : List) {
            if (li.getText().equals(text)) {
                li.click();
                return true;
            }
        }
        return false;
    }

    static int count = 0;

    public void all_print_no_viewed(int n) throws Exception {
        do {
            String MainWindow = SelServices.oDriver.getWindowHandle();
            System.out.println("Main window handle is " + MainWindow);
            WebDriverWait wait = new WebDriverWait(SelServices.oDriver, 10);
            List<WebElement> list = SelServices.oDriver.findElements(list_resume);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(list_resume));
            for (int j = 0; j < list.size(); j++) {
                if (count < n) {
                    WebElement view = SelServices.oDriver.findElement(By.xpath("//body/div[8]/div[1]/div[1]/div[1]/div[2]/div[2]/div["
                            + (j + 1) + "]/div[1]/div[1]/div[3]/div[1]/a[1]"));
                    view.click();
                    ArrayList<String> newTab = new ArrayList<String>(SelServices.oDriver.getWindowHandles());
                    SelServices.oDriver.switchTo().window(newTab.get(1));
                    Thread.sleep(2000);
                    String src = "";
                    List<WebElement> list1 = SelServices.oDriver.findElements(By.xpath("//iframe[@id='resumeIframe']"));
                    if (list1.size() > 0) {
                        src = SelServices.oDriver.findElement(link_src).getAttribute("src");
                        SelServices.oDriver.close();
                        SelServices.oDriver.switchTo().window(MainWindow);
                    } else {
                        src="no src";
                        SelServices.oDriver.close();
                        SelServices.oDriver.switchTo().window(MainWindow);
                    }
                    String v = list.get(j).getText() + "\r\n" + "link src" + "\r\n" + src;
                    if (handing_no_viewed(v) != null) {
                        Recruitment.lstCandidates.add(handing_no_viewed(v));
                        count++;
                    }
                    JavascriptExecutor js = ((JavascriptExecutor) SelServices.oDriver);
                    js.executeScript("arguments[0].scrollIntoView();", view);
                    Thread.sleep(2000);
                }
            }
            JavascriptExecutor js = ((JavascriptExecutor) SelServices.oDriver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebElement next = SelServices.oDriver.findElement(next_page);
            next.click();
            Thread.sleep(3000);
        } while (count < n);
    }

    public void all_print_viewd(int n) throws Exception {
        do {
            String MainWindow = SelServices.oDriver.getWindowHandle();
            System.out.println("Main window handle is " + MainWindow);
            WebDriverWait wait = new WebDriverWait(SelServices.oDriver, 10);
            List<WebElement> list = SelServices.oDriver.findElements(list_resume);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(list_resume));
            for (int j = 0; j < list.size(); j++) {
                if (count < n) {
                    WebElement view = SelServices.oDriver.findElement(By.xpath("//body/div[8]/div[1]/div[1]/div[1]/div[2]/div[2]/div["
                            + (j + 1) + "]/div[1]/div[1]/div[3]/div[1]/a[1]"));
                    view.click();
                    ArrayList<String> newTab = new ArrayList<String>(SelServices.oDriver.getWindowHandles());
                    SelServices.oDriver.switchTo().window(newTab.get(1));
                    Thread.sleep(2000);
                    String src = " ";
                    List<WebElement> list1 = SelServices.oDriver.findElements(By.xpath("//iframe[@id='resumeIframe']"));
                    if (list1.size() > 0) {
                        src = SelServices.oDriver.findElement(link_src).getAttribute("src");
                        SelServices.oDriver.close();
                        SelServices.oDriver.switchTo().window(MainWindow);
                    } else {
                        src="no src";
                        SelServices.oDriver.close();
                        SelServices.oDriver.switchTo().window(MainWindow);
                    }
                    String v = list.get(j).getText() + "\r\n" + "link src" + "\r\n" + src;
                    Recruitment.lstCandidates.add(handing_viewd(v));
                    count++;
                    JavascriptExecutor js = ((JavascriptExecutor) SelServices.oDriver);
                    js.executeScript("arguments[0].scrollIntoView();", view);
                    Thread.sleep(2000);
                }
            }
            JavascriptExecutor js = ((JavascriptExecutor) SelServices.oDriver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebElement next = SelServices.oDriver.findElement(next_page);
            next.click();
            Thread.sleep(3000);
        } while (count < n);
    }

    public Candidate handing_viewd(String str) {
        String name = "", pos = "", company = "", year = "", salary = "", location = "", link = "";
        String[] lines = str.split("\\r?\\n");
        Candidate c = null;
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
            if (lines[i].equalsIgnoreCase("link src")) { 
                link = lines[i+1];    
            }
            c = new Candidate(name, pos, company, year, salary, location, link);
        }
        return c;
    }

    public Candidate handing_no_viewed(String str) {
        String name = "", pos = "", company = "", year = "", salary = "", location = "", link = "";
        String[] lines = str.split("\\r?\\n");
        Candidate c = null;
        for (int i = 0; i < lines.length; i++) {
            name = lines[0];
            if (lines[1].equalsIgnoreCase("   Viewed")) {
                c = null;
            } else {
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
                if (lines[i].equalsIgnoreCase("link src")) {
                    link = lines[i+1];
                }
                c = new Candidate(name, pos, company, year, salary, location, link);
            }
        }
        return c;
    }

    public void show() {
        for (Candidate c : Recruitment.lstCandidates) {
            System.out.println(c.toString());
        }
    }

    public void Close() {
        SelServices.oDriver.close();
    }

    @Override
    public List<Candidate> Filter() {
        if (NavigateTome()) {
            if (Login()) {
                if (clicksearch()) {
                    //set_categori("IT - Software");
                    Recruitment.lstCandidates = new ArrayList<>();
                    String skip_viewed = "";
                    //checkbox viewed no select
                    if (skip_viewed.isEmpty()) {
                        try {
                            all_print_viewd(2);
                        } catch (Exception ex) {
                            Logger.getLogger(Recruitment_VietNamWork.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            all_print_no_viewed(2);
                        } catch (Exception ex) {
                            Logger.getLogger(Recruitment_VietNamWork.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    show();
                }
            }
        }
        return Recruitment.lstCandidates;
        //return null;
    }

}
