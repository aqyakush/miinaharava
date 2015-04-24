/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava1.miinaharava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
    private int miinat;
    
    /**
     * Pelin varsinnainen alusta, missä itse peli tapahtuu
     * 
     * @param row kentän rivijen määrä
     * @param col kentän sarakkeiden määrä
     * @param mines miinojen määr'
     */
    
    public GUI(int row, int col, int mines){
        this.row=row; 
        this.col=col; 
        this.miinat = mines;
        this.peli = new Minefield(col+2, row+2, mines);
        
    }
    /**
     *  Luodaan JFrame josta kutsutaan methodi luoKomponetit
     *  ja riipujen siitä kuinka iso kenttä, valittaa framen koko
     */

    @Override
    public void run() {
        frame = new JFrame("MineSweeper");
        if(this.col == 5){
            frame.setPreferredSize(new Dimension(400, 400)); //kentän koko on 400*400
        } else if(this.col == 15){
            frame.setPreferredSize(new Dimension(900, 900)); //kentän koko on 400*400
        } else if(this.col == 25){
            frame.setPreferredSize(new Dimension(1300, 1300)); //kentän koko on 400*400
        }

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
        JLabel mines = new JLabel(Integer.toString(this.peli.mines));
        mines.setHorizontalAlignment(JLabel.CENTER);
        JButton restart = new JButton("Restart");
        TimerDisplay time = new TimerDisplay();
        panel.add(mines);
        panel.add(restart);
        panel.add(time);
        restart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { // silloin kun painetaan restart, suljetaan vanha JFram ja luodaan uusi
                frame.dispose();
                GUI peli = new GUI(row, col, miinat);
                SwingUtilities.invokeLater(peli);                
            }
        });

        JPanel kentta = new JPanel(new GridLayout(this.row,this.col));
        JButton[][] nappi = new JButton[this.row][this.col];
        
        for(int i=0; i<this.row;i++){
            for(int j=0; j<this.col; j++){
                nappi[i][j] = new JButton();
                nappi[i][j].setFont(new Font("Arial", Font.BOLD, 25));
                nappi[i][j].setBackground(Color.GRAY);
                kentta.add(nappi[i][j]);
                nappi[i][j].addMouseListener(new MouseListen(i, j, this.peli, nappi, frame, mines, time)); // jokaisella napille laitettaan hiirenKuuntelija
            }
        }
        JPanel Spanel = new JPanel(new GridLayout(1, 1));
        JButton config = new JButton("Change difficulty ");
//        JButton recordtable = new JButton("Tarkistaa ennatykset");
        config.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Configuration config = new Configuration();
                SwingUtilities.invokeLater(config);     
            }
        });
//        recordtable.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                RecordTable records = new RecordTable();
//                SwingUtilities.invokeLater(records);
//            }
//        });
        Spanel.add(config);
//        Spanel.add(recordtable);
        time.start();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH); // Miinat, Restart, Aika laitettaan ylös
        container.add(kentta, BorderLayout.CENTER); // kentä on alhalla
        container.add(Spanel, BorderLayout.SOUTH);

    }
    
}
    

