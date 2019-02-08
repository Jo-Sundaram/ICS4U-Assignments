import java.util.Scanner;
import java.util.Scanner.*;

public class fileOutTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		// Asking and storing informations
		IO.createOutputFile("file03.txt");
		
		for (int i = 0; i <3; i++){
			
		String person;
		person = keyboard.nextLine();
		String [] people = person.split(" ");
		//IO.println("Person: " + (i + 1));
		
		for(int j = 0; j < 3 ; j++) {
		
		IO.println(people[j]);
		
		}
	}
		IO.closeOutputFile();

		Scanner search = new Scanner ("file03.txt");

		// Counting the number of lines
		IO.openInputFile("file03.txt");
		String lines = IO.readLine();
		int numLines = 0;
		
		while (lines != null) {
			System.out.println(lines);
			numLines ++;
			lines = IO.readLine();
		}
		
		IO.closeInputFile();
		
		
		// Storing the data in an array
		String [] findNames = new String [numLines];
		IO.openInputFile("file03.txt");
		for (int i = 0; i < numLines; i++) {		
			
			findNames[i] = IO.readLine();	
			
		}
		IO.closeInputFile();
		
		
		System.out.print("Enter the line you would like to edit: ");
		String  chooseLine  = keyboard.nextLine();
		//System.out.print("Enter the line you would like to replace it with: ");
		//String editLine = keyboard.nextLine();
		

		IO.openInputFile("file03.txt");
		int startIndex = 0;
		char find = 0;
		for (int i = 0; i < numLines; i ++) {
			findNames[i] = IO.readLine();	
			 startIndex = findNames[i].indexOf(chooseLine);
		}
		 find = chooseLine.charAt(3);
		 System.out.print(find);
		
		

	}
		

}

//https://www.daniweb.com/programming/software-development/code/408638/read-edit-and-write-to-file


