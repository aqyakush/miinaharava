/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava1.miinaharava;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Anton
 */
public class GUI implements Runnable {
    JFrame frame;
    private int col;
    private int row;
    private Minefield peli;
    
    public GUI(){
        this.row=7; 
        this.col=7; 
        this.peli = new Minefield(col+2, row+2, 6);
        
    }
    /**
     *  Luodaan JFrame jostain kutsutaan methodi luoKomponetit
     */

    @Override
    public void run() {
        frame = new JFrame("MineSweeper");
        frame.setPreferredSize(new Dimension(400, 400)); //kentän koko on 400*400

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
     
    /**
     * Luodaan kaksi JPanel yläreunassa on kenttä mikä näyttää merkittomijen miinojen määrä
     * seuravaksi menee nappi Restart jossa käynistään peli uudestaan ja sit on JLabel joka
     * näyttää paljon aikaa meni pelin alusta.
     * Toinen JPanel on itse peli, missä on taulukko, joka on koolta n*n, jokaisella napilla on 
     * oma Mouselistener.
     * 
     * @param container 
     */
    private void luoKomponentit(Container container) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JLabel mines = new JLabel("mines");
        JButton restart = new JButton("Restart");
        JLabel time =new JLabel("time");
        panel.add(mines);
        panel.add(restart);
        panel.add(time);
        restart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { // silloin kun painetaan restart, suljetaan vanha JFram ja luodaan uusi
                frame.dispose();
                GUI kayttoliittyma = new GUI();
                SwingUtilities.invokeLater(kayttoliittyma);
                  
            }
        });

        JPanel kentta = new JPanel(new GridLayout(this.row,this.col));
        JButton[][] nappi = new JButton[this.row][this.col];
        
        for(int i=0; i<this.row;i++){
            for(int j=0; j<this.col; j++){
                nappi[i][j] = new JButton();
                kentta.add(nappi[i][j]);
                nappi[i][j].addMouseListener(new MouseListen(i, j, this.peli, nappi, frame)); // jokaisella napille laitettaan hiirenKuuntelija
            }
        }
        
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH); // Miinat, Restart, Aika laitettaan ylös
        container.add(kentta, BorderLayout.CENTER); // kentä on alhalla

    }
    
}
    

