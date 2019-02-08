import java.util.*;
import java.util.Scanner;
public class Hangman extends WordBank {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /*https://tinyurl.com/ybfhqzr9 */

        Scanner key = new Scanner(System.in);

        String str = "helloslkhellodjladfjhello";

        int lastIndex = 0;
        int count = 0;
        int numLetters = str.length();
        String newFind;
        String findStr;
        String[] blanks = new String[numLetters];



        for (int i = 0; i < numLetters; i++) {//-----------> blanks
            blanks[i] = "_";
            System.out.print(blanks[i] + " ");
        }


        newFind = key.nextLine();

            if (str.contains(newFind)) {

                for (int j = 0; j < numLetters; j++) { // it replaces that blank space with that letter
                    int fill = str.indexOf(newFind);
                    blanks[fill] = newFind;
                    System.out.print(blanks[j] + " "); // and prints it out
                }


            }

        while (lastIndex != -1) {
                findStr = newFind;
                lastIndex = str.indexOf(findStr, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += findStr.length();
                }

            }
            System.out.println(count);


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