import java.io.*;
import java.util.*;

/**
 * The concordance class splits a file into words
 * Gives the line number where the words appeared 
 * @author 
 * 		Luis
 * @version
 * 		1.0
 *
 */
class Concordance
{
	HashMap<Integer, String> Words = new HashMap<Integer, String>();
	LinkedList<Integer> Lines = new LinkedList<Integer>();
	
	int iLinkedListPosition = 0;
	int iKey = 1;
	int iLine = 1;
    String OneLine;
    StringTokenizer strtok;
    

   
   /**
    * Prints the words along with the line number 
    */
    public void getConcordance()
    {
	
    	try
    	{
    		FileInputStream instream = new FileInputStream("/home/luis/index.txt");
    		DataInputStream DataFile = new DataInputStream(instream);

    		while(	(OneLine = (String)DataFile.readLine()) != null)
    		{
		  
    			
    			strtok = new StringTokenizer(OneLine);
          
    			while (strtok.hasMoreTokens())
    			{
    				String cleanWord =  strtok.nextToken().replaceAll("[^\\p{L}\\p{N}]", "");   //using a regex to just take the words(no characters)
    				Words.put(iKey,cleanWord);        //Adding the words to the HashMap
              
    				System.out.println("Hash Map: " + Words.get(iKey));
    				iKey++;
              
    			}
          
    			Lines.add(iLine); 								//Adding the Lines the LinkeList
    			System.out.println("All the words above appeared in the line #: " + Lines.get(iLinkedListPosition));
    			iLine++;
    			iLinkedListPosition++;
    			  
          
    		}//while
    		instream.close();
	
    	}//try
    	catch (Exception e)
    	{System.out.println("Error File Not Found");}
    }

}