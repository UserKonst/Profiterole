/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.tests;


import java.util.concurrent.TimeUnit;
import kcompany.clasess.Browsers;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


/**
 *
 * @author Konst
 */
public class SetUpAndTearDown {

    public SetUpAndTearDown() {
    }

    public WebDriver driver; //= new FirefoxDriver();
    public FirefoxProfile profile;
    private final Browsers browser = new Browsers();

    @After
    public void TearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Before
    public void SetUp() {

//        File file = new File("D:\\Fprofile");
//        profile = new FirefoxProfile(file);
//        
        // driver = new FirefoxDriver();
//        String rundriver = System.getProperty("driver");
//
//        System.out.println("rundriver before if" + rundriver);
//        
//        if (rundriver.equals("Chrome")) {
//            System.out.println("rundriver in if" + rundriver);
//            
//            
//            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
//            driver = new ChromeDriver();
//        } else {
//            System.out.println("rundriver in else" + rundriver);
            driver = new FirefoxDriver();
       // }

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
}
