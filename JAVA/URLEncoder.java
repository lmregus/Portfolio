/**
    Developer: Luis Regus

    Description: This program URL encodes a line of text.
**/

import java.util.Scanner;

public class URLEncoder {
    public static void main(String[] args) {
    int index;
	String encodedLine = "";	
	String hexValue = "";
	String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-.*";

	System.out.println("Enter a line of text to be URL encoded");

    String userInput;
	Scanner keyboard = new Scanner(System.in);
	userInput = keyboard.nextLine();

	System.out.println("The string read is: " + userInput);
	System.out.println("The lenght in chars is: " + userInput.length());
	
	for (index = 0; index < userInput.length(); index++) {
	    char srcChar = userInput.charAt(index);

	    if (srcChar == ' ') {
	        encodedLine += '+';
	    }else if (chars.indexOf(srcChar) != -1){
			encodedLine += srcChar;
	    }else {
			hexValue = "%" + Integer.toHexString(srcChar);
			encodedLine += hexValue;
	    }
	}
	
	System.out.println("The encoded string is: " + encodedLine);
	System.out.println("Length in chars us: " + encodedLine.length());
    
	}
}
