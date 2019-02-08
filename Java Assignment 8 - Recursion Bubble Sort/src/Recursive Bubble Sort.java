import java.util.*;

class Sorting {
    public static String[] numbers;
    public static int numLines = 0;
    public static int temp;


    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Sorting randomNumbers = new Sorting();

        randomNumbers.readNumbers();
        // randomNumbers.printNumbers();

        //randomNumbers.bubbleSort();
        randomNumbers.recursiveSort(numbers, numLines);
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

  // This is the recursive sort function that sorts the numbers recursively
    //I may have cheated a little bit
    // https://www.geeksforgeeks.org/recursive-bubble-sort/
    public void recursiveSort(String[] array, int n){
        int firstBox;// these two variables are to store the value of the two 'boxes' we're comparing
        int nextBox;
        for(int i = 0; i < n-1; i++){
            firstBox = Integer.parseInt(array[i]);
            nextBox = Integer.parseInt(array[i + 1]);

            if (firstBox > nextBox) { //we compare them to see if the first is greater than the next
                temp = firstBox;//if it is, then is it stored in our temporary box
                array[i] = Integer.toString(nextBox); //the value of the first index will then be replaced by the value of the next box
                array[i + 1] = Integer.toString(temp);//while the value of the next index is replaced by what was in our temporary box
            }
        }
        if (n ==1){ // exit the loop if the number of elements = 1
            return;
        }

        recursiveSort(array, n-1);

    }

    //This function just prints out numbers[] in the console
    public void printNumbers() {
        for (int i = 0; i < numLines; i++) {
            System.out.println(numbers[i]);
        }
    }
}