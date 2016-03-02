/** @author Michael Groot*/


/** Importing package so I can use stuff*/
import java.util.*;

/** This is the class!*/
public class ArrayStas {

	/** defining the array variable*/
	private static int[] myArray;
	
	/** This is the method generating random numbers*/
	public static int randomFiller(){
			
			/** making an object for the random numbers*/
		    Random rand = new Random();
		    
		    /** random numbers from 1-100*/
		    int randomNum = rand.nextInt(100) + 1;
		    
		    /** returning the number*/
		    return randomNum;
	}
	
	/** method to make the array*/
	public static int[] makeArray(){
		
		/** Creating the array for 300 numbers*/
		myArray = new int [300];
		
		/** filling array with random numbers from the random method*/
		 for(int i = 0; i < myArray.length; i++){
		        myArray[i] = randomFiller();
		 }
		 
		 /** Conveniently sorts the random numbers in the array in order*/
		 Arrays.sort(myArray);
		 
		 /** returns sorted array*/
		return myArray;
	}
	
	/** method to print the sorted array*/
	public static void printArray(){
		
		/** This takes array and prints 20 numbers before going to the next line*/
	    for(int j = 1; j <= 300; j++){
	            if (j % 20 != 0)
	                System.out.print(myArray[j-1]+ " ");
	            else
	                System.out.println(myArray[j-1]);
	    }
	}
	
	/** This method is for printing the graph after the array*/
	public static void printGraph(){
		
		/** defining the variables for each required section*/
		int oneToTwenty = 0;
		int twentyOneToForty = 0;
		int fortyOneToSixty = 0;
		int sixtyOneToEighty = 0;
		int eightyOneToOneHundred = 0;
		
		/** going through the array in sections, increasing variables if the specific number falls into that section*/
		for(int k = 0; k < myArray.length; k++){
			
			if (myArray[k] <= 20){
				oneToTwenty = oneToTwenty + 1;
			}
			
			else if (myArray[k] >= 21 && myArray[k] <= 40){
				twentyOneToForty = twentyOneToForty + 1;
			}
			
			else if (myArray[k] >= 41 && myArray[k] <= 60){
				fortyOneToSixty = fortyOneToSixty + 1;
			}
			
			else if (myArray[k] >= 61 && myArray[k] <= 80){
				sixtyOneToEighty = sixtyOneToEighty + 1;
			}
			
			else{
				eightyOneToOneHundred = eightyOneToOneHundred + 1;
			}
		}
		
		/** print statements to print the section, amount of numbers that fall in the section, and the star chart that goes with it*/
		 System.out.println(" 1 -  20: " + starString("*",oneToTwenty) + "  " + oneToTwenty);
		 System.out.println("21 -  40: " + starString("*",twentyOneToForty) + "  " + twentyOneToForty);
		 System.out.println("41 -  60: " + starString("*",fortyOneToSixty) + "  " + fortyOneToSixty);
		 System.out.println("61 -  80: " + starString("*",sixtyOneToEighty) + "  " + sixtyOneToEighty);
		 System.out.println("81 - 100: " + starString("*",eightyOneToOneHundred) + "  " + eightyOneToOneHundred);
		 
	}
	
	/** method to print the star chart*/
	public static String starString(String string, int stringLength){
		
		/** takes string builder from import package to make string*/
		StringBuilder starString = new StringBuilder();
	    
		/** Adding a star to the string for each number that falls in the category*/
		for(int n = 0; n < stringLength; n++){
	        starString.append(string);
	    }
		
		/** returns complete star string*/
	    return starString.toString();
	}
	
	/** main method*/
	 public static void main(String args[]) throws Exception {

		 /** calling method to make array*/
		 makeArray();
		 
		 /** printing the array with the method*/
		 printArray();
		 
		 /** separation*/
		 System.out.println("-----------------------------------------------------------------------------------------------");
		 
		 /** printing statistics graph including star string*/
		 printGraph();		
	 }	 
}
