/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.pages.html;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 *
 * @author Konst
 */
@Block(
        @FindBy(className = "navbar-inner"))
public class StartPanel extends HtmlElement {

    //------------------------  * Menu *  ---------------------------------
    @FindBy(xpath = "//a[contains(text(),'Создать меню')]")
    private Button createMenu;

    @FindBy(partialLinkText = "Меню на день")
    private Link menuForDay;

    @FindBy(partialLinkText = "Меню на неделю")
    private Link menuForWeek;

    //------------------------  * Recipeies *  ---------------------------------
    @FindBy(xpath = "//a[contains(text(),'Рецепты')]")
    private Button recipes;

    @FindBy(partialLinkText = "Все рецепты")
    private Link allRecipes;

    //------------------------  * METHODS *  ---------------------------------
    public void getMenuForDay() {
        createMenu.click();
        menuForDay.click();
    }

    public void getMenuForWeek() {
        createMenu.click();
        menuForWeek.click();
    }

    public void getAllRecipes() {
        System.out.println("in getAllRecipes");
        recipes.click();
        System.out.println(" after recipes.click();");
        allRecipes.click();
    }

}
