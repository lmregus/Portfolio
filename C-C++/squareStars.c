/*
================================================================================

    Name: Luis Regus
    ID: 00264958
    Created: 1/1/14

    Description: This program prints a square of stars.
    
    Usage:  The program asks for the size of the square and the prints it using star symbols.

    Sample
    ----------------------------------------------------------------------------
   What is the size of the square: 4
   ****
   ****
   ****
   ****
-----------------------------------------------------------------------------	
================================================================================
*/

#include <stdio.h>

int main( void )
{

	int squareSize;

	int rows = 0;
	int columns = 0;

	printf("What is the size of the square: ");
	scanf("%d", &squareSize);

	while(rows < squareSize)
	{

		
		while(columns < squareSize)
		{



			printf("*");
			

			columns++;


			
		}

		rows++;
		printf("\n");
		columns = 0;
		
	}
	
	return 0;

}
