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
public class RecipePage {

    public WebDriver driver;

    public RecipePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RecipePage() {
    }
    //-------------------------  * WebElements * -------------------------------
    @FindBy(id = "menu-header")
    public WebElement textMenuHeader;

    //----------------------------  * Methods * -------------------------------
    public CuisinePage selectCuisine(String cuisine) {

        // xpath to select cuisine
        String xpath = "//img[@alt='%s']";

        driver.findElement(By.xpath(String.format(xpath, cuisine))).click();

        new WebDriverWait(driver, 2).
                until(ExpectedConditions.
                        elementToBeClickable(textMenuHeader));

        return new CuisinePage(driver);
    }
}
