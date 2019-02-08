import java.util.Scanner;

public class Generator {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        String str = "helloslkhellodjladfjhello";
        int lastIndex = 0;
        int count = 0;
        int numLetters = str.length();
        String newFind;
        String input;

        String[] blanks = new String[numLetters];
        for (int i = 0; i < numLetters; i++) {
            blanks[i] = "_";
            System.out.print(blanks[i] + " ");
        }

        int trackGuesses = 0;
        int playing = 1;
        int a = 0;
        String[] guessed = new String[27];


        boolean duplicates = false;
        input = key.nextLine();
        while (numLetters != 0) {
            while (playing == 1) {
                if (str.contains(input)) {       //if the random word contains the guessed letter
                    System.out.println("that's a correct guess");
                    trackGuesses += 1;
                    guessed[a] = input;
                    a += 1;

                    for(int i = 0; i <trackGuesses; i++){
                    System.out.print(guessed[i]);
                    }


////////////////////////////////////////////////////////
                }
                input = key.nextLine();

            }


        }
    }
}