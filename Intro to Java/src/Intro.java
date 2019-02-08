import java.util.Scanner;


public class Intro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World"); 
		System.out.println("New line?");

		String name;
		String movie;
		Scanner keyboard = new Scanner(System.in);
		
		// ASK FOR USER INPUT
		System.out.print("What is thy name?");
		
		// READ INPUT FROM KEYBOARD AND STORE IT IN A VARIABLE
		name = keyboard.nextLine(); // <-- reads strings only
		System.out.print("What is your favourite movie?");
		movie = keyboard.nextLine();
		
		// OUTPUT THE INFO
		System.out.print("Hi " + name + "! I like " + movie + " too!" );
		
		keyboard.close();
		
	}

}
