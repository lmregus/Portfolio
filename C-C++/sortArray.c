/*
----------------------------------------------------------------------------------------------

   Name: Luis Regus
   ID: 00264058
   Date: 2/28/14

   Description: This program uses the buble sort algorithm to sort an array. The bubble sort 
	        has been improved, in order to increase its efficiency. Improvement 1: decrease 
		decrease in comparisons made by the bubble sort. Improvement 2: Determines if 
		swaps has been made or not.

  

-----------------------------------------------------------------------------------------------*/





#include <stdio.h>
#define SIZE 10
/* function main begins program execution */
int main( void )
{
	/* initialize a */
	int a[ SIZE ] = { 2, 6, 4, 8, 10, 12, 89, 68, 45, 37 };
	int pass; /* passes counter */
	int i; /* comparisons counter */
	int hold; /* temporary location used to swap array elements */
	int swapped; //works like a boolean. a 0 means false a 1 means true

	printf( "Data items in original order\n" );

	/* output original array */
	for ( i = 0; i < SIZE; i++ ) 
	{
	
		printf( "%4d", a[ i ] );
	
	} 
	
	/* bubble sort */
	/* loop to control number of passes */

	
	for ( pass = 0; pass < SIZE; pass++ ) 
	{
		/* loop to control number of comparisons per pass */

		swapped = 0;  

		for ( i = 0; i < ((SIZE - pass) - 1); i++ ) 
		{
	
			/* compare adjacent elements and swap them if first
			element is greater than second element */
			if ( a[ i ] > a[ i + 1 ] ) 
			{
			
				hold = a[ i ];
				a[ i ] = a[ i + 1 ];
				a[ i + 1 ] = hold;
				swapped = 1;					
			}

		} /* end inner for */

		if(!swapped)
		{

			break;

		}

	} /* end outer for */

		

	printf( "\nData items in ascending order\n" );

	

	for ( i = 0; i < SIZE; i++ ) 
	{

		printf( "%4d", a[ i ] );

	} 

	printf( "\n" );

	return 0; 
