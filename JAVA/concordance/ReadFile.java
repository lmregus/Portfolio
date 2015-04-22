import java.io.*;
import java.util.*;

class ReadFile
{
//Example of Reading a file and using StringTokenizer
public static void main (String[] args)
{
	HashMap<Integer, String> Words = new HashMap<Integer, String>();
	LinkedList<Integer> Lines = new LinkedList<Integer>();
	
	int iLinkedListPosition = 0;
	int iKey = 1;
	int iLine = 1;
    String OneLine;
    StringTokenizer strtok;
    try
    {
      FileInputStream instream = new FileInputStream("/home/luis/index.txt");
	  DataInputStream DataFile = new DataInputStream(instream);

	while(	(OneLine = (String)DataFile.readLine()) != null)
    {
		  
          strtok = new StringTokenizer(OneLine);
          
          while (strtok.hasMoreTokens())
          {
        	  
              Words.put(iKey,strtok.nextToken());
              
              System.out.println("Hash Map: " + Words.get(iKey));
              iKey++;
              
          }
          
          Lines.add(iLine);
          System.out.println("All the words above appeared in the line #: " + Lines.get(iLinkedListPosition));
          iLine++;
          iLinkedListPosition++;
          
          
    }//while
	instream.close();
	
    }//try
    catch (Exception e)
    {System.out.println("Error");}
}//main
}//ReadFile