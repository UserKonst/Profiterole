/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.profiterole;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Konst
 */
public class NewClassTest {
    
    public NewClassTest() {
    }

    @Test
    public void testSomeMethod() {
   
        
        NewClass cl = new NewClass();
        
        assertEquals("hello", cl.hello());
    }
    
}
