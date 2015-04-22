/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava1.miinaharava;

import java.awt.Container;
import java.awt.Dimension;
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
     * @param args the command line arguments
     */

    @Override
    public void run() {
        config = new JFrame("MineSweeper");
        config.setPreferredSize(new Dimension(200, 300)); //kentän koko on 400*400

        config.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   
        luoKomponentit(config.getContentPane());

        config.pack();
        config.setVisible(true);
        
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.add(new JLabel("Valitsee vaikeaus aste:"));
        JRadioButton easy = new JRadioButton("Easy");
        JRadioButton medium = new JRadioButton("Medium");
        JRadioButton hard = new JRadioButton("Hard");
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
