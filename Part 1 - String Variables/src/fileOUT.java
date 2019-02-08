import java.util.Scanner;
import java.util.Scanner.*;

public class fileOUT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userInput;
		Scanner keyboard = new Scanner(System.in);
		userInput = keyboard.nextLine();
		
		IO.createOutputFile("file01.txt");
		IO.println(userInput);
		IO.closeOutputFile();
		
		keyboard.close();
		
		
		IO.openInputFile("file01.txt");
		String line = IO.readLine();
		int numLines = 0;
		
		
		while (line != null) {
			System.out.print(line);
			line = IO.readLine();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
