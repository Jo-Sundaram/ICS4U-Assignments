import java.util.*;
import java.util.Scanner;
public class Hangman extends WordBank{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner key = new Scanner(System.in);

        String str = "helloslkhellodjladfjhello";

        int lastIndex = 0;
        int count = 0;
        int i = 1;
        String newFind;
        String findStr;


       // newFind = key.nextLine();

     while (i ==1) {

         newFind = key.nextLine();

         while (lastIndex != -1) {
             findStr = newFind;
             lastIndex = str.indexOf(findStr, lastIndex);

             if (lastIndex != -1) {
                 count++;
                 lastIndex += findStr.length();
             }

         }
         System.out.println(count);
        lastIndex = 0;
        i =0;
     }

     while (i==0) {
         System.out.println("New Letter:");
         i = 1;
     }

    }
}


   /*

        Scanner keyboard = new Scanner(System.in);

        String input = keyboard.nextLine();
        if (input.equalsIgnoreCase(WordBank.store)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
                 */