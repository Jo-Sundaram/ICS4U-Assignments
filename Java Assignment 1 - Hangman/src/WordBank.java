
import java.util.*;

public class WordBank {
    public static String store ; // I made a static string but I don't think I needed to

    public static int generate(int b){
        /* Random number generator method which I technically don't
        need tp have as a separate method but I was just trying stuff out*/
        Random random = new Random();
        return  random.nextInt(b-1);
    }
    public static void main(String[] args) {
      // TODO Auto-generated method stub

	// Opens the WordBank text file (was made separately)
	IO.openInputFile("WordBank.txt");
	int numlines = 0;
	String lines = IO.readLine();

	while(lines != null) {  /*---> Reads through each line in WordBank.txt */
		numlines++;
		lines = IO.readLine();
	}
	IO.closeInputFile();

	String[] words = new String [numlines]; /*----> This array stores all the lines in WordBank.txt*/
	IO.openInputFile("WordBank.txt");
	for (int i = 0; i < numlines; i++) {
		words[i] = IO.readLine();
	}
	IO.closeInputFile();

///////////////////////////////////////////////////    THIS IS THE PLAYING PART          /////////////////////////////////////////////////////
                /* From this section forward are the components that make the gameplay possible by interacting with the user, their input
                                                 and using the information in WordBank.txt */

        int playing = 1; //---> Set condition for while loop
        int guessing =0;//---> Set condition for another while loop
        int endGame = 0;//---> Set condition for yet another while loop
        String keepPlaying = "yes";//---> Alas, another while loop condition

        int newWord= 0; // Integer variable used to pull out random indices of the array words[]

        /* So basically I have this string variable keepPLaying that is set as the condition in this while loop which
        * is what keeps the program looping through the words in the WordBank.txt and allows the user to keep playing*/

        while(keepPlaying.equalsIgnoreCase( "yes")) {
            newWord = generate(numlines);//-----> the random word generating method
            store = (words[newWord]);

	 Scanner key = new Scanner(System.in);	// User's input
	 String input;


	 int numLetters = store.length(); //----> the number of letters in that word
	 int trackGuesses = 0; //----> Well it tracks the number of letter's you've guessed
	 int trackMisses = 0;//----> Same deal but for wrong letters specifically
	 String[] guessed = new String[27];//----> Array to store the total guessed letters
	 String[] bodyparts = {"head (-_-)", "body", "arm", "other arm", "leg", "other leg. This is your last chance"}; /*----> This array contains the ingredients of
	 a gourmet dish called 'stickman' */

	 String[] blanks = new String[numLetters];/*--> displays blanks for each letter  */
     for (int i = 0; i < numLetters; i++){ /*--> and prints it out*/
        blanks[i] = "_";
        System.out.print(blanks[i] + " ");
     }

                        /* This displays the game instructions */
	 System.out.println("this word contains " + numLetters + " letters. you have " + 6 + " chances." +
             " If all the chances are used, you will have murdered a poor innocent stickman");
	 System.out.println("Type 'guess' when you want to guess the word");
	 input = key.nextLine();

	     while (playing ==1) {  /*--> this while loop keeps looping as you are guessing letters */
             char check = input.charAt(0);  //--> this stores the character of the users' input
             if (store.contains(input)) {  //-->this checks if the random word contains the guessed letter*/
                 System.out.println("that's a correct guess");

                 for (int i = 0; i < numLetters; i++) {
                     char fill = store.charAt(i);
                     if (fill == check) {//--> this compares the characters of the input and the letters in the word
                         blanks[i] = input;// and it replaces that blank space with that letter
                     }
                     System.out.print(blanks[i] + " "); // and prints it out
                 }

                 System.out.print("Guessed Letters: "); /*The letters you've guessed are displayed here*/
                 guessed[trackGuesses] = input;
                 for (int i = 0; i< trackGuesses+1; i++){
                     System.out.print(guessed[i] + " ");
                 }

                 System.out.println(" ");
                 trackGuesses += 1;
                 input = key.nextLine();
                 check = input.charAt(0);

             } else {

                 System.out.println("Well, there goes the " + bodyparts[trackMisses] + ". Try again.");// if you guess a wrong letter you lose a body part
                 trackMisses+=1;

                 System.out.print("Guessed Letters: ");/*The letters you've guessed are displayed here*/
                 guessed[trackGuesses] = input;
                 for (int i = 0; i< trackGuesses+1; i++){
                     System.out.print(guessed[i] + " ");
                 }
                 System.out.println(" ");

                 trackGuesses += 1;
                 input = key.nextLine();
             }
             /* If you miss 6 letters you hang the stickman*/
             if(trackMisses >5 && !store.contains(input) && !input.equalsIgnoreCase("guess")){
                 System.out.println("Murderer! You've killed the stickman >:(");
                 System.out.println("The word was: " + store);
                 System.out.println("    |/      |\n" +
                         "    |     (-_-)\n" +
                         "    |      \\|/\n" +
                         "    |       |\n" +
                         "    |      / \\\n" +
                         "    |\n" +
                         "   _|___");
                 trackMisses+=0;
                 endGame =1;
                 playing = 0;
             }

             if (input.equalsIgnoreCase("guess")) { //if the user wants to guess the entire word they have to type 'guess'
                 guessing = 1;       // it will exit this loop and enter the 'guessing' while loop
                 playing = 0;
             }
         }

         /* This is the guessing while loop where it will compare you guessed word with the actualy word*/
         while (guessing ==1) {    // and enter this
             System.out.println("What word is it? : ");
             input = key.nextLine();
             if (store.equalsIgnoreCase(input)) {   // if you guess the right word
                 System.out.println("That's correct! The word was: " + store);
                guessing = 0;
                endGame =1;
             } else {
                 System.out.println("Wah Wah, incorrect. The word was: " + store);//if you guess the wrong word
                 guessing = 0;
                 endGame =1;
             }
         }
                while(endGame ==1) {/*  At the end of the game you are given a choice to play again or exit*/
                    System.out.println("Would you like to keep playing?" + '\n' + " 'yes' or 'no'");
                    keepPlaying = key.nextLine();

                    if (keepPlaying.equalsIgnoreCase("yes")) {// if you say 'yes' then you play again
                        newWord = generate(numlines);
                        store = (words[newWord]);
                        endGame = 0;
                        playing = 1;

                    } else {// if you say 'no' you exit the program
                        endGame = 0;
                        playing = 0;

                    }
                }

        }

	}

}
