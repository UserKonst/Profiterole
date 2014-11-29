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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//a[contains(text(),'Создать меню')]")
    public WebElement buttonCreateMenu;

    @FindBy(xpath = "//ul[@class='dropdown-menu']")
    public WebElement dropdownCreateMenu;

    @FindBy(xpath = "//button[contains(text(),'Завтрак')]")
    WebElement buttonZavtrak;

    // Get page
    public MenuPage getMenu(String menuType) {

        // click and wait for list menu
        buttonCreateMenu.click();
        new WebDriverWait(driver, 2).
                until(ExpectedConditions.
                        elementToBeClickable(dropdownCreateMenu));

        // click on type of menu
        String xpath = "//a[contains(text(),'%s')]";
        driver.findElement(By.xpath(String.format(xpath, menuType))).click();

        // Wait for buttons appears
        new WebDriverWait(driver, 2).
                until(ExpectedConditions.
                        visibilityOf(buttonZavtrak));

        return new MenuPage(driver);
    }
}
