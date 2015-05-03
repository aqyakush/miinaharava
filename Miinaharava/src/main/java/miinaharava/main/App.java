package miinaharava.main;



import miinaharava.GUI.Configuration;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 * @author      aqyakush
 * @version     1.0       (current version number of program)
 * @since       2015-03-10     
 */
public class App 
{
    public static void main( String[] args )    {
        Configuration config = new Configuration();
        SwingUtilities.invokeLater(config);
    }
      
}
