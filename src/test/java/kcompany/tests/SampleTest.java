/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.tests;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kcompany.clasess.Cuisine;
import kcompany.pages.AllOfRecipesPage;
import kcompany.pages.MainPage;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author Konst
 */
public class SampleTest {

    private WebDriver driver; //= new FirefoxDriver();
    public FirefoxProfile profile;

    @Before
    public void loadPage() {

        File file = new File("D:\\Fprofile");
        profile = new FirefoxProfile(file);
        driver = new FirefoxDriver(profile);

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void AllOfRecipesPage_Should_Contains_12_Cuisines() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.getMainPage();

        AllOfRecipesPage recipesPage;
        recipesPage = mainPage.getAllOfRecipesPage();
        Set<Cuisine> setCuisine = recipesPage.findAllCousines();

        assertEquals("Amount of cuisines isn't 12", 12, setCuisine.size());
    }

    @Test
    public void Ukrainian_Cuisine_Should_Contains_5_Snacks() {

        MainPage mainPage = new MainPage(driver);
        mainPage.getMainPage();
        AllOfRecipesPage recipesPage = mainPage.getAllOfRecipesPage();

        Map<Cuisine, List<String>> mapRecipes;
        mapRecipes = recipesPage.findAllSnacksPerCousine();

        int ukrSnacks = mapRecipes.get(new Cuisine("Украинская")).size();
        assertEquals("Ukrainian cuisine doesn't have 5 snacks", 5, ukrSnacks);

    }
    
    @Test
    public void AllOfRecipesPage_Should_Contains_16_Snacks() {

        MainPage mainPage = new MainPage(driver);
        mainPage.getMainPage();
        AllOfRecipesPage recipesPage = mainPage.getAllOfRecipesPage();

        Map<Cuisine, List<String>> mapRecipes;
        mapRecipes = recipesPage.findAllSnacksPerCousine();

        int allSnacks = 0;
        
        for (Map.Entry<Cuisine, List<String>> entrySet : mapRecipes.entrySet()) {
            //Cuisine key = entrySet.getKey();
            List<String> value = entrySet.getValue();
            allSnacks = allSnacks + value.size();
        }
             
        assertEquals("All cuisines don't have 16 snacks", 16, allSnacks);

    }
    
    @After
    public void closeDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
