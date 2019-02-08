import java.util.*;
public class TextFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner (System.in);

		IO.createOutputFile("FirstFile.txt");
		IO.print("Hello World");
		IO.closeOutputFile();
		
		IO.createOutputFile("Highscores.txt");
		IO.println("Mouse: 14s");
		IO.println("Lion: 6s");
		IO.closeOutputFile();

		
		//First we need to count the number of lines we have in the file
		
		IO.openInputFile("Highscores.txt");
		String line = IO.readLine();
		int numLines = 0;
		
		while(line != null) {
			System.out.println(line.toUpperCase());
			numLines ++;
			line = IO.readLine();	
		}
		System.out.println(numLines);
		IO.closeInputFile();
		
		
		
		//Now we can store these lines in an array
		
		String[] highScores = new String[numLines];
		
		IO.openInputFile("Highscores.txt");
		
		for(int i = 0; i < numLines; i++) 
			
			highScores[i] = IO.readLine();
		
		IO.closeInputFile();
		
		/*
		 * Now we can do things with the data
		 */
		

		
		for(int i=0; i< numLines ;i++) 
			
			System.out.println(highScores[i].toLowerCase());
		
		
	}

}
