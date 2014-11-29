/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.pages;

import org.openqa.selenium.WebDriver;
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

}
