/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 *
 * @author Konst
 */
@Block(
        @FindBy(className = "btn-group no-outline"))
public class PartsOfDay extends HtmlElement {

    public void selectPartOfDay(String partOfDay, WebDriver driver) {

        driver.findElement(By
                .xpath("//button[contains(text(),'" + partOfDay + "')]")).click();
    }

}
