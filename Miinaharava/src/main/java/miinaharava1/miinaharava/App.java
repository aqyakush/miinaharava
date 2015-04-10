package miinaharava1.miinaharava;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    {
        int col= 11;
        int row = 11;
        Minefield board = new Minefield(col, row, 10);
//        board.PrintBasetable();
//        Scanner lukija = new Scanner(System.in);
//        while(!board.getGameover()){
//            System.out.println("Syötä rivin numero");
//            int row1 = Integer.parseInt(lukija.nextLine());
//            System.out.println("Syötä saraken numero");
//            int col1 = Integer.parseInt(lukija.nextLine());
//            System.out.println("M merkitta miina ja A avaa ruutu");
//            String vastaus = lukija.nextLine();
//            switch (vastaus) {
//                case "M":
//                    board.MarktheMine(row1, col1);
//                    break;
//                case "A":
//                    board.Opensquare(row1, col1);
//                    break;
//            }
//            board.printGametable();
//            if (board.CheckforWin() == true) {
//                System.out.println("You WON!!");
//                break;
//            }
//        }
//        System.out.println("Peli päätyi");
    }
    
}
