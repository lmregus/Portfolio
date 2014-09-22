/*
================================================================================

    Name: Luis Regus
    ID: 00264958
    Created: 1/31/14
    Description: This program determines the gross pay for each of the employees entered and calculates the overtime.

    usage: This programs asks the user user for the numbers of hours worked and the hourly rate.

    Sample
    ----------------------------------------------------------------------------
    Enter # of hours worked (-1 to end): 39
    Enter hourly rate of the worker ($00.00): 10.00
    Salary is 390.00

    Enter # of hours worked (-1 to end): 40
    Enter hourly rate of the worker ($00.00): 10.00
    Salary is 400.00

    Enter # of hours worked (-1 to end): 41
    Enter hourly rate of the worker ($00.00): 10.00
    Salary is 415.00

    Enter # of hours worked (-1 to end): -1
    ----------------------------------------------------------------------------

================================================================================
*/

#include <stdio.h>

int main( void )
{

	int hoursWorked;
	float hourlyRate;
	
	float salary = 0;
	float overTime = 0;

	printf("Enter # of hours worked (-1 to end): ");
	scanf("%d", &hoursWorked);	

	while(hoursWorked != -1)
	{

		if(hoursWorked > 40)
		{

			
			salary = hoursWorked * hourlyRate;

			overTime = (hourlyRate / 2) ;  //getting the over time

			salary += overTime;    

			

		}
		

		printf("Enter hourly rate of the worker ($00.00): ");
		scanf("%f", &hourlyRate);

		if(hoursWorked <= 40)
		{

			salary = hoursWorked * hourlyRate;

		}

		printf("Salary is %.2f\n", salary);

		
		printf("\nEnter # of hours worked (-1 to end): ");
		scanf("%d", &hoursWorked);	
		

	} 

	return 0;

}
