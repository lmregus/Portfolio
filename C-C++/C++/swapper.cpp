//=====================================================================
// Name        : swapper.cpp
// author      : Luis Regus
// created     : 10/16/13
// revisions   : 
//
// description : This function takes a string as input and swaps
//               the last and first letter.
// usage       : Swaps the last and first letter of a given string.
//		 
//		 
//
//_____________________________________________________________________
//             Input                         |          Output
//             apple                         |          eppla
//	       swapper			     |          rwappes
//	       donkey   		     |         	yonked	
//					     |
//___________________________________________|_________________________

void swapper(char word[])
{

    char firsWord = word[0];
    char lastWord = word[strlen(word) - 1];
    
    int x = strlen(word) - 1;    //limit to loop through the char array

    cout << lastWord;            
    
    for(int i = 1; i < x; i++)
    {

        cout << word[i];        //prints what's between the first and last character

    }

    
    cout << firsWord << endl;
    


}

