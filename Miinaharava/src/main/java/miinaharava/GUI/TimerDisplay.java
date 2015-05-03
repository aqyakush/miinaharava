
package miinaharava.GUI;

import java.awt.Color;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Anton
 */
public class TimerDisplay extends JLabel {
    private final static long STEPS = 1000; 
    private int seconds=-1;
    private int minutes=0;
    private java.util.Timer timer;
    
    
    /**
     *  luodaan ajasti joka alkaa toimia kun peli alkaa ja sitten pysähtyy kun peli 
     *  on voitettu tai hävitetty
     */
    public TimerDisplay(){
        setForeground(Color.red);
        setHorizontalAlignment(JLabel.CENTER);
        setText(""+0);
    }
    
    
    /**
     * Alkaa ajan lasku
     * 
     */
    public void start() {
        timer=new java.util.Timer();
            TimerTask task=new TimerTask() {
                public void run() {
                    if(minutes > 60){
                        setText("Seriously?");
                    } else {
                        if(seconds > 60){
                            minutes++;
                            seconds = 0;
                        } else {
                            seconds++;                       
                        }
                        if(seconds > 9){
                            setText(String.valueOf(minutes) + ":" + String.valueOf(seconds));  
                        } else {
                            setText(String.valueOf(minutes) + ":" + "0" + String.valueOf(seconds));
                        }                     
                    }
                }
            };
        timer.scheduleAtFixedRate(task,0,STEPS);
    }
    
    /**
     * pysäyttää kello
     */
    public void stop() {
        timer.cancel();
    }
    
    /**
     * pistää kello nollaksi
     * 
     */
    public void reset() {
        timer.cancel();
        seconds=-1;
        setText(""+0);    
    }
    
    /**
     * Palauttaa String jono, jossa lukee aika
     * 
     * @return palauttaa aika, kun peli oli suoritettu loppuun
     */
    public String getTime() {
        String second;
        if (seconds > 9){
             second = Integer.toString(seconds);
        } else {
             second = "0"+Integer.toString(seconds);
        }
        String aika = Integer.toString(minutes) + ":" + second;
        return aika;  
    }
    
    public int getSeconds(){return seconds;}
    public int getMinutes(){return minutes;}
}
