/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcompany.tests;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kcompany.clasess.Cuisine;
import kcompany.pages.AllOfRecipesPage;
import kcompany.pages.MainPage;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;


/**
 *
 * @author Konst
 */
public class TestCuisines extends SetUpAndTearDown{

    
     @Test
    public void AllOfRecipesPage_Should_Contains_12_Cuisines() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.getMainPage();

        AllOfRecipesPage recipesPage;
        recipesPage = mainPage.getAllOfRecipesPage();
        Set<Cuisine> setCuisine = recipesPage.findAllCousines();

        assertEquals("Amount of cuisines isn't 12", 12, setCuisine.size());
    }

    @Ignore
    @Test
    public void Ukrainian_Cuisine_Should_Contains_5_Snacks() {

        MainPage mainPage = new MainPage(driver);
        mainPage.getMainPage();
        AllOfRecipesPage recipesPage = mainPage.getAllOfRecipesPage();

        Map<Cuisine, List<String>> mapRecipes;
        mapRecipes = recipesPage.findAllSnacksPerCousine();

        int ukrSnacks = mapRecipes.get(new Cuisine("Украинская")).size();
        assertEquals("Ukrainian cuisine doesn't have 5 snacks", 5, ukrSnacks);

    }

    @Ignore
    @Test
    public void AllOfRecipesPage_Should_Contains_16_Snacks() {

        MainPage mainPage = new MainPage(driver);
        mainPage.getMainPage();
        AllOfRecipesPage recipesPage = mainPage.getAllOfRecipesPage();

        Map<Cuisine, List<String>> mapRecipes;
        mapRecipes = recipesPage.findAllSnacksPerCousine();

        int allSnacks = 0;

        for (Map.Entry<Cuisine, List<String>> entrySet : mapRecipes.entrySet()) {
            allSnacks += entrySet.getValue().size();
        }

        assertEquals("All cuisines don't have 16 snacks", 16, allSnacks);

    }

   
}
