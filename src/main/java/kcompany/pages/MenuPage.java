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
public class MenuPage {

    public WebDriver driver;

    public MenuPage() {

    }

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //-------------------------  * WebElements * -------------------------------
    @FindBy(linkText = "Закуски")
    public WebElement linkSnacks;

    //----------------------------  * Methods * -------------------------------
    public CuisinePage selectCuisine(String cuisineName) {

        driver.findElement(By.
                xpath("//img[@alt='" + cuisineName + "']")).click();

        new WebDriverWait(driver, 5).
                until(ExpectedConditions.
                        visibilityOf(linkSnacks));

        return new CuisinePage(driver);
    }

    public boolean isDishPresent(String dish) {

        return driver.findElement(By.
                xpath("//div[@id='menuDrop']"
                        + "//label[contains(text(),'" + dish + "')]")).isDisplayed();
    }

}
