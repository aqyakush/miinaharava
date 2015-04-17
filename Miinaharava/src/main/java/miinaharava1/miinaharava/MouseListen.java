/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava1.miinaharava;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Anton
 */
class MouseListen implements MouseListener {
    private int i;
    private int j;
    private Minefield peli;
    private JButton[][] nappit;
    private String[][] gametable;
    private JFrame frame;
    
    
    /**
     * Luodaan hiirjenKuuntelija
     * 
     * @param i napin rivi
     * @param j napin sarakke
     * @param peli itse pelin logiikka
     * @param nappit kaikki napit kentällä
     * @param frame ikkuna missä peli tapahtuu
     */
    public MouseListen(int i, int j, Minefield peli, JButton[][] nappit, JFrame frame) {
        this.i=i;
        this.j=j;
        this.peli = peli;
        this.nappit = nappit;
        this.gametable = peli.getGametable();
        this.frame = frame;
        
    }
    
    /**
     * Hiirenkuuntelija, käsitele kaikki tapaukset kun painetaan hiirella johonkin nappiin.
     * 
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        this.peli.Opensquare(this.i+1, this.j+1);
        JButton button = (JButton)e.getSource();
        if(this.peli.CheckforWin() == true){
            JOptionPane.showMessageDialog(this.frame, "You won!! Press Restart to start a new game");
        }
        if(e.getButton()==1){
            if(this.gametable[i+1][j+1] == "o"){
               JOptionPane.showMessageDialog(this.frame, "You LOST!! Press Restart to start a new game");
            } else{
                openField(button);
            }
        }  else if(e.getButton() == 3){
            this.nappit[this.i][this.j].setText("X");
        }
        
    }
    
    /**
     * Silloin kun klikataan johonkin ruutuun, jos se on tyhjä niin 
     * avataan kaikki ruudut sen ympäri. Mutta jos ruudulla on numero niin avataan vain se ruutu
     * @param button nappi joka on klikattu
     */
    public void openField(JButton button){
        if (this.gametable[i+1][j+1] != " "){
                button.setText(this.gametable[i+1][j+1]);
                button.setEnabled(false);
            } else {
                for(int r=0; r<this.gametable.length-1;r++){
                    for(int c=0; c<this.gametable.length-1;c++){
                        if(this.gametable[r+1][c+1] != "o"){
                            this.nappit[r][c].setText(this.gametable[r+1][c+1]);
                            this.nappit[r][c].setEnabled(false);
                        }  
                    }
                }
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
