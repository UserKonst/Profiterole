/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.tests;

import java.io.File;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author Konst
 */
public class JUnitTest {

    public JUnitTest() {
    }

    @Test
    public void test() throws InterruptedException {

        File file = new File("D:\\Fprofile");
        FirefoxProfile profile = new FirefoxProfile(file);

        WebDriver driver = new FirefoxDriver(profile);

        driver.get("http://habrahabr.ru/post/130912/");

        Thread.sleep(2000);

        driver.quit();
    }
}
