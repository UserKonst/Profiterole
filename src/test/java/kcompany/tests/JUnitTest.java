/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.tests;

import java.util.concurrent.TimeUnit;
import kcompany.pages.CuisinePage;
import kcompany.pages.MainPage;
import kcompany.pages.MenuPage;
import kcompany.pages.AllOfRecipesPage;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author Konst
 */
public class JUnitTest {
//
//    public JUnitTest() {
//    }
//
//    public WebDriver driver;
//    public FirefoxProfile profile;
//
//  
//    @Test
//    public void should_Display_SirnyePalochki_Selected_From_Day_Menu() throws InterruptedException {
//
//        // Open main page
//        MainPage mainPage = new MainPage(driver);
//        mainPage.getMainPage(driver);
//
//        
//        
////        // Select menu
////        MenuPage menuPage = mainPage.selectMenu("Меню на день");
////
////        // Select recipe
////        RecipePage recipePage = menuPage.selectRecipe("Ужин");
////
////        // Select cuisine
////        CuisinePage cuisinePage = recipePage.selectCuisine("Французская");
////        cuisinePage.selectMenu("Закуски");
////
////        // Select dish
////        String dish = "Сырные палочки из пармезана";
////        cuisinePage.addDish(dish);
////
////        assertTrue("Выбранное блюдо не отображается в меню", menuPage.isDishPresent(dish));
//
//    }
//
//    @Ignore
//    @Test
//    public void should_Display_SirnyePalochki_Selected_From_Week_Menu() throws InterruptedException {
//
//        // Open main page
//        MainPage mainPage = new MainPage(driver);
//        mainPage.getMainPage(driver);
//
//        // Select menu
//       // MenuPage menuPage = mainPage.selectMenu("Меню на неделю");
//
//        // Select day
//        menuPage.selectDay("Вт");
//
//        // Select recipe
//        AllOfRecipesPage recipePage = menuPage.selectRecipe("Обед");
//
//        // Select cuisine
//        CuisinePage cuisinePage = recipePage.selectCuisine("Французская");
//        cuisinePage.selectMenu("Закуски");
//
//        // Select dish
//        String dish = "Сырные палочки из пармезана";
//        cuisinePage.addDish(dish);
//
//        assertTrue("Выбранное блюдо не отображается в меню", menuPage.isDishPresent(dish));
//
//    }
//
//    @Before
//    public void setUp() {
//
////        File file = new File("D:\\Fprofile");
////        profile = new FirefoxProfile(file);
//        driver = new FirefoxDriver();
//
//        // Timeouts
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//
//    }

}
