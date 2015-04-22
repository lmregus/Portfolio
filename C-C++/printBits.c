/*
=======================================================================

   Name: Luis Regus
   ID: 00264958
   Created:4/10/2014

   Description: This program calculates (number * 2^pow) using the left shift operator
   and prints the result and its equivalent in bits.


=======================================================================
*/

#include <stdio.h>

unsigned power2(unsigned number, unsigned pow);
void displayBits( unsigned value );

int main ( void )
{

	unsigned number;
	unsigned pow;

	printf("This program calculates (number * 2^pow) using the left shift operator\nand prints the result and its equivalent in bits.\n");
	printf("please enter the number: ");
	scanf("%u", &number);
	printf("please enter the power: ");
	scanf("%u", &pow);

	unsigned result = power2(number,pow);

	printf(" integer             bits\n");
	displayBits(result);
	return 0;

}



unsigned power2(unsigned number, unsigned pow)
{

	unsigned x = 1;
	int counter;
	unsigned result;
	unsigned power = 1;



	//printf("This is the x: %u\n", x); testing purposes. use void as the return value
	for(counter = 0; counter < pow; counter++)
	{

		x <<= 1; //the same as multiply by 2
		power *= x;

	}

	//printf("This is x after the for: %u\n", x); Testing purposes. use void as the return value

	result = number * x;
	
	return result;
	//printf("This is the result: %u\n", result); testing purposes. use void as the return value
	


}

void displayBits( unsigned value )
{
	unsigned c; /* counter */

	/* define displayMask and left shift 31 bits */
	unsigned displayMask = 1 << 31;

	printf( "%5i = ", value );

	/* loop through bits */
	for ( c = 1; c <= 32; c++ ) 
	{
	
		putchar( value & displayMask ? '1' : '0' );
		value <<= 1; /* shift value left by 1 */
		if ( c % 8 == 0 ) 
		  { /* output space after 8 bits */

			putchar( ' ' );
		
		  } /* end if */

	} 

	putchar( '\n' );

} 


