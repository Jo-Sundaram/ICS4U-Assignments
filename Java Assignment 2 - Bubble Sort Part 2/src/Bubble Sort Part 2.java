import java.util.*;

class Sorting {
    public static String[] numbers;
    public static int numLines = 0;
    public static int temp;// the temporary box
    public static int sortChoice; // these ints takes the user's choice on how to sort the numbers
    public static int direction; // direction as in high to low or low to high for the bubble sort


    public static void main(String[] args) {
        Sorting randomNumbers = new Sorting();
        randomNumbers.chooseSort();/* I made this one method contains the entire project I think that's pretty cool (more information below)*/
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


                if (direction ==1) { // if the user picked low to high
                    if (firstBox > nextBox) { //we compare them to see if the first is greater than the next
                        temp = firstBox;//if it is, then is it stored in our temporary box
                        numbers[i] = Integer.toString(nextBox); //the value of the first index will then be replaced by the value of the next box
                        numbers[i + 1] = Integer.toString(temp);//while the value of the next index is replaced by what was in our temporary box

                        switched = true;//Now that a switch has occurred, our flag can be raised to repeat through this loop
                        i -= 1;//the starting index will be moved over by one

                    }
                }else if (direction ==2){//if the user picked high to low
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

    // This is the selection sort function --> https://www.geeksforgeeks.org/selection-sort/
    public void selectionSort(){
        int firstBox;// these two variables are to store the value of the two 'boxes' we're comparing
        int nextBox;

            // One by one move boundary of unsorted subarray
            for (int i = 0; i < numLines-1; i++) {
                // Find the minimum element in unsorted array
                int min_idx = i;
                firstBox = Integer.parseInt(numbers[min_idx]);
                for (int j = i+1; j < numLines; j++) { //looks at all the indices after the minimum index
                    nextBox = Integer.parseInt(numbers[j]);
                    if (nextBox < firstBox)// compares the next index to the minimum index
                        min_idx = j;
                     firstBox = Integer.parseInt(numbers[min_idx]);
                    // Swap the found minimum element with the first
                    // element

                }
                temp = Integer.parseInt(numbers[min_idx]);
                numbers[min_idx] = numbers[i];
                numbers[i] = Integer.toString(temp);


            }


        }

    // This is the gnome sort function (I really liked the name of it) --> https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/
    public void  gnomeSort(){
        int index = 0;
        int firstBox ;
        int nextBox ;

        while (index < numLines) {
            if (index == 0) { // the index is used to go through all the elements in numbers[]
                index++;
            }
            firstBox = Integer.parseInt(numbers[index]);
            nextBox = Integer.parseInt(numbers[index - 1]);
            if (firstBox>= nextBox) { // here we compare the first to see if it is greater than the next box
                index++; // if it is, then the index moves on to the next element
            }
             else { // if it is not, they swap values using the temp box
                temp = 0;
                temp = Integer.parseInt(numbers[index]);
                numbers[index] = numbers[index - 1];
                numbers[index - 1] = Integer.toString(temp);
                index--;// and the index takes a step back to confirm again that the element is greater than the previous element
            }
        }
    }

    //This function just prints out numbers[] in the console
    public void printNumbers() {
        for (int i = 0; i < numLines; i++) {
            System.out.println(numbers[i]);
        }
    }

    /* This the function that allows you to choose which type of sort you want to use.
   I took all of the above functions and put them in here so only one method is called in main(), like a
   5 in 1 package deal */
    public void chooseSort(){
        Scanner key = new Scanner(System.in);
        Sorting randomNumbers = new Sorting();
        randomNumbers.readNumbers();
        System.out.println("Here is a list of random numbers : ");
        randomNumbers.printNumbers();

        System.out.println("What kind of sorting method would you like to use? : ");
        System.out.println(" '1' - Bubble Sort");
        System.out.println(" '2' - Selection Sort");
        System.out.println(" '3' - Gnome Sort");
        sortChoice = key.nextInt();// here is the sorting choice

        if( sortChoice ==1) {
            System.out.println("You chose Bubble Sort ");
            System.out.println("Enter how you would like the numbers sorted: ");
            System.out.println(" '1' - Low to high");
            System.out.println(" '2' - High to low");
            direction = key.nextInt();// here is the direction choice
            randomNumbers.bubbleSort();
        }else if (sortChoice ==2){
            System.out.println("You chose Selection Sort");
            randomNumbers.selectionSort();
        }else if (sortChoice ==3){
            System.out.println("You chose Gnome Sort ");
            randomNumbers.gnomeSort();
        }

        randomNumbers.printNumbers();


    }


}