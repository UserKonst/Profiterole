/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.blocks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

   // public WebDriver driver;

    //------------------------  * Menu *  ---------------------------------
    @FindBy(xpath = "//a[contains(text(),'Создать меню')]")
    private Button createMenu;

    //------------------------  * Recipeies *  ---------------------------------
    @FindBy(xpath = "//a[contains(text(),'Рецепты')]")
    private Button recipes;

    @FindBy(partialLinkText = "Все рецепты")
    private Link allRecipes;

    //------------------------  * METHODS *  ---------------------------------
    public void createMenu(String menuType, WebDriver driver) {
        createMenu.click();
        driver.findElement(By.linkText(menuType)).click();
      
    }

    public void getAllRecipes() {
        recipes.click();
        allRecipes.click();
    }

}
