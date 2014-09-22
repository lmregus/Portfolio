/*
================================================================================

    Name: Luis Regus
    ID: 00264958
    Created: 2/22/14

    Description: This program is an implementation of Conway's Game of Life. 
                 The sources I used were http://en.wikipedia.org/wiki/Conway's_Game_of_Life & 
		 http://www.math.com/students/wonders/life/life.html

    usage: Just compile and run the program. After that the user will choose to 
	   start the simulation or no. The initial configuration is chosen randomly.
    ----------------------------------------------------------------------------
================================================================================
*/





#include <stdio.h>
#include <unistd.h>
#include <time.h>
#include <stdlib.h>



const int X = 50;
const int Y = 100;

//Function Prototypes
void copyGrid(int grid[][Y], int grid2[][Y], int, int);
void alive(int array[][Y], int, int);
int compare(int array1[][Y], int array2[][Y], int, int);
void printGrid(int array[][Y], int cx, int cy);


int main (void)
{

	int grid[X][Y];
	int gridCopy[X][Y];
	int gridSafe[X][Y];	
	int randomNumber;
	char ans;

	
	char again;
	char cont;
 	int comparison;
	int width;
	int height;
	
	srand(time(NULL));

	printf("\nThis program is a C implementation of John Conway's Game of Life.\nWith it, you can simulate how cells interact with each other.\n\nThe rules(taken from Wikipedia) of the Game of Life are as follows:\n1.Any live cell with fewer than two live neighbors dies, as if caused by under-population.\n2.Any live cell with two or three live neighbors lives on to the next generation.\n3.Any live cell with more than three live neighbors dies, as if by overcrowding.\n4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.\nThe initial configuration,Generation 0, of the board is determined randomly.\nEvery hundred Generations you will get the option to end or continue the simulation.\nIf a system does not change from one generation to the next, the simulation will end automatically.\n");

	printf("\nDo you want to start the simulation?\n");
	scanf("%c", &ans);

    if(ans == 'y')
    {	  	
	do
	{

			
		
			system("clear");

			
			int i = 0;
		do
		{	
		

			for(width = 1; width < X-1; width++)
			{
				for (height = 1; height < Y-1; height++)
				{
					grid[width][height] = rand() % 2;

				}
			}
      
			//Prints the generation.  If i == 0, the grid array is copied to the gridCopy array 
      			
			printf("\nGeneration %d\n\n",  i);
     
			 //Initializes the arrays
			if(i == 0)
			{

				copyGrid(grid, gridCopy, X, Y);  
				
			
			}
			
			copyGrid(gridCopy, gridSafe, X, Y);
							
			printGrid(gridCopy, X,Y);
		  	alive(gridCopy, X,Y);
		  	i++;

		      //Pauses the system in order to give the screen time to refresh.
		      system("sleep .05"); //This statement is also used to see the number of generations at the top lef corner. The values might change in  different systems.

		      //Checks whether the generation is a multiple of Y to ask 
		      //the user if they want to continue the simulation. If they
      		      //wish to end, the program breaks out of the loop to ask if
      		      //the user wishes to run another simulation.
      		      if(i % Y == 1 && i != 1)
      		      {
	
				printf("\n");
			      
			        do
			        {
			
				          printf("Would you like to continue this simulation? (y/n): ");
				          scanf("%c", &cont);
			        }while(cont != 'y' && cont != 'n');
				
		
				 if(cont == 'n')
				 {

				          break;

				 }
     			}
      
				//Compares the current generation with a backup generation.
	        		//If they aren't the same the system
      				//clears the screen and repeats the process until they are
      				//the same or the user chooses to quit.
      				comparison = compare(gridCopy, gridSafe, X, Y);

	        		if(comparison == 0)
				{

		        		system("clear");

				}

	        		if(comparison == 1)
				{

		        		printf("\n");

				}
		}while(comparison == 0); 
    		
			
	    	do
	    	{
		
			      printf("Would you like to run another simulation? (y/n): ");
		              scanf("%c", &again);

		}while(again != 'y' && again != 'n');


	
	
	}while(again == 'y');
	
     }else
     {

	return 0;

     }
       
	return 0;
	
	
}



//Function to copy arrays
void copyGrid(int grid[][Y], int grid2[][Y], int cx, int cy)
{

	int counterx;
	int countery;
	

	for(counterx = 0; counterx < cx; counterx++)
	{

		for(countery = 0; countery < cy; countery++)
		{
 			
			 grid2[counterx][countery] = grid[counterx][countery];

		}
	}

}

//The alive function counts the number of cells surrounding the center cell, and 
//determines whether it lives, dies, or stays the same.
void alive(int array[][Y], int cx, int cy)
{
  	//Copies the main array to a temp array so changes can be entered into a grid
  	//without affecting the other cells and the calculations being performed on them.
	int temp[X][Y];
	int counterx, countery;	
	copyGrid(array, temp, cx, cy);

	for(counterx = 1; counterx < cx-1; counterx++)
 	{

 		for(countery = 1; countery < cy-1; countery++) 			
		{
	
 
			int count = 0;
			count = array[counterx-1][countery] + array[counterx-1][countery-1] + array[counterx][countery-1] + array[counterx+1][countery-1] + array[counterx+1][countery] + array[counterx+1][countery+1] + array[counterx][countery+1] +array[counterx-1][countery+1];

			//The cell dies.
		        if(count < 2 || count > 3)
			{

					temp[counterx][countery] = 0;

			}

			//The cell stays the same.
		        if(count == 2)
			{

					temp[counterx][countery] = array[counterx][countery];

			}

			//The cell either stays alive, or is "born".
		        if(count == 3)
			{

					temp[counterx][countery] = 1;
			}
		}

	}

	copyGrid(temp, array, cx, cy);

}

//The compare function checks to see if two arrays are exactly the same. 
//0 false, 1 true.
int compare(int array1[][Y], int array2[][Y], int cx, int cy)
{
	int count = 0;
	int counterx;
	int countery;

	for(counterx = 0; counterx < cx; counterx++)
	{

		for(countery = 0; countery < cy; countery++)
		{

			if(array1[counterx][countery] == array2[counterx][countery])
			{
				count++;	
			}

		}
	}

	//Since the count gets incremented every time the cells are exactly the same,
	//an easy way to check if the two arrays are equal is to compare the count to 
	//the dimensions of the array multiplied together.
	if(count == cx*cy)
	{

		return 1; //true
	
	}else
	{

		return 0;   //false

	}
}

//This function prints the sizex-1 and sizey-1 part of the array, since that's the only
//portion of the array that we're really interested in. A live cell is marked
//by a '*', and a dead or vacant cell by a ' '.
void printGrid(int array[][Y], int cx, int cy)
{

	int counterx, countery;

	for(counterx = 1; counterx < cx-1; counterx++)
 	{
 		for(countery = 1; countery < cy-1; countery++) 			
		{	
			if(array[counterx][countery] == 1)
			{

				printf("%c", '*');

			}else
			{

				printf("%c", ' ');

			}
		}

		printf("\n");
 	}
}

