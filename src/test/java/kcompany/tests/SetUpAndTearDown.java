/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;
import kcompany.clasess.Browsers;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
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

        File file = new File("D:\\Fprofile");
        profile = new FirefoxProfile(file);
        
        driver = new FirefoxDriver();

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
}
