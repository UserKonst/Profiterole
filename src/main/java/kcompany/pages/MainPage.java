 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.pages;

import kcompany.blocks.DaysOfWeek;
import kcompany.blocks.PartsOfDay;
import kcompany.blocks.StartPanel;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 *
 * @author Konst
 */
public class MainPage {

    public WebDriver driver;

    public StartPanel startPanel;
    public PartsOfDay partsOfDay;
    public DaysOfWeek daysOfWeek;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public MainPage() {
    }

    private final String baseURL = "http://gioia-profiterole.rhcloud.com";

    //----------------------------  * Methods * -------------------------------
    public MenuForWeekPage getMenuForWeekPage(String day) {
        startPanel.createMenu("Меню на неделю", driver);
        daysOfWeek.selectDay(day, driver);
        return new MenuForWeekPage(driver);
    }

    public MenuPage getMenuPage(String partOfDay) {
        startPanel.createMenu("Меню на день", driver);
        partsOfDay.selectPartOfDay(partOfDay, driver);
        return new MenuPage(driver);
    }

    public AllOfRecipesPage getAllOfRecipesPage() {
        startPanel.getAllRecipes();
        return new AllOfRecipesPage(driver);
    }

    public void getMainPage() {
        driver.get(baseURL);
    }
}
