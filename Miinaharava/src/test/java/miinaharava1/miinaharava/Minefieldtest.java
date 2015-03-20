/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava1.miinaharava;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anton
 */
public class Minefieldtest {
    
    public Minefieldtest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Minefield kentta = new Minefield(10,10,10);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testgetGameover() {
        Minefield kentta = new Minefield(10,10,10);
        assertTrue(kentta.getGameover() == true);
     }
     
     @Test
     public void testluodamiinat(){
         Minefield kentta = new Minefield(10,10,10);
         kentta.luodamiinat();
     }
     @Test
     public void testiopenNbrofMine(){
         Minefield kentta = new Minefield(10,10,10);
         kentta.luodamiinat();
         assertTrue(kentta.openNbrofMine(3, 3) == true);
         
         
     }
     @Test
     public void testiopenNbrofMine2(){
         Minefield kentta = new Minefield(10,10,10);
         kentta.luodamiinat();
         assertTrue( kentta.openNbrofMine(15, 25) == false);
     }
     @Test
     public void testGetTable(){
         Minefield kentta = new Minefield(10,10,10);
         int[][] a = kentta.getTable();
         assertTrue(a.length == 10);
     }
     @Test
     public void testGetGameTable(){
         Minefield kentta = new Minefield(10,10,10);
         char[][] b= kentta.getGametable();
         assertTrue(b.length == 10-2);
     }
     @Test
     public void testTulostapelikentta(){
         Minefield kentta = new Minefield(10,10,10);
         kentta.Pelikentta();
         kentta.tulostaPelikentta();
     }
}
