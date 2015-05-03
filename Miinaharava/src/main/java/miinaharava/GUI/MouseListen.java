/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import miinaharava.Logiikka.Minefield;

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
    private JLabel mine;
    private TimerDisplay time;
    private Records record;
    
    
    /**
     * Luodaan hiirjenKuuntelija
     * 
     * @param i napin rivi
     * @param j napin sarakke
     * @param peli itse pelin logiikka
     * @param nappit kaikki napit kentällä
     * @param frame ikkuna missä peli tapahtuu
     */
    public MouseListen(int i, int j, Minefield peli, JButton[][] nappit, JFrame frame, JLabel mine, TimerDisplay time, Records record) {
        this.i=i;
        this.j=j;
        this.peli = peli;
        this.nappit = nappit;
        this.gametable = peli.getGametable();
        this.frame = frame;
        this.mine = mine;
        this.time = time;
        this.record = record;
        
    }
    
    /**
     * Hiirenkuuntelija, käsitele kaikki tapaukset kun painetaan hiirella johonkin nappiin.
     * 
     */

    @Override
    public void mouseClicked(MouseEvent e) {
        Icon redflag = new ImageIcon("redflag.png");
        this.peli.Opensquare(this.i+1, this.j+1);
        JButton button = (JButton)e.getSource();
        if(this.peli.CheckforWin() == true){
            openAllfield(true);
            this.peli.mines = 0;
            mine.setText(Integer.toString(this.peli.mines));
            time.stop();
            int aika = time.getSeconds() + time.getMinutes()*60;
            int[] tulos = this.record.getNumbers();
            if ( this.peli.getGametable().length == 6){
                if (tulos[0] > aika){
                    this.record.setNumbers(0, aika);
                    JOptionPane.showMessageDialog(this.frame, "You WON!! Your time is " + this.time.getTime() + " It is new record.  Press Restart to start a new game.");
                }else {
                    JOptionPane.showMessageDialog(this.frame, "You WON!! Your time is " + this.time.getTime() + " Press Restart to start a new game.");
                }
            }else if ( this.peli.getGametable().length == 16){
                if (tulos[1] > aika){
                    this.record.setNumbers(1, aika);
                    JOptionPane.showMessageDialog(this.frame, "You WON!! Your time is " + this.time.getTime() + " It is new record.  Press Restart to start a new game.");
                } else {
                    JOptionPane.showMessageDialog(this.frame, "You WON!! Your time is " + this.time.getTime() + " Press Restart to start a new game.");
                }
            }else if ( this.peli.getGametable().length == 26){
                if (tulos[2] > aika){
                    this.record.setNumbers(2, aika);
                    JOptionPane.showMessageDialog(this.frame, "You WON!! Your time is " + this.time.getTime() + ". It is new record.  Press Restart to start a new game.");
                } else {
                    JOptionPane.showMessageDialog(this.frame, "You WON!! Your time is " + this.time.getTime() + " Press Restart to start a new game.");
                }
            }    
        }
        else {
            if(e.getButton()==1){
                if(this.gametable[i+1][j+1] == "o"){
                    openAllfield(false);
                    time.stop();
                   JOptionPane.showMessageDialog(this.frame, "You LOST!! Press Restart to start a new game");

                } else{
                    if (this.nappit[this.i][this.j].getIcon() != null && this.nappit[this.i][this.j].getIcon().getIconHeight() == redflag.getIconHeight()){
                        this.nappit[this.i][this.j].setIcon(null);
                        this.peli.mines++;
                    }
                    openField(button);
                }
            }  else if(e.getButton() == 3){
                if(this.nappit[this.i][this.j].getIcon() != null && this.nappit[this.i][this.j].getIcon().getIconHeight() == redflag.getIconHeight()){
                    this.nappit[this.i][this.j].setIcon(null);
                    this.peli.mines++;
                } else{
                    this.nappit[this.i][this.j].setIcon(redflag);
                    this.peli.mines--;
                }
            }  
        }
        mine.setText(Integer.toString(this.peli.mines));
    }
    
    /**
     * Jokaiselle numerolle annettaan oma väri, että ne eroituis paremmin pelaessa
     * 
     * @param button nappi johon painettiin 
     */
    
    public void ColorButton(JButton button){
        if (button.getText().equals("1")){
            button.setBackground(Color.blue);
        } else if (button.getText().equals("2")){
            button.setBackground(Color.GREEN);
        } else if (button.getText().equals("3")){
            button.setBackground(Color.RED);
        } else if (button.getText().equals("4")){
            button.setBackground(Color.orange);
        } else if (button.getText().equals("5")){
            button.setBackground(Color.orange);
        } else if (button.getText().equals("6")){
            button.setBackground(Color.cyan);
        } else if (button.getText().equals("7")){
            button.setBackground(Color.orange);
        }  else if (button.getText().equals("8")){
            button.setBackground(Color.YELLOW);
        } else if (button.getText().equals(" ")){
            button.setBackground(Color.white);
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
                ColorButton(button);
                button.setEnabled(false);
        } else {
            for(int r=0; r<this.gametable.length-1;r++){
                for(int c=0; c<this.gametable.length-1;c++){
                    if(this.gametable[r+1][c+1] != "o"){
                        this.nappit[r][c].setText(this.gametable[r+1][c+1]);
                        ColorButton(this.nappit[r][c]);
                        this.nappit[r][c].setEnabled(false);
                    }  
                }
            }
        }
    }
    /**
     * avataan kentän kaikki ruudut, metodi kutsuttaan siinä tapauksessa kun peli
     * on voitettu tai hävitetty
     * 
     * @param winlose true jos voitettu, false jos hävitetty
     */
    public void openAllfield(boolean winlose){
        Icon minepic = new ImageIcon("mine.gif");
        for(int r=0; r<this.gametable.length-1;r++){
              for(int c=0; c<this.gametable.length-1;c++){
                  this.peli.Opensquare(r+1, c+1);
                  if ( winlose == true){
                      if(this.gametable[r+1][c+1] == "o"){
                          this.nappit[r][c].setText(null);
                      } else{
                            this.nappit[r][c].setText(this.gametable[r+1][c+1]);
                            ColorButton(this.nappit[r][c]);
                            this.nappit[r][c].setEnabled(false);
                      }  
                  } else{
                      if(this.gametable[r+1][c+1] == "o"){
                        this.nappit[r][c].setText("");  
                        this.nappit[r][c].setIcon(minepic);
                        this.nappit[r][c].setBackground(Color.white);
//                        this.nappit[r][c].setEnabled(false);
                    } else {
                        this.nappit[r][c].setText(this.gametable[r+1][c+1]);
                        ColorButton(this.nappit[r][c]);
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
