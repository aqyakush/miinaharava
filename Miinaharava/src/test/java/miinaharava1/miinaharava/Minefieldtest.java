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
public class MinefieldTest {
    
    public MinefieldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    @Test
    public void testGanetable(){
        Minefield kentta = new Minefield(10,10,10);
        assertTrue(kentta.gametable.length == 9);
    }
    @Test
    public void testGanetable1(){
        Minefield kentta = new Minefield(10,10,10);
        assertTrue(kentta.gametable[1].length == 9);
    }
    
    @Test
    public void testcreateMines(){
        Minefield kentta = new Minefield(10,10,10);
        assertTrue(kentta.getMines() <= 10);   
    }
    
    @Test
     public void testgetGameover() {
        Minefield kentta = new Minefield(10,10,10);
        assertFalse(kentta.getGameover());
     }
     
     @Test
     public void testiCreateNumbersBasetable(){
         Minefield kentta1 = new Minefield(10, 10, 10);
         assertTrue(kentta1.basetable[5][5] > -2 && kentta1.basetable[5][5] < 9);       
     }
     
     @Test
     public void testGametable(){
         Minefield kentta2 = new Minefield(10, 10, 10);
         assertTrue(kentta2.gametable[5][5] == "o");
         
     }
     
     @Test
     public void testOpensquare(){
         Minefield kentta3 = new Minefield(10,10,10);
         if (kentta3.basetable[3][3] == -1){
             assertTrue(kentta3.Opensquare(3, 3));
         } else{
             assertFalse(kentta3.Opensquare(3, 3));
         }
         
         
     }
     
     @Test
     public void testCheckforWin(){
         Minefield kentta4 = new Minefield(10,10,10);
         assertFalse(kentta4.CheckforWin());
         
     }
     

     @Test
     public void testMarktheMine(){
         Minefield kentta5 = new Minefield(10,10,10);
         kentta5.MarktheMine(4, 4);
         assertTrue(kentta5.gametable[4][4] == "X");
         
     }
     
     @Test
     public void testgetMines(){
         Minefield kentta6 = new Minefield(10, 10, 10);
         assertTrue(kentta6.getMines() == 10);
         
     }
     
     @Test
     public void testgetGametable(){
         Minefield kentta7 = new Minefield(10,10,10);
         String[][] b= kentta7.getGametable();
         assertTrue(b.length == 10-1);
         
     }
}
