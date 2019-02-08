import java.util.Scanner.*;
import java.util.Random;
import java.util.Scanner;

public class fileOUT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		// Create the file to which we are goign to write in
		IO.createOutputFile("file02.txt");
		
		// This is the Random() method
		Random  randomInt = new Random();
		int a = 100;
		int[] randInts = new int [a];
		
		// This will store the random integers we want
		int newInt = 0;
		int userPick = 0;
		//userPick = keyboard.nextInt();
		
		
		for(int i = 0; i < a; i++) {
			newInt = randomInt.nextInt(10);	
			randInts[i] = newInt;
			IO.println(Integer.toString(randInts[i]));
			System.out.println(randInts[i]);
		}
		
		IO.closeOutputFile();
		
		
	}

}
