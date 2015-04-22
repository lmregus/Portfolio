//============================================================================
// Name        : TicTacToe.cpp
// author      : Luis Regus
// created     : 9/12/13
// revisions   : 
//
// description : This program prints the start screen of a console based
// 		 tic-tac-toe game
//
// usage       : Ask the user for the number of players, and the name of
//		 each player. Ask for both names even if the number of
//		 players is 1 - it can be added later.
//
// _____________________________
//  Input      | Output
/**

   If the number of players is 2 the expected/tested results are:
 -----------------------------------------------------------------------  
    Please enter the number of players: 2
    Player one! Give me your name please: luis
    Player two! Give me your name please: miguel

    Welcome to Tic-Tac-Toe!
    Number of players: 2
    luis Vs. miguel

    ____|____|____ 
    ____|____|____
        |    |

 If the number of players is 1 the expected/tested results are:
 ----------------------------------------------------------------------- 

    Please enter the number of players: 1
    Player one! Give me your name please: luis

    Welcome to Tic-Tac-Toe!
    Number of players: 1
    luis Vs. Computer

    ____|____|____
    ____|____|____
        |    |

 If the number of players is less than 1 or greater than 2 the expected/tested results are:
 ----------------------------------------------------------------------- 

    Please enter the number of players: 0

    Sorry this game can be played by one or two players only.

     
    Please enter the number of players: 4

    Sorry this game can be played by one or two players only.
	



**/ ------------------------------
//  report your expected/tested results
/============================================================================

#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

int main() {

	int numOfPlayers = 1;
	string player1 = "Bob";
	string player2 = "Lisa";
	string computer = "Computer";

	cout << "Please enter the number of players: ";
	cin >> numOfPlayers;

	if(numOfPlayers == 2)
	{

		cout << "Player one! Give me your name please: " ;
		cin >> player1;

		cout << "Player two! Give me your name please: " ;
		cin >> player2;

		cout << "\nWelcome to Tic-Tac-Toe!" << endl;
		cout << "Number of players: " << numOfPlayers << endl ;
		cout << player1 << " Vs. " << player2 << "\n" << endl;

        	cout << setfill('_');
		cout << setw(5) << '|' << setw(5) << '|' << setw(4) << '_' << endl;
		cout << setw(5) << '|' << setw(5) << '|' << setw(4) << '_' << endl;

		cout << setfill(' ');
		cout << setw(5) << '|' << setw(5) << '|' << "\n" << endl;


	}
	else if(numOfPlayers == 1)
	{

		cout << "Player one! Give me your name please: " ;
		cin >> player1;

		cout << "\nWelcome to Tic-Tac-Toe!" << endl;
		cout << "Number of players: " << numOfPlayers << endl ;
		cout << player1 << " Vs. " << computer << "\n" << endl;

		cout << setfill('_');
		cout << setw(5) << '|' << setw(5) << '|' << setw(4) << '_' << endl;
		cout << setw(5) << '|' << setw(5) << '|' << setw(4) << '_' << endl;

		cout << setfill(' ');
		cout << setw(5) << '|' << setw(5) << '|' << "\n" << endl;


	}
	else
	{

		cout << "\nSorry this game can be played by one or two players only.\n" << endl;

	}

	return 0;
}





















