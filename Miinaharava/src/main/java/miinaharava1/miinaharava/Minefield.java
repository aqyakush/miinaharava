/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava1.miinaharava;

import java.util.Random;

/**
 *
 * @author Anton
 */
public class Minefield {
    public int hight; // pelikentän korkeus
    public int width; // peilikentän leveys
    public int mines; // miinojen luku
    private int markedMines; //merkkattujen miinojen luku
    public int[][]table;
    public char[][]gametable;
    private boolean gameover; // arvo on true jos astuit miinan päälle
    
    public Minefield(int hight, int width, int mines){
        this.hight = hight;
        this.width = width;
        this.mines = mines;
        this.table = new int[this.hight][this.width];
        this.gametable = new char[this.hight-1][this.width-1];
        this.gameover = true;
        
        luodamiinat();
        Pelikentta();
    } 
    public int getMines(){
        return this.mines;
    }
    public boolean getGameover(){
        return this.gameover;
    }
    public int[][] getTable(){
        return this.table;
    }
    public char[][] getGametable(){
        return this.gametable;
    }
    

    public void luodamiinat() {
        for(int i = 0; i < this.mines; i++){
            int col, row;
        
        do{
            Random rand = new Random();
            col = rand.nextInt((this.hight- 3)+1)+1; // arvotaan arvoja jotka eivä ole kenttijen reunalla, näin methodissa  luodamuutarvot helpompi
            row = rand.nextInt((this.width- 3)+1)+1; // käsitellä reunnimaiset paikkat, vaikka loogisessa kentässä ne on näkyvillä, oikeassa kentässä
                                                     //reunnimaiset paikkat ovat piilossa     
        } while (this.table[col][row] != 0); // jos paikas ei ole miinna, laitettaan sen sinne
        this.table[col][row] = -1;
        }
        luodamuutarvot();
//        tulosta();
    }
    private void tulosta(){
        for(int i=0; i < this.hight;i++){
            System.out.print(i + " ");
            for(int j=0; j < this.width; j++){
                System.out.print(this.table[i][j] + " ");
            }
            System.out.println("");
        }   
    }
    private void luodamuutarvot(){
        for(int i=0; i < this.hight;i++){
            for(int j=0; j < this.width; j++){ //lu
                if (this.table[i][j] == -1){
                    if(this.table[i-1][j-1] != -1) this.table[i-1][j-1]++; //tässä käydään kaikki paikat miinan ympäri ja jos siellä ei ole miinaa
                    if(this.table[i-1][j] != -1) this.table[i-1][j]++; // kasvatettaan paikan arvo ykkösellä
                    if(this.table[i-1][j+1] != -1) this.table[i-1][j+1]++;
                    if(this.table[i][j-1] != -1) this.table[i][j-1]++;
                    if(this.table[i][j+1] != -1) this.table[i][j+1]++;
                    if(this.table[i+1][j-1] != -1) this.table[i+1][j-1]++;
                    if(this.table[i+1][j] != -1) this.table[i+1][j]++;
                    if(this.table[i+1][j+1] != -1) this.table[i+1][j+1]++;
                }
            }
        }    
    }
    public void Pelikentta(){
        for(int i=1; i < this.gametable.length;i++){ //oikeassa pelikentässä meillä on vähemmän kenttiä kuin loogisessa kentässä
            for(int j=1; j < this.gametable.length; j++){
                this.gametable[i][j] = 'o';
            }
        }
    }
        
    public void tulostaPelikentta(){
        System.out.print("   ");   
        for (int i = 1; i<this.gametable[1].length; i++) {          
            if (i>=this.width-2) {  
            System.out.print(i+" ");  
            }  
            else {  
                System.out.print(i+"  ");  
            }  
        }  
        System.out.println();  
  
          
        System.out.print("   ");  
        for (int i=1; i<this.gametable[1].length; i++) {  
            System.out.print("---");  
        }  
        System.out.println();  
  
      
        for (int i=1; i<this.gametable.length; i++) {           
            if(i>=this.hight-1) {  
            System.out.print(i+"|");  
            }  
            else {  
                System.out.print(i+" |");  
            }  
            for (int j = 1; j<this.gametable[i].length; j++) {  
                System.out.print(this.gametable[i][j]+"  ");  
            }  
            System.out.print("|");  
            System.out.println();  
        }  
   
    }
     public boolean openNbrofMine(int i, int j){
        this.gameover = true;
        if(i > this.hight-2 || j < this.width-2 ){ // jos ruutu on kentät ulkopuolella niin ei tehdään mitään
            return gameover;
        } else{
            if (this.table[i][j] == -1 && this.gametable[i][j] == 'o'){
                openNbrofMine(i-1, j-1);
                openNbrofMine(i-1, j);
                openNbrofMine(i-1, j+1);
                openNbrofMine(i, j+1);
                openNbrofMine(i+1, j+1);
                openNbrofMine(i+1, j);
                openNbrofMine(i+1, j-1);
                openNbrofMine(i, j-1);
                
            }
            else if(this.table[i][j] == -1){
                gameover = false; //astuttaan miinan päälle, niin f
            }
            else {
                int arvo = this.table[i][j];
                char a = Character.forDigit(arvo, 10);
                this.gametable[i][j] = a ;
            }
        }
        return gameover;
       
        
    }
    
    
}
    

