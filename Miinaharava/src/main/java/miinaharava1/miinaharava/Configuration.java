/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava1.miinaharava;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Anton
 */
public class Configuration implements Runnable {
    JFrame config;
    
    /**
     * Luodaan frame Configuration valikolle
     * 
     */

    @Override
    public void run() {
        config = new JFrame("Configuration");
        config.setPreferredSize(new Dimension(300, 200)); //kentän koko on 300X200

        config.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   
        luoKomponentit(config.getContentPane());

        config.pack();
        config.setVisible(true);
        
    }
    
    /**
     * luodaan framen kaikki napit ja kentät tässä metodissa
     * 
     * @param container frame config
     */

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
        container.setLayout(layout);
        JLabel pick = new JLabel("Valitse vaikeaus aste:");
        pick.setFont(new Font("Arial", Font.BOLD, 20));
        container.add(pick);
        JRadioButton easy = new JRadioButton("Easy");
        JRadioButton medium = new JRadioButton("Medium");
        JRadioButton hard = new JRadioButton("Hard");
        easy.setFont(new Font("Arial", Font.BOLD, 15));
        medium.setFont(new Font("Arial", Font.BOLD, 15));
        hard.setFont(new Font("Arial", Font.BOLD, 15));
        easy.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GUI peli = new GUI(5,5,4);
                SwingUtilities.invokeLater(peli);
                config.dispose();
            }
        });
        medium.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GUI peli = new GUI(15,15,27); 
                SwingUtilities.invokeLater(peli);
                config.dispose();
            }
        });
        hard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GUI peli = new GUI(25,25,50);
                SwingUtilities.invokeLater(peli);
                config.dispose();
            }
        });
        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(easy);
        buttongroup.add(medium);
        buttongroup.add(hard);
        container.add(easy);
        container.add(medium);
        container.add(hard);
        
    }
    
}
