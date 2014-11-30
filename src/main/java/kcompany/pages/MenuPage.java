/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
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

    String partOfDay;
    Boolean weekMenu = false;
    String day;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //-------------------------  * WebElements * -------------------------------
    @FindBy(id = "menu-header")
    public WebElement textMenuHeader;

    //----------------------------  * Methods * -------------------------------
    public RecipePage selectRecipe(String partOfDay) {

        // set part of daty for xpath in other methods
        this.partOfDay = partOfDay;

        String xpath = "//button[contains(text(),'%s')]";
        driver.findElement(By.xpath(String.format(xpath, partOfDay))).click();

        // Wait for menu header 
        new WebDriverWait(driver, 2).
                until(ExpectedConditions.
                        elementToBeClickable(textMenuHeader));

        return new RecipePage(driver);
    }

    public boolean does_Selected_Dish_Present_in_Users_Menu(String dish) {

        String xpath;

        //  two different xpaths for day menu and week menu
        if (weekMenu) {
            xpath = "//div[@id='" + getDay(day) + "_" + getType(partOfDay)
                    + "']//label[contains(text(),'%s')]";
        } else {
            xpath = "//div[@id='" + getType(partOfDay) + "']//label[contains(text(),'%s')]";
        }

        WebElement yourDish = null;

        try {
            yourDish = driver.findElement(By.xpath(String.format(xpath, dish)));
        } catch (ElementNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        if (yourDish != null && yourDish.isDisplayed()) {
            return true;
        } else {
            System.out.println("Dish '" + dish + "' isn't present in your menu");
        }
        return false;
    }

    public void selectDay(String day) {

        weekMenu = true;
        this.day = day;

        String xpath = "//div[contains(text(),'%s')]";
        driver.findElement(By.xpath(String.format(xpath, day))).click();

    }

    // select part of day for xpath
    public String getType(String st) {
        String partOfDayForXpath;
        switch (st) {
            case "Завтрак":
                partOfDayForXpath = "breakfast";
                break;
            case "Обед":
                partOfDayForXpath = "dinner";
                break;
            case "Ужин":
                partOfDayForXpath = "supper";
                break;
            default:
                partOfDayForXpath = null;
        }

        return partOfDayForXpath;
    }

    // Select part of day for xpath
    public String getDay(String st) {
        String dayForXpath;
        switch (st) {
            case "Пн":
                dayForXpath = "Mo";
                break;
            case "Вт":
                dayForXpath = "Tu";
                break;
            case "Ср":
                dayForXpath = "We";
                break;
            case "Чт":
                dayForXpath = "Th";
                break;
            case "Пт":
                dayForXpath = "Fr";
                break;
            case "Сб":
                dayForXpath = "Sa";
                break;
            case "Вс":
                dayForXpath = "Su";
                break;
            default:
                dayForXpath = null;
        }

        return dayForXpath;
    }

}
