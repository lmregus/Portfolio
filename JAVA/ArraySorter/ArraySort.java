/**
 *  ArraySort Class
 *  Developer: Luis Regus
 *  Class: Introduction to Java
 *  Date: 06/15/2016
 *
 *  Description: This program asks the user for length and elements of an array prints the values
 *               and sorts the array.
 *
 */

import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args) {
        String[] arguments = new String[] {"start"};
        System.out.println("Enter the size of the array (3 to 10):");
        Scanner keyboard = new Scanner(System.in);
        int length = keyboard.nextInt();

        if ( length >= 3 && length <= 10) {
            int[] myArr = new int[length];
            myArr = fillArray(myArr);
            System.out.println("The unsorted values...");
            printArray(myArr);
            System.out.println("The sorted values...");
            printArray(sortArray(myArr));
            System.out.println("Press control-c to quit.");
            main(arguments);
        }else {
            System.out.println("Please make sure that the number is between 3 and 10");
            main(arguments);
        }
    }

    /**
     *  Fills an integer array with the values given by the user
     *
     *  @param pArray the array to be filled
     *  @return       the filled array
     */
    public static int[] fillArray(int[] pArray) {
        for (int i = 0; i < pArray.length; i++) {
            System.out.println("Enter values for element " + Integer.toString(i) + ":");
            Scanner keyboard = new Scanner(System.in);
            pArray[i] = keyboard.nextInt();
        }

        return pArray;
    }

    /**
     *  Prints an int array
     *
     *  @param pArray the array to be printed 
     */
    public static void printArray(int[] pArray) {
        for (int i = 0; i < pArray.length; i++) {
            System.out.println(pArray[i]);
        }
    }

    /**
     *  Sorts an integer array implementing the
     *  selection sort algorithm
     *
     *  @param pArray the array to be sorted
     *  @return       the sorted array
     */
    public static int[] sortArray(int[] pArray) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < (pArray.length - 1); i++) {
                if (pArray[i] > pArray[i+1]) {
                    int tempVal = pArray[i];
                    pArray[i] = pArray[i+1];
                    pArray[i+1] = tempVal;
                    swapped = true;
                }
            }    
        }while (swapped == true);
        
        return pArray;
    }

}
