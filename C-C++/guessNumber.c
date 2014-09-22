/*
----------------------------------------------------------------------------------------------

   Name: Luis Regus
   ID: 00264058
   Date: 2/22/14

   Description: This program plays the game of guess the number.

   Usage: The program chooses the number to be guessed by selecting at random in the range 1 to 
          1000. The program implements two functions start() and play(int), that starts the 
	  game and plays it respectively. To generate random numbers, the <stdlib.h> must be 
	  included.


-----------------------------------------------------------------------------------------------*/


#include <stdio.h>
#include <stdlib.h>

void play( int );
void start ( void );

int randomNumber;

int main ( void )
{

	randomNumber = (1 + (rand() % 1000)); //Generates a random number from 1 to 1000
	
	start();

	return 0;

}//end main


//This function starts the game
void start( void )
{

	int userGuess;

	printf("I have a number bewtween 1 and 1000\n");
	
	printf("Can you guess my number?\n");

	printf("Please type your first guess.\n");
	scanf("%d", &userGuess);	

	play(userGuess);


}

// Play function: It defines and test the rules of the game.
void play(int guess)
{

	char decision;

	
	//printf("Random Number:%d\n", randomNumber); Testing purposes only. It is used to see that the random number is changing if and only if the user wants to play again.
	
	if(guess == randomNumber)
	{

		printf("Excellent you guessed the number!\n");
		printf("Would you like to play again?(y/n)");
		scanf("\n%c", &decision);

		if(decision == 'y')
		{
			randomNumber = (1 + (rand() % 1000));
			start();

		}else
		{

			if(decision == 'n')
			{

				exit(0);

			}

		}
			

			
	}else if(guess < randomNumber)
	{

		printf("Too low. Try again\n");
		start();
		
	}else
	{

		if(guess > randomNumber)
		{

			printf("Too high. try again.\n");
			start();
			

		}


	}//end if


	

		

	

}
