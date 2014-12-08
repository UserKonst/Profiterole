/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.clasess;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author Konst
 */
public class Browsers {

    private final String config = "src/main/resources/config.properties";
    private static final Properties property = new Properties();
    public final String currentBrowser;

    public Browsers() {
            currentBrowser = getMyProperties("browser");
      
    }

    public String getCurrentBrowser() {
        return currentBrowser;
    }

    public String getMyProperties(String propertyKey) {
        InputStreamReader input;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(config);
            input = new InputStreamReader(fileInputStream, "UTF8");

            // считываем свойства
            property.load(input);

            // получаем значение свойства
            return property.getProperty(propertyKey);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Ошибка. Файл config.properties не был найден.");
            return null;
        } catch (java.io.IOException e) {
            System.out.println("IO ошибка в пользовательском методе.");
            return null;
        }
    }

}
