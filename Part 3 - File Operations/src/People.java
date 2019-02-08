import java.util.Scanner;

public class People {
	String name;
	String address;
	int age;
	

	public People(String name) {
	    this.name = name;
        System.out.println("Name:" + name );

	}


	public void personAddress(String personAddress) {
		address = personAddress;
        System.out.println("Address:" + address );
		
	}
	
	public void personAge(int personAge) {
	    age = personAge;
        System.out.println("Age:" + age );
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		// Asking and storing informations
		
		String name = keyboard.nextLine();  /////////// Store names and stuff
		People person1 = new People(name);
        person1.name = name;
        
		String address = keyboard.nextLine();
		person1.address = address;
		
		int age = keyboard.nextInt();
		person1.age = age;
		
		IO.createOutputFile("file03.txt");
		IO.println(name);
		IO.println(person1.address);
		IO.println(Integer.toString(person1.age));
		IO.closeOutputFile();
		
//////////////////////////////////////////////////////
		
		IO.createOutputFile("file03.txt", true);
        String find = keyboard.nextLine();
        IO.println(find);
        IO.closeOutputFile();
		
        
	    IO.openInputFile("file03.txt");
	    String lines = IO.readLine();
	    int numLines = 0;
	    while (lines != null) {
		    System.out.println(lines);
		    numLines ++;
		    lines = IO.readLine();
	    }
	
	    IO.closeInputFile();

	    
	    
	    

//	IO.openInputFile("file03.txt");
//		String [] findNames = new String [numLines];
//		boolean match = false;
//
//		System.out.println("Enter key words: ");
//		String find = keyboard.nextLine();
//
//
//		for (int i = 0; i < numLines; i++) {
//			findNames[i] = IO.readLine();
//			match = find.equalsIgnoreCase(findNames[i]);
//			System.out.println(match);
//
//	IO.closeInputFile();





	}

	
}
	

