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
     
//     @Test
//     public void testiCreateNumbersBasetable(){
//         Minefield kentta1 = new Minefield(10, 10, 10);
//         int[][] basefield = kentta1.getBasetable();
//         for(int i=0; i<kentta1.hight; i++){
//             for(int j=0; j<kentta1.hight; j++){
//                 assertTrue(basefield[i][j] > -2 && basefield[i][j] < 9);    
//             }
//         }          
//     }
//     
//     @Test
//     public void testiCreateNumbersBasetable1(){
//         Minefield kentta1 = new Minefield(10, 10, 10);
//         int[][] basefield = kentta1.getBasetable();
//         assertTrue(basefield[5][5] > -2 && basefield[5][5] < 9);       
//     }
     @Test
     public void testiCreateNumbersBasetable2(){
         Minefield kentta1 = new Minefield(10, 10, 10);
         int[][] basefield = kentta1.getBasetable();
         assertTrue(basefield[5][5] > -2 && basefield[5][5] < 9); 
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
         } else {
             assertFalse(kentta3.Opensquare(3, 3));
         }  
     }
     @Test 
     public void testOpensquare1(){
         Minefield kentta = new Minefield(6,6,6);
         if(kentta.basetable[2][2] != -1){
            kentta.Opensquare(2, 2);
            if(kentta.gametable[2][2] != " "){
                assertTrue(kentta.basetable[2][2] == Integer.parseInt(kentta.gametable[2][2]));
            } else{
                assertEquals(kentta.gametable[2][2], " ");
            }
         } else {
             assertTrue(kentta.getGameover());
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
     public void testMarktheMine1(){
         Minefield kentta5 = new Minefield(10,10,10);
         kentta5.MarktheMine(4, 4);
         assertTrue(kentta5.mines == 9);
         
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
     
     @Test
     public void testCreateMines(){
         Minefield kentta = new Minefield(10,10,10);
         int[][] basefield = kentta.getBasetable();
         int miinat = 10;
         for(int i=0; i<kentta.hight; i++){
             for(int j=0; j<kentta.hight; j++){
                 if(basefield[i][j] == -1){
                     miinat--;
                 }
             }
         }
         assertTrue(miinat == 0);
     }
     @Test
     public void testForWin(){
         Minefield kentta = new Minefield(10,10,10);
         for(int i=0; i<kentta.hight; i++){
             for(int j=0; j<kentta.hight; j++){
                 kentta.Opensquare(i, j);
             }
         }
         assertTrue(kentta.CheckforWin());  
     }
     @Test 
     public void testopenSquare(){
         Minefield kentta9 = new Minefield(10,10,10);
         kentta9.Opensquare(2, 2);
         if (kentta9.basetable[2][2] == 0){
             assertFalse(kentta9.gametable[1][1].equals("o"));
             assertFalse(kentta9.gametable[1][2].equals("o"));
             assertFalse(kentta9.gametable[1][3].equals("o"));
             assertFalse(kentta9.gametable[2][1].equals("o"));
             assertFalse(kentta9.gametable[2][3].equals("o"));
             assertFalse(kentta9.gametable[3][1].equals("o"));
             assertFalse(kentta9.gametable[3][2].equals("o"));
             assertFalse(kentta9.gametable[3][3].equals("o"));
         } if (kentta9.basetable[2][2] != 0 && kentta9.basetable[2][2] !=-1){
             assertFalse(kentta9.gametable[2][2].equals(" "));
             assertFalse(kentta9.gametable[2][2].equals("o"));
         }
     }
     
}
