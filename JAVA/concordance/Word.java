import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Word {
	

	
   public String getWord() 
   {

	    
	    String RetValue = null;
		String OneLine;
		StringTokenizer strtok = null;
		try
		{
			FileInputStream instream = new FileInputStream("/home/luis/index.txt");
			DataInputStream DataFile = new DataInputStream(instream);

			if(	((OneLine = (String)DataFile.readLine()) != null))
			{
				strtok = new StringTokenizer(OneLine);
					
				while(strtok.hasMoreTokens())
				{
					
					RetValue = strtok.nextToken();
					
				}
	
			}//while
			instream.close();
		}//try
		catch (Exception e)
		{System.out.println("Error");}
   	
		return RetValue;
		
   }
   
   public int getLine() 
   {
	   
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
	              strtok.nextToken();
	          }
		
		 
		iLine++;
		
		
		
	    }//while
		
		instream.close();

	    }//try
	    
	    catch (Exception e)
	    
	    {System.out.println("Error");}
	    
	    return iLine ;
   }
   
  
}



