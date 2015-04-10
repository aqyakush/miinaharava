/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava1.miinaharava;

import java.util.Random;

/**
 * @author      aqyakush
 * @version     1.0       (current version number of program)
 * @since       2015-03-10     
 */
public final class Minefield {
    public int hight; // pelikentän korkeus
    public int width; // peilikentän leveys
    public int mines; // miinojen luku
    private int markedMines; //merkkattujen miinojen luku
    public int[][]basetable;
    public String[][]gametable;
    private boolean gameover; // arvo on true jos astuit miinan päälle
    
    public Minefield(int hight, int width, int mines){
        this.hight = hight;
        this.width = width;
        this.mines = mines;
        this.basetable = new int[this.hight][this.width];
        this.gametable = new String[this.hight-1][this.width-1];
        this.gameover = false;
        createMines();
        CreateNumbersBasetable();
        Gametable();
        
    }
    /**
      * Metodi luo miinat satunnaisissa paikkoissa, jos miina on jo siellä
      * niin arvottaan uusi paikka
      */

    public void createMines() {
        for(int i = 0; i < this.mines; i++){
            int col, row;
        
        do{
            Random rand = new Random();
            col = rand.nextInt((this.hight- 3)+1)+1; // arvotaan arvoja jotka eivä ole kenttijen reunalla, näin methodissa  CreateNumberBasetable helpompi
            row = rand.nextInt((this.width- 3)+1)+1; // käsitellä reunnimaiset paikkat, vaikka basetablessa ne on näkyvillä, gametablessa
                                                     //reunnimaiset paikkat ovat piilossa     
        } while (this.basetable[col][row] != 0); // jos paikas ei ole miinna, laitettaan sen sinne
        this.basetable[col][row] = -1;
        }

    }
    
    /** Näiden miinojen perustella mitä luottiin methodissa createMines()
    *  laitettaan numeroita, eli methodi laske paljon miinoja on ruudun
    *  ympäri ja laitta sille jonkinlainen arvo
    *
    */
    
    private void CreateNumbersBasetable(){
        for(int i=0; i < this.hight;i++){
            for(int j=0; j < this.width; j++){ 
                if (this.basetable[i][j] == -1){
                    if(this.basetable[i-1][j-1] != -1) this.basetable[i-1][j-1]++; //tässä käydään kaikki paikat miinan ympäri ja jos siellä ei ole miinaa
                    if(this.basetable[i-1][j] != -1) this.basetable[i-1][j]++; // kasvatettaan paikan arvo ykkösellä
                    if(this.basetable[i-1][j+1] != -1) this.basetable[i-1][j+1]++;
                    if(this.basetable[i][j-1] != -1) this.basetable[i][j-1]++;
                    if(this.basetable[i][j+1] != -1) this.basetable[i][j+1]++;
                    if(this.basetable[i+1][j-1] != -1) this.basetable[i+1][j-1]++;
                    if(this.basetable[i+1][j] != -1) this.basetable[i+1][j]++;
                    if(this.basetable[i+1][j+1] != -1) this.basetable[i+1][j+1]++;
                }
            }
        }    
    }
    
    /** Gametable asettaa kaikki pelikentän arvo o:ksi
    * pelin alussa kaikki ruudut ovat "o"
    */
    public void Gametable(){
        for(int i=1; i < this.gametable.length;i++){ //oikeassa pelikentässä meillä on vähemmän kenttiä kuin loogisessa kentässä
            for(int j=1; j < this.gametable.length; j++){
                this.gametable[i][j] = "o";
            }
        }
    }
    
    /** Metodi avaa ruudut, kun valittaan joku ruutu voi olla kolme eri tapausta
    *  -ruudussa on numero 1-8 niin avataan pelkän sitä ruutua
    *  -ruudussa on miina, niin peli on hävitetty
    *  -ruudussa ei ole mitään, niin avataan kaikki sen ympäri olevat ruudut
    *  @param i Käyttäjän antama syöte
    *  @param j Käyttäjän antama syöte
    *  @return this.gameover onko peli vielä pelatavissa vai onko se hävitetty
    */ 
          
     public boolean Opensquare(int i, int j){
        if(1 > i || i > this.hight-2 || 1 > j || j > this.width-2 ){ // jos ruutu on kentät ulkopuolella niin ei tehdään mitään
            return this.gameover;
        } else if ( this.gametable[i][j] == "X"){
            return this.gameover;
        }
        else if (this.basetable[i][j] == 0 && this.gametable[i][j] == "o" && this.basetable[i][j] != -1){ //jos ruudus ei ole mitään, avataan kaikki numerot sen ympäri
                this.gametable[i][j] = " ";
                Opensquare(i-1, j-1);
                Opensquare(i-1, j);
                Opensquare(i-1, j+1);
                Opensquare(i, j+1);
                Opensquare(i+1, j+1);
                Opensquare(i+1, j);
                Opensquare(i+1, j-1);
                Opensquare(i, j-1);     
        }
        else if(this.basetable[i][j] == -1){
            this.gameover = true; //astuttaan miinan päälle, niin f
        }
        else {
            int arvo = this.basetable[i][j];
            if (arvo == 0){
                this.gametable[i][j] = " ";
            } else{
                String a = Integer.toString(arvo);
                this.gametable[i][j] = a ;
            }        
        }
        
        return this.gameover;      
    }
     
    /** CheckforWin tarkistaa onko kaikki ruudut mis ei ole miina on auki
     * jos on niin peli on voitettu
     *
     * @return true jos voitettu ja false jos peli ei voitettu
     */
    public boolean CheckforWin(){ 
        for ( int i=1; this.hight-1 > i; i++){
            for (int j=1; this.width-1 > j; j++ ){
                if ( this.gametable[i][j] == "o" && this.basetable[i][j] != -1){
                    return false;
                }                 
            }
        }
        return true;       
    }
    
    /** Merkittään paikka missä luullaan että on miina
    * ja vähenettään miinojen määrä että tiedettään paljonko miinoja on
    * merkamatta. 
    *
    * @param i halutun paikan korkeus
    * @param j halutun paikan leveys
    */
    public void MarktheMine(int i, int j){ //merkitään paikka jossa on miina
        this.gametable[i][j] = "X";
        this.mines--;
    } 
    
    /**palauttaa miinojen määrä
    *
    * @return this.mines miinojen määrä
    */
    public int getMines(){
        return this.mines;
    }
    
    /**  palauttaa onko peli menossa vai hävitetty
    *
    * @return this.gameover true tai false
    */
    
    public boolean getGameover(){
        return this.gameover;
    }
    
    /**  palauttaa basetable 
    *
    * @return this.basetable
    */
    public int[][] getBasetable(){
        return this.basetable;
    }
    
    /**  palauttaa gametalbe
    *
    * @return this.gametable
    */
    public String[][] getGametable(){
        return this.gametable;
    }
//    public void PrintBasetable(){
//        for(int i=0; i < this.hight;i++){
//            System.out.print(i + " ");
//            for(int j=0; j < this.width; j++){
//                System.out.print(this.basetable[i][j] + " ");
//            }
//            System.out.println("");
//        }   
//    }
//    
//    public void printGametable(){
//        System.out.print("   ");   
//        for (int i = 1; i<this.gametable[1].length; i++) {          
//            if (i>=this.width-2) {  
//            System.out.print(i+" ");  
//            }  
//            else {  
//                System.out.print(i+"  ");  
//            }  
//        }  
//        System.out.println();  
//  
//          
//        System.out.print("   ");  
//        for (int i=1; i<this.gametable[1].length; i++) {  
//            System.out.print("---");  
//        }  
//        System.out.println();  
//  
//      
//        for (int i=1; i<this.gametable.length; i++) {           
//            if(i>=this.hight-1) {  
//            System.out.print(i+" |");  
//            }  
//            else {  
//                System.out.print(i+"|");  
//            }  
//            for (int j = 1; j<this.gametable[i].length; j++) {  
//                System.out.print(this.gametable[i][j]+"  ");  
//            }  
//            System.out.print("|");  
//            System.out.println();  
//        }  
//        System.out.println("Miinojen määrä on " + this.mines);
//   
//    }
    
    
}
    

