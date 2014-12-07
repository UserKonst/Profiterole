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
public class CuisinePage {

    public WebDriver driver;

    public CuisinePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CuisinePage() {
    }

     //-------------------------  * WebElements * -------------------------------
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    public WebElement buttonAddDish;

     //-------------------------  * Methods * -------------------------------
    
    // add dish to client menu
    public void addDish(String category, String dish) throws InterruptedException {

        driver.findElement(By.linkText(category)).click();

        driver.findElement(By.
                xpath("//label[contains(text(),'" + dish + "')]")).click();

        // click button 'Добавить'
        buttonAddDish.click();
    }

}
