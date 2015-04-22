//============================================================================
// Name        : replacer.cpp
// author      : Luis Regus
// created     : 10/17/13
// revisions   : 
//
// description : This program has a function that takes three
//		 parameters: a string, a character to look and
//		 replace, and a second character to replace the first.
//		 The function looks through a string for the first
//               character and replaces all occurrences with the
//		 second one.
//
// usage       : Give the function a string and two characters.
//
//
//
//
//___________________________________________________________________________________________________________________________________________
//             Input                         |           Output
//                                           |     
//	       apple, l, p		     |	  Model: word, letter to replace, replacer letter.
//					     |	  Given word and letters: apple, p, q
//					     |	  Letter was not found in position: 0
//					     |	  Letter was not found in position: 3
//					     |	  Letter was not found in position: 4
//    					     |	  Letter(s) had been replaced:
//					     |	  aqqle, p, q
//					     |
//	       michael penta, e, i     	     |	  Model: word, letter to replace, replacer letter.
//					     |	  Given word and letters: michael penta, e, i
//					     |	  Letter was not found in position: 0
//					     |	  Letter was not found in position: 1
//                                           |    Letter was not found in position: 2
//					     |	  Letter was not found in position: 3
//					     |	  Letter was not found in position: 4
//					     |    Letter was not found in position: 6
//					     |	  Letter was not found in position: 7
//					     |	  Letter was not found in position: 8
//					     |	  Letter was not found in position: 10
//					     |    Letter was not found in position: 11
//  					     |	  Letter was not found in position: 12
//					     |	  Letter(s) had been replaced:
//					     |	  michail pinta, e, i
//					     |		
//___________________________________________|_________________________________________________________________________

#include <iostream>
#include <string>

using namespace std;


void replacer(string word, char letterToReplace, char replacerLetter);

int main()
{

        replacer("apple", 'p', 'q');

}

void replacer(string word, char letterToReplace, char replacerLetter)
{


        cout << "Model: " << "word, " << "letter to replace, " << "replacer letter." << endl;
        cout << "Given word and letters: " << word << ", " << letterToReplace << ", " << replacerLetter <<endl;


        for(int i = 0; i < word.length(); i++)
        {



            if(word[i] == letterToReplace)
            {


                word[i] = replacerLetter;


               

            }else
            {

                cout << "Letter was not found in position: " << i << endl;

            }



     }
            cout << "Letter(s) had been replaced:" << endl;
            cout << word << ", " << letterToReplace << ", " << replacerLetter << endl;
}


