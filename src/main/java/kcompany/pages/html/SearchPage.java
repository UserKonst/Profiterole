/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.pages.html;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 *
 * @author Konst
 */
public class SearchPage {

    public StartPanel startPanel;
    // Other blocks and elements here

    public SearchPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        System.out.println("constr");
    }

    public void getAllRecipes() {
        startPanel.getAllRecipes();
    }

    public void getMenuForDay() {
        startPanel.getMenuForDay();
    }

    // Other methods here
}
