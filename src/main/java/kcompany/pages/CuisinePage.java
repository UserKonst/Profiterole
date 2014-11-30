/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    //--------------------------------------------------------------------------
    public void selectMenu(String menu) {

        // xpath to select menu
        String xpath = "//a[contains(text(),'%s')]";

        // click on drop-down list menu
        driver.findElement(By.xpath(String.format(xpath, menu))).click();

    }

    // add dish to client menu
    public void addDish(String dish) throws InterruptedException {

        String xpath = "//div[@id='cuisine']//label[contains(text(),'%s')]";
        
        // click on selected dish
        driver.findElement(By.xpath(String.format(xpath, dish))).click();

        // click button 'Добавить'
        driver.findElement(By.ByXPath.xpath("//button[contains(text(),'Добавить')]")).click();
    }

}
