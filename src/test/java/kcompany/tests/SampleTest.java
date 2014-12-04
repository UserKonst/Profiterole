/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.tests;

import java.util.concurrent.TimeUnit;
import kcompany.pages.html.SearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Konst
 */
public class SampleTest {

    private final WebDriver driver = new FirefoxDriver();
    private final SearchPage searchPage = new SearchPage(driver);

    @Before
    public void loadPage() {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://gioia-profiterole.rhcloud.com");
    }

    @Test
    public void sampleTest() {
        searchPage.getAllRecipes();
    }

    @Test
    public void sampleTest1() {
        searchPage.getMenuForDay();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
