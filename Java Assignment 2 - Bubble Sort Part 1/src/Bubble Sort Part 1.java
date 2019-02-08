import java.util.*;

class Sorting {
    public static String[] numbers;
    public static String[] sortedList;
    public static int numLines = 0;
    public static int temp;
    public static int sortChoice; // this int takes the user's choice on how to sort the numbers


    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Sorting randomNumbers = new Sorting();

        randomNumbers.readNumbers();
        randomNumbers.printNumbers();

        System.out.println("Enter how you would like the numbers sorted: ");
        System.out.println(" '1' - Low to high");
        System.out.println(" '2' - High to low");
        sortChoice = key.nextInt();// here is the sorting choice

        randomNumbers.bubbleSort();
        randomNumbers.printNumbers();


    }

    // This function is just to read the through textfile and store the numbers in the array numbers[]
    public void readNumbers() {
        IO.openInputFile("Random Numbers.txt");
        String lines = IO.readLine();

        while (lines != null) {
            numLines++;
            lines = IO.readLine();
        }
        IO.closeInputFile();

        numbers = new String[numLines];

        IO.openInputFile("Random Numbers.txt");
        for (int i = 0; i < numLines; i++) {
            numbers[i] = IO.readLine();
        }
        IO.closeInputFile();

    }

    // This is the bubble sort function that contains both low-to-high and high-to-low options
    public void bubbleSort() {
        boolean switched;  // here is our flag to raise and lower to enter the while loop
        int firstBox;// these two variables are to store the value of the two 'boxes' we're comparing
        int nextBox;

        switched = true;// the flag is raised and we are able to enter the while loop

        while (switched) {
            switched = false;//flag is lowered

            for (int i = 0; i < numLines - 1; i++) {

                // first box and next box are assigned to the first two indices in the array
                firstBox = Integer.parseInt(numbers[i]);
                nextBox = Integer.parseInt(numbers[i + 1]);


                if (sortChoice ==1) { // if the user picked low to high
                    if (firstBox > nextBox) { //we compare them to see if the first is greater than the next
                        temp = firstBox;//if it is, then is it stored in our temporary box
                        numbers[i] = Integer.toString(nextBox); //the value of the first index will then be replaced by the value of the next box
                        numbers[i + 1] = Integer.toString(temp);//while the value of the next index is replaced by what was in our temporary box

                        switched = true;//Now that a switch has occurred, our flag can be raised to repeat through this loop
                        i -= 1;//the starting index will be moved over by one

                    }
                }else if (sortChoice ==2){//if the user picked high to low
                    if (firstBox < nextBox) { //we compare them to see if the first is less than the next
                        temp = firstBox;//if it is, then is it stored in our temporary box
                        numbers[i] = Integer.toString(nextBox); //the value of the first index will then be replaced by the value of the next box
                        numbers[i + 1] = Integer.toString(temp);//while the value of the next index is replaced by what was in our temporary box

                        switched = true;//Now that a switch has occurred, our flag can be raised to repeat through this loop
                        i -= 1;//the starting index will be moved over by one

                    }
                }

            }

        }
    }


    //This function just prints out numbers[] in the console
    public void printNumbers() {
        for (int i = 0; i < numLines; i++) {
            System.out.println(numbers[i]);
        }
    }


}