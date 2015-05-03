/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava.GUI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Lue tietoa tiedostosta ja päivittää niitä tarvittaessa
 * @author Anton
 */
public class Records {
    private int[] numbers;
    private Tallentaja tallentaja;
    
    public Records() throws IOException{
        this.numbers = new int[3];
        this.tallentaja = new Tallentaja();
        Readinfo();
    }
    
     /**
     * Luen tietoa failista Records.txt
     * @throws IOException jos tiedosto ei löyty
     */
    
    public void Readinfo() throws IOException{
        try{
            int a=0;
            for (String line : Files.readAllLines(Paths.get("Records.txt"))) {
                for (String part : line.split("\\s+")) {
                    int i = Integer.valueOf(part);
                    this.numbers[a]=i;
                    a++;
                }
            }    
        } catch (IOException e){
            System.out.println("UPS cant find the file");
        }
        
    }
    /**
     * päivittää ennätysajat
     * 
     * @throws Exception jos tiedostoa ei ole olemassa
     */
    public void SetNewRecords() throws Exception {
        String record = "";
        for(int number: this.numbers){
            record += Integer.toString(number) + " ";
        }
        tallentaja.kirjoitaTiedostoon("Records.txt", record);
        
    }
    public int[] getNumbers(){
        return this.numbers;
    }
    public void setNumbers(int level, int luku){
        this.numbers[level] = luku;
        try {
            SetNewRecords();
        } catch (Exception ex) {
            System.out.println("UPS");
        }
    }
    public void setAllZero() throws Exception{
        this.tallentaja.kirjoitaTiedostoon("Records.txt", "9999 9999 9999");
    }
}
