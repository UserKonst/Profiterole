/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 *
 * @author Konst
 */
@Name("Search form")
@Block(
        @FindBy(xpath = "//form"))
public class MenuForWeekPage extends HtmlElement {

    @Name("Search request input")
    @FindBy(id = "text")
    private TextInput requestInput;

    @Name("Search button")
    @FindBy(className = "button__text")
    private Button searchButton;

    MenuForWeekPage(WebDriver driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }

   

}
