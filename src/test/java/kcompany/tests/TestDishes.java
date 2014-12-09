/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.tests;

import kcompany.pages.CuisinePage;
import kcompany.pages.MainPage;
import kcompany.pages.MenuForWeekPage;
import kcompany.pages.MenuPage;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Konst
 */
public class TestDishes extends SetUpAndTearDown{

    public TestDishes() {
    }

    @Ignore
    @Test
    public void should_Display_SirnyePalochki_Selected_From_MenuPage() throws InterruptedException {

        // Open main page
        MainPage mainPage = new MainPage(driver);
        mainPage.getMainPage();

        MenuPage menuPage = mainPage.getMenuPage("Обед");
        CuisinePage cuisinePage = menuPage.selectCuisine("Французская");

        // Select dish
        String dish = "Сырные палочки из пармезана";
        cuisinePage.addDish("Закуски", dish);

        assertTrue("Выбранное блюдо не отображается в меню", menuPage.isDishPresent(dish));

    }

    @Ignore
    @Test
    public void should_Display_SirnyePalochki_Selected_From_MenuForWeekPage() throws InterruptedException {

        // Open main page
        MainPage mainPage = new MainPage(driver);
        mainPage.getMainPage();

        MenuForWeekPage menuforWeekPage = mainPage.getMenuForWeekPage("Пт");
        CuisinePage cuisinePage = menuforWeekPage.selectCuisine("Французская");

        // Select dish
        String dish = "Сырные палочки из пармезана";
        cuisinePage.addDish("Закуски", dish);

        assertTrue("Выбранное блюдо не отображается в меню", menuforWeekPage.isDishPresent(dish));

    }

}
