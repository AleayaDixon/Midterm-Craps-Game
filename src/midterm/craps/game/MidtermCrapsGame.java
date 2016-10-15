/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm.craps.game;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Aleaya
 */
public class MidtermCrapsGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random x = new Random();
        Scanner keyboard = new Scanner (System.in);
        //int die1 = 2 + x.nextInt(5);
        //int die2 = 2 + x.nextInt(5);
        System.out.println("How much would you like to bet?");
        int bet = keyboard.nextInt();
        int roll;
        String summary[] = new String[20];
        int i = 0;
        int tot = 0;
        int point = 0;
        //String condition = "";
        while (bet != 0)
        {
            int die1 = 2 + x.nextInt(5);
            int die2 = 2 + x.nextInt(5);
            roll = die1 + die2;
            if (point == 0 && (roll == 7 || roll == 11))
            {
               System.out.println("You rolled " + roll);
               System.out.println("You win! $" + bet + " added to your pot.");
               summary[i] = "You won $" + bet;
               tot += bet;
               System.out.println("How much would you like to bet?");
               bet = keyboard.nextInt();
               i++;
            }
            else if (point == 0 && (roll == 2 || roll == 3 || roll == 12))
            {
               System.out.println("You rolled " + roll);
               System.out.println("You lose. $" + bet + " subtracted from your pot.");
               summary[i] = "You lost $" + bet;
               tot -= bet;
               System.out.println("How much would you like to bet?");
               bet = keyboard.nextInt();
               i++;
            }
            else
            {
                if (point == 0)
                {
                    point = roll;
                    System.out.println("You rolled " + roll + ". POINT is " + point);
                    die1 = 2 + x.nextInt(5);
                    die2 = 2 + x.nextInt(5);
                    roll = die1 + die2;
                }
                else 
                {
                //while loop for new POINT rules
                //while (!condition.equals("WIN") && !condition.equals("LOSE"))
                //{
                        die1 = 2 + x.nextInt(5);
                        die2 = 2 + x.nextInt(5);
                        roll = die1 + die2;
                        if(roll == point)
                        {
                            //condition = "WIN";
                            System.out.println("You rolled " + roll);
                            System.out.println("You win! $" + bet + " added to your pot.");
                            summary[i] = "You won $" + bet;
                            tot += bet;
                            System.out.println("How much would you like to bet?");
                            bet = keyboard.nextInt();
                            point = 0;
                            i++;
                        }
                        else if(roll == 7)
                        {
                            //condition = "LOSE";
                            System.out.println("You rolled " + roll);
                            System.out.println("You lose! $" + bet + " subracted from your pot.");
                            summary[i] = "You lost $" + bet;
                            tot -= bet;
                            System.out.println("How much would you like to bet?");
                            bet = keyboard.nextInt();
                            point = 0;
                            i++;
                        }
                        else
                        {
                            System.out.println("You rolled " + roll + ". POINT is " + point);
                            die1 = 2 + x.nextInt(5);
                            die2 = 2 + x.nextInt(5);
                            roll = die1 + die2;
                            //i++;                       
                        }
                } 
                //}
            }
        }
        for(int z = 0; z < i; z++)
        {
            System.out.println(summary[z]);
        }
        if(tot > 0)
        {
            System.out.println("You are ahead $" + tot);
        }
        else 
        {
            System.out.println("You are behind $" + tot);
        }
        
        keyboard.close();
    }
    
}
