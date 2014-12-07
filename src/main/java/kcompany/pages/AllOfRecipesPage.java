/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import kcompany.clasess.Cuisine;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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
public class AllOfRecipesPage {

    public WebDriver driver;

    public AllOfRecipesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AllOfRecipesPage() {
    }
    //-------------------------  * WebElements * -------------------------------

    @FindBy(id = "back")
    public WebElement buttonBack;

    @FindBy(linkText = "Закуски")
    public WebElement linkSnacks;

    //----------------------------  * Methods * -------------------------------
    public Set<Cuisine> findAllCousines() {

        Set<Cuisine> setCuisines = new HashSet<>();
        List<WebElement> webListCuisines = driver.findElements(By.className("img-cuisine"));

        for (WebElement webCuisine : webListCuisines) {
            Cuisine cuisine = new Cuisine(webCuisine.getAttribute("alt"));
            setCuisines.add(cuisine);
        }

        return setCuisines;
    }

    public Map<Cuisine, List<String>> findAllSnacksPerCousine() {

        Map<Cuisine, List<String>> mapCuisine = new HashMap<>();

        // begin to find all snacks
        for (Cuisine cuisine : findAllCousines()) {

            String cuisineName = cuisine.getName();

            driver.findElement(By.xpath("//img[@alt='" + cuisineName + "']")).click();
            linkSnacks.click();

            // wait for list of snacks appears
            new WebDriverWait(driver, 5).
                    until(ExpectedConditions.
                            presenceOfElementLocated(By.
                                    xpath("//div[@class='accordion-body in collapse']")));

            // when cusine doesn't have any snacks, we don't want to wait 10 sec
            // so reset implicitlyWait
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

            // this finds all web elements 'snack'
            List<WebElement> webSnack = driver.findElements(By.
                    xpath("//a[contains(text(),'Закуски')]"
                            + "/ancestor::div[@class='accordion-group']"
                            + "//div[@class='recipe_on_page btn-link']"));

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // get text from each of snack 
            List<String> listSnacks = new ArrayList<>();
            for (WebElement webCuisine : webSnack) {
                listSnacks.add(webCuisine.getText());
            }

            // put cuisine into map
            mapCuisine.put(cuisine, listSnacks);

            // back to the list of cuisines
            buttonBack.click();
        }
        return mapCuisine;
    }
}
