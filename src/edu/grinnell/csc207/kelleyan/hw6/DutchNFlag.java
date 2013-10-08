package edu.grinnell.csc207.kelleyan.hw6;

import java.io.PrintWriter;

/**
 * 
 * @author southpaw14, Andrew Kelley
 * @author Mira Hall
 * 
 * DutchNFlag is a class that contains the method to solve
 * the classic problem of the Dutch National Flag. In this
 * problem, an array of colors containing "red", "white", 
 * and "blue" is given and must be sorted into the pattern
 * of red, white, then blue. This sort must also be
 * accomplished over one iteration of the array.
 */
public class DutchNFlag {
	
	

	
	/**
	 * dutchFlag takes a string array of non-sorted colors
	 * and returns the same array sorted in the order of
	 * red, white, then blue.
	 * 
	 * @pre the strings in the array must only be either "red",
	 * "white", or "blue" in english and lower case.
	 * 
	 * @param colors, a string array of red, white, and blue
	 * colors
	 * 
	 * @return the same array, colors, the is now sorted by 
	 * color into the order of red, then white, then blue.
	 */
	public static String[] dutchFlag(String[] colors) {
		int i = 0; //the iterator
		int redFlag = 0; /*keeps track of the location of the
						 farthest to the right "red" */
		int blueFlag = colors.length - 1;  /*keeps track of the
					location of the farthest to the right "red" */
		while (i < colors.length){
			if(colors[i] == "white"){
				i++; /* White colors can be skipped over as they
				will be in the middle and all the other colors
				will be placed around them */
			} else if(colors[i] == "red" && i > redFlag){
				swap(colors, redFlag, i);
				redFlag++;
				continue; /* Need to recheck what was switched 
				into colors[i] */
			} else if(colors[i] == "blue" && i < blueFlag){
				swap(colors, blueFlag, i);
				blueFlag--;
				continue; /* Need to recheck what was switched 
				into colors[i] */
			} else if(i <= redFlag || i >= blueFlag) {
				i++; /* In these cases, the colors are in their
				correct places, so no swapping is needed */
			}
		} //end while
		return colors; //return original array, now sorted
	} //end dutchFlag
	
	/**
	 * Swap is a helper-procedure that switches two items
	 * in an array, specifically a String array.
	 * @param stringArray, a string array
	 * @param indexOne, an index of an item needing to be swapped
	 * @param indexTwo, an index of an item needing to be swapped
	 */
	public static void swap(String[] stringArray, int indexOne, int indexTwo){
		String tmp = stringArray[indexOne];
		stringArray[indexOne] = stringArray[indexTwo];
		stringArray[indexTwo] = tmp;
	} //end swap
	
	/**
	 * main allows for a demonstration of the above algorithm.
	 * @param args
	 */
	public static void main(String[] args) {
		PrintWriter pen = new PrintWriter(System.out, true);
		String[] unsortedFlag = new String[] {"blue", "red", "white", "red", "red", "white", "blue", "red", "blue", "white"};
		String[] sortedFlag = dutchFlag(unsortedFlag);
		for(int i = 0; i < sortedFlag.length; i++){
		pen.println(sortedFlag[i] + " ");
		}
	} //end main

} //end DutchNFlag
