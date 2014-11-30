/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;
import kcompany.pages.CuisinePage;
import kcompany.pages.MainPage;
import kcompany.pages.MenuPage;
import kcompany.pages.RecipePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author Konst
 */
public class JUnitTest {

    public JUnitTest() {
    }

    public static WebDriver driver;
    public static FirefoxProfile profile;

    @Test
    public void should_Create_Day_Menu() throws InterruptedException {

        driver = new FirefoxDriver(profile);

        // Timeouts
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Open main page
        MainPage mainPage = new MainPage(driver);
        mainPage.getMainPage(driver);

        // Select menu
        MenuPage menuPage = mainPage.selectMenu("Меню на день");

        // Select recipe
        RecipePage recipePage = menuPage.selectRecipe("Завтрак");

        // Select cuisinefirefox.exe -p
        CuisinePage cuisinePage = recipePage.selectCuisine("Французская");
        cuisinePage.selectMenu("Закуски");

        cuisinePage.addDish("Сырные палочки из пармезана");

        System.out.println("test");

        Assert.assertTrue(menuPage.isDishPresent("Сырные палочки из пармезана"));
        
    }

    @BeforeClass
    public static void setUp() {

        File file = new File("D:\\Fprofile");
        profile = new FirefoxProfile(file);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
