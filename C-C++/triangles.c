/*

   Name: Luis Regus
   ID: 00264958
   Created: 2/11/14

   Description: This program prints two triangles.

   Usage: This program uses a for loop to print two different triangles	


   Sample
   -----------------------------------------------------------------------------
   *
   **
   ***
   ****
   *****
   ******
   *******
   ********
   *********
   **********

   **********
   *********
   ********
   *******
   ******
   *****
   ****
   ***
   **
   *




   -----------------------------------------------------------------------------
*/

#include <stdio.h>

int main( void )
{

	int cCounter = 0;  //Columns counter
	int rCounter = 0;  //Rows counter
	

	for(cCounter = 1; cCounter <= 10; cCounter++)
	{


		for(rCounter = 1; rCounter <= cCounter; rCounter++)
		{

			printf("*");


		}

		printf("\n");
	}

	printf("\n");

    for(cCounter = 10; cCounter >= 1; cCounter--)
        {


                for(rCounter = 1; rCounter <= cCounter; rCounter++)
                {

                        printf("*");


                }

                printf("\n");
        }

	printf("\n");

	

}
