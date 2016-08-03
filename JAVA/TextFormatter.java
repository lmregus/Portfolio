/**
 *	Developer: Luis Regus
 *	Class: Introduction to Java
 *  Date: 07/15/2016
 *  Description: Read words from an input file and write them to an output file, removing
 *				 extra whitespace and filling each line with as many words as will fill up
 *				 to a maximum column width
 *				 
 *				 Compile and run the program, the follow the instructions
 *				 there are 2 test files HW8_1.txt and HW8_2.txt that can be used
 *				 to test 
**/
import java.util.*;

import java.io.*;

public class TextFormatter {
	public static void main(String[] args) {
		String line = "";
		Scanner keyboardInput = null;
        int width = 0;
		File rFile = null;		//file to read
		File oFile = null;      //file to write
		PrintWriter outputStream = null;
		Scanner inputStream = null;
		String answer = "";		

		do {
			System.out.println("Please enter maximum formatted output. 30 - 100.");
			keyboardInput = new Scanner(System.in);
			width = keyboardInput.nextInt();
		}while (width < 30 || width > 100);
	
		do {
			System.out.println("Please enter the file name to read.");
			keyboardInput = new Scanner(System.in);
			rFile = new File(keyboardInput.next());
			System.out.println(Boolean.toString(rFile.canRead()));
			if(!rFile.exists()) {
				System.out.println("File does not exist. Please try again.");
			}
		}while(!rFile.exists());

		do {
			System.out.println("Please enter the file name to write.");
			oFile = new File(keyboardInput.next());
			if (oFile.exists()) {
				System.out.println("The file already exist. Do you want to over write it? yes/no");
				answer = keyboardInput.next();
				if (answer.equals("no")) {
					System.out.println("Please enter the file name to write.");
					oFile = new File(keyboardInput.next());
					answer = "";
				}
			}
		}while (answer.equals("no"));

		try {
        	inputStream = new Scanner(rFile);
        } catch(FileNotFoundException e) {
        	System.out.println("Error opening the file " + rFile.getName());
			System.exit(0);
        }

		try {
			outputStream = new PrintWriter(new FileOutputStream(oFile));
		} catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + oFile.getName());
            System.exit(0);
		}

		for (int counter = 0; counter < width; counter++) {
			outputStream.print('*');
		}
		outputStream.println();		

		while (inputStream.hasNext()){
			String word = inputStream.next();
			if ((word.length() + line.length()) > width) {
				outputStream.println(line);
				line = word + " ";
			}else {
				line += word + " ";
			}
		}
		outputStream.println(line);
		
		inputStream.close();
		outputStream.close();
	}

}
