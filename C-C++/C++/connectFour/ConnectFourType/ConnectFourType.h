//ConnectFour.h the specification file for the class for connect four game

#ifndef CONNECTFOURTYPE.H
#define CONNECTFOURTYPE.H                                                                                                                      
#include <iostream>
#include <string>

using namespace std;

class connectFour
{


	int player;
	int score[2];
	int board[6][7];  //6 = Rows, 7 = Columns
	int move;
	int moveComputer;
	bool win;
	int numOfPlayers;
	string player1;
	string player2;
	string computer;

     public:

	connectFour();
	//Default constructor 
	//Sets the default value for each member

	void setTurn();
	//Function to setup the turn of the player
	//precondition: 
	//		   Win = true
	
	void display();
	//This function clears the screen and then shows the board
	//preconditions:
	//		   numOfPlayers = 2
	//		   numOfPlayers = 1
	//

	void movePlayer();
	//This function sets the move of the player
	//precondition: 
	//		   emptySpots = 0


	void checkWin();
	//This function checks for any winning combination
	//Horizontal, vertical, diagonal
	//precondition: 
	//		   start = 0

	void clearScreen();
	//This function clears the screen

	void displayBoard();
	//This function display only the board
	
	void computerMove();
	//This function defines the move of the computer
	//precondition: 
	//		  move = RandomNumber

	void displayMenu();
	//This function displays the menu of the game
	//

	void DisplayBoard();
	//This function displays the board

	void clearBoard();
	//This function clears the board 
	//postcondition: 
	//                board[i][x]=0
	

};

#endif
	
