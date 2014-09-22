/*
----------------------------------------------------------------------------------------------

   Name: Luis Regus
   ID: 00264058
   Date: 3/1/14

   Description: This program simulates an airline reservation system with ten availabe seats.

   Usage: After 5 seats in the first class section and 5 seats in the economy section are full, 
	  the program prints a message letting the user know that the respective section is 		  full. The user must press -1 to quit the program.
  

-----------------------------------------------------------------------------------------------*/




#include <stdio.h>

const int SEAT = 9; 

int main( void )
{
	
	int seats[SEAT];
	int choice;	
	int seatNumber = 0;	
	int counter;
	int economy = (SEAT/2) + 1;  //Makes the seat starts at 5

	while(choice != -1)
	{

		printf("Enter a -1 to quit.\n");
		printf("---------------------------------\n");
		printf("Please type 1 for \"first class\"\n");
		printf("Please type 2 for \"economy\"\n");

		scanf("%d", &choice);

		if (choice == 1)
		{

		
			if(seatNumber < 5)
			{
			
				seats[seatNumber] = 1;		
				seatNumber++;
			

			}else 
			{

				printf("No more space in first class\n");
			
			}


			printf("|-------------------------|\n");
			printf("|Boarding Pass            |\n");
			printf("|First class. Seat # is %d |\n", seatNumber);
			printf("|-------------------------|\n");		

		}else
		{

			if(choice == 2)
			{

				
				
				
				if((economy >= 5) && ( economy < 10))
				{

					seats[economy] = 1;
					economy++;
									
				}else 
				{

					printf("No more space in economy class\n");
			
				}


				printf("|---------------------------|\n");
				printf("|Boarding Pass              |\n");
				printf("|Economy class. Seat # is %d|\n", economy);
				printf("|---------------------------|\n");		
				
			}


		}
     	}
}
