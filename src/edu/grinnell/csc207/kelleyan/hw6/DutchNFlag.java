package edu.grinnell.csc207.kelleyan.hw6;

import java.io.PrintWriter;

public class DutchNFlag {
	
	

	/**
	 * @param args
	 */
	
	public static String[] dutchFlag(String[] colors) {
		int i = 0;
		int redFlag = 0;
		int blueFlag = colors.length - 1;
		while (i < colors.length){
			if(colors[i] == "white"){
				i++;
			} else if(colors[i] == "red" && i > redFlag){
				swap(colors, redFlag, i);
				redFlag++;
				continue;
			} else if(colors[i] == "blue" && i < blueFlag){
				swap(colors, blueFlag, i);
				blueFlag--;
				continue;
			} else if(i <= redFlag || i >= blueFlag) {
				i++;
			}
		}
		return colors;
	}
	
	public static void swap(String[] stringArray, int indexOne, int indexTwo){
		String tmp = stringArray[indexOne];
		stringArray[indexOne] = stringArray[indexTwo];
		stringArray[indexTwo] = tmp;
	}
	
	public static void main(String[] args) {
		PrintWriter pen = new PrintWriter(System.out, true);
		String[] unsortedFlag = new String[] {"blue", "red", "white", "red", "red", "white", "blue", "red", "blue", "white"};
		String[] sortedFlag = dutchFlag(unsortedFlag);
		for(int i = 0; i < sortedFlag.length; i++){
		pen.println(sortedFlag[i] + " ");
		}
		//pen.println("end");
	}

}
