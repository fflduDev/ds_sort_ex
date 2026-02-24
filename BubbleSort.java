package bookEx;

import java.text.DecimalFormat;
import java.util.Random;

public class BubbleSort {

	static final int SIZE = 50; // size of array to be sorted
	static int[] values = new int[SIZE]; // values to be sorted

	static void initValues()
	// Initializes the values array with random integers from 0 to 99.
	{
		Random rand = new Random();
		for (int index = 0; index < SIZE; index++)
			values[index] = Math.abs(rand.nextInt()) % 100;
	}

	static public boolean isSorted()
	// Returns true if the array values are sorted and false otherwise.
	{
		for (int index = 0; index < (SIZE - 1); index++)
			if (values[index] > values[index + 1])
				return false;
		return true;
	}

	static public void swap(int index1, int index2)
	// Precondition: index1 and index2 are >= 0 and < SIZE.
	//
	// Swaps the integers at locations index1 and index2 of the values array.
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}

	static public void printValues()
	// Prints all the values integers.
	{
		int value;
		DecimalFormat fmt = new DecimalFormat("00");
		System.out.println("The values array is:");
		for (int index = 0; index < SIZE; index++) {
			value = values[index];
			if (((index + 1) % 10) == 0)
				System.out.println(fmt.format(value));
			else
				System.out.print(fmt.format(value) + " ");
		}
		System.out.println();
	}

/////////////////////////////////////////////////////////////////
//
//  Bubble Sort

	// Switches adjacent pairs that are out of order 
	// between values[startIndex]..values[endIndex] 
	// beginning at values[endIndex].
	static void bubbleUp(int startIndex, int endIndex)
	{
		for (int index = endIndex; index > startIndex; index--)
			if (values[index] < values[index - 1])
				swap(index, index - 1);
	}

	// Sorts the values array using the bubble sort algorithm.
	static void bubbleSort()
	{
		int current = 0;

		while (current < (SIZE - 1)) {
			bubbleUp(current, SIZE - 1);
			current++;
		}
	}
 
	
	 public static void main(String[] args)
	  {
	    initValues();
	    printValues();
	    System.out.println("values is sorted: " + isSorted());
	    System.out.println();
	    
	    bubbleSort();
	
	    printValues();
	    System.out.println("values is sorted: " + isSorted());
	    System.out.println();
	  }

}
