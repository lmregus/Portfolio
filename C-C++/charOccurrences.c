/*
=======================================================================

   Name: Luis Regus
   ID: 00264958
   Created:4/4/2014

   Description: This program count the occurrences of a character in a 
   given string.


=======================================================================
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main( void )
{


	char str[80];
	char occurrence;
	int counter;
	int occurrenceNumber = 0;
	char *s;
	char c;

	printf("This program calculates the total occurrences of the character specified a string.(the string must not past 79 characters.)\n");

	printf("Please write the string.\n");
	scanf("%79s", str);

 	printf("Specify the character.\n");
	scanf(" %c", &occurrence);


	s = strchr(str,occurrence);

	while(s != NULL)
	{

		occurrenceNumber++;
		
		

		s = strchr(s+1,occurrence);
		
	}

	

	printf("%d\n", occurrenceNumber);

}
