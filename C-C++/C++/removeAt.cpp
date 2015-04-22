//=========================================================================================================================================
// Name        : removeAt.cpp
// author      : Luis Regus
// created     : 30/11/13
// revisions   : 
//
// description : This program is a function that removes an element from a int array.
//
// usage       : The function takes an array of ints and the length as parameters.
//____________________________________________________________________________________________________________________________


void removeAt(int *nums[], int numslength, int index)
{

	int location = 0;
	
	while(loc < numsLength)
	{

		if(nums[location] == index)
		{

			nums[location] = NULL;
			numslength--;

		}
		else
		{

			location++;

		}

	}

}
