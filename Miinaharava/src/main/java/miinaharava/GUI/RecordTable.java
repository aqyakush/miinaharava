/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharava.GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Anton
 */
public class RecordTable implements Runnable {
     JFrame records;
     Records record;

    /**
     * luodaan recordTable, jossa kaikki ennätykset ovat näkyvillä
     * @throws java.io.IOException
     */
     public RecordTable() throws IOException{
         this.record = new Records();
     }
    @Override
    public void run() {
        records = new JFrame("RecordTable");
        records.setPreferredSize(new Dimension(200, 200)); 

        records.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   
        luoKomponentit(records.getContentPane());

        records.pack();
        records.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(4,4);
        container.setLayout(layout);
        JButton setZero = new JButton("Reset");
        final int[] a = record.getNumbers();
        final JLabel JLeasy = new JLabel(Integer.toString(a[0]));
        final JLabel JLmedium = new JLabel(Integer.toString(a[1]));
        final JLabel JLhard = new JLabel(Integer.toString(a[2]));
        setZero.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    record.setAllZero(); 
                    records.dispose();
                    RecordTable records = new RecordTable();
                    SwingUtilities.invokeLater(records);
                } catch (Exception ex) {
                    System.out.println("UPS");;
                }
                
                
            }
        });
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                records.dispose();
            }
        });
        container.add(new JLabel("1. Easy "));
        container.add(JLeasy);
        container.add(new JLabel("2. Medium "));
        container.add(JLmedium);
        container.add(new JLabel("3. Hard "));
        container.add(JLhard);
        container.add(setZero);
        container.add(back);
        
    }
    
    
    
}
