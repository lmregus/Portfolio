/**
    Written by: Luis Regus
    ID:00264958
    Version: 1.2    
**/


//**********************************************************************
// This function is an update version of the printRect() function with a boolean  
// to specify if the square is going to be full or empty.
//*****************************************************************************


void printRect(int width, int height, bool filled = false)
{


   if(filled == true)
 	{
    		for(int i = 1; i <= height; i++)
    		{
        		for(int j = 1;j <= width; j++) //inner for loop controls the inside of the square
        		{
            			if((j==1 || j==width || i==1 || i==height)) //controls the top and bottom of the square
                		
                            cout<<'*';
                        else
                            
                            cout<<' ';
        		}

       		cout<<endl;
       		
    		}
    		
    cout<<endl;
    
    }else
     {

        for(int b = 0; b < height; b++)
        
	 {


       		 for(int c = 1; c < width; c++)
        	 {

		            cout << '*';


        	 }

         	cout << '*' << endl;
    	 }

     }


}
