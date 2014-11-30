/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Konst
 */
public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage() {
    }

    private final String baseURL = "http://gioia-profiterole.rhcloud.com";

    //------------------------  * WebElements *  ------------------------------
    @FindBy(xpath = "//a[contains(text(),'Создать меню')]")
    public WebElement buttonCreateMenu;

    @FindBy(xpath = "//ul[@class='dropdown-menu']")
    public WebElement dropdownCreateMenu;

    //----------------------------  * Methods * -------------------------------
    public MenuPage selectMenu(String menuType) {

        // click on list menu
        buttonCreateMenu.click();

        // click on menu type
        String xpath = "//a[contains(text(),'%s')]";
        driver.findElement(By.xpath(String.format(xpath, menuType))).click();

        return new MenuPage(driver);
    }

    public void getMainPage(WebDriver driver) {
        driver.get(baseURL);
    }
}
