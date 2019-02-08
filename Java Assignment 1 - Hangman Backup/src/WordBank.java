
import java.util.*;

public class WordBank {
    public static String store ;

    public static int generate(int b){
        // Random number generator
        Random random = new Random();
        return  random.nextInt(b-1);
    }
    public static void main(String[] args) {
      // TODO Auto-generated method stub

	// Opens the WordBank text file (was made separately)

	IO.openInputFile("WordBank.txt");
	int numlines = 0;
	String lines = IO.readLine();
	while(lines != null) {      /* Reads through each line in
								WordBank */
		//System.out.println(lines);
		numlines++;
		lines = IO.readLine();
	}
	IO.closeInputFile();

	String[] words = new String [numlines];
	/*int newWord = random.nextInt(numlines -1);   /*Random number to pick index of array words[]
	                                                  and assigns the randomly chosen word in word[]*/

    int newWord= 0;
	IO.openInputFile("WordBank.txt");
	for (int i = 0; i < numlines; i++) {    // Stores information into array words[]
		words[i] = IO.readLine();
	}
	IO.closeInputFile();
        newWord = generate(numlines);
        store = (words[newWord]);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                /* THIS IS THE PLAYING PART */

	 Scanner key = new Scanner(System.in);	// User's input
	 String input;
     String keepPlaying;

	 int numLetters = store.length(); // the number of letters in that word
	 int trackGuesses = 0;
	 int trackMisses = numLetters - 3;
	 String[] guessed = new String[27];

	 String[] blanks = new String[numLetters];   // displays blanks for each letter
         for (int i = 0; i < numLetters; i++){
            blanks[i] = "_";
            System.out.print(blanks[i] + " ");
        }
	 System.out.println("this word contains " + numLetters + " letters. you have " + trackMisses + " strikes");
	 System.out.println("Type 'guess' when you want to guess the word");
	 System.out.println(newWord);

	 input = key.nextLine();

//-----------------------------------------------------------------------------------------------------------------
	 /* This section here calculates the number of times
	   that the guessed letter appears in the word except it doesn't work
	   I found this example from this link : https://tinyurl.com/ybfhqzr9 */

		int nextIndex = 0;
		int indices = 0;

		while (nextIndex != -1) {
            nextIndex = store.indexOf(input, nextIndex);        //shit doesn't work
            if (nextIndex != -1) {
                indices++;
                nextIndex += input.length();
            }

        }
// -------------------------------------------------------------------------------------------------------------------
///////////////////
        int playing = 1;
		int guessing =0;
	 while(numLetters != 0) {
	     while (playing ==1) {
             if (store.contains(input)) {       //if the random word contains the guessed letter
                 System.out.println("that's a correct guess");
                 trackGuesses += 1;

                 for (int i = 0; i < numLetters; i++) { // it replaces that blank space with that letter
                     int fill = store.indexOf(input);
                     blanks[fill] = input;
                     System.out.print(blanks[i] + " "); // and prints it out
                 }

                 input = key.nextLine();
             } else {
                 trackMisses -= 1;
                 System.out.println("try again.");  // if you guess a wrong letter
                 input = key.nextLine();
             }


             if (input.equalsIgnoreCase("guess")) { //if the user wants to guess the entire word
                 guessing = 1;       // it will exit this loop
                 playing = 0;
             }
         }
         while (guessing ==1) {    // and enter this
                 System.out.println("What word is it? : ");
                 input = key.nextLine();
                 if (store.equalsIgnoreCase(input)) {   // if you guess the right word
                     System.out.println("That's correct!  " + store);

                 } else {
                     System.out.println("Wah Wah, incorrect");//if you guess the wrong word
                 }

                 System.out.println("Would you like to keep playing?" + '\n' + " 'yes' or 'no'");
                 keepPlaying = key.nextLine();

                 if(keepPlaying.equalsIgnoreCase("yes")){
                     newWord = generate(numlines);
                     store = (words[newWord]);
                     guessing = 0;
                     playing = 1;

                 }else {
                     guessing = 0;
                     playing = 0;
                     numLetters = 0;
                 }
         }


////////////////////////////////////////////////////////
         /*else if (trackMisses == 0){
             System.out.println("you used up all your strikes. sorry");

         }*/

        /* if (trackGuesses == numLetters) {
             System.out.println("you got all the letters, GUESS THE WORD");
             System.out.println(store);
         } else if (trackMisses == 0){
             System.out.println("you used up all your strikes. sorry");

         }*/
     }

	}

}
