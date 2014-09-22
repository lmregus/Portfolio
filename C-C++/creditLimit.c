/*
================================================================================

    Name: Luis Regus
    ID: 00264958
    Created: 1/31/14

    Description: This program determines if a costumer has exceeded the credit limit on a charge account.

    usage: This program asks the user for the account number, beginning balance, total charges, and credit limit. If the credit limit of the account is exceeded then it will print some info of the account and it will let the user know that the credit limit was exceeded. 

    Sample
    ----------------------------------------------------------------------------
    Enter account number (-1 to end): 100
    Enter beginning balance: 5394.78
    Enter total charges: 1000.00
    Enter total credits: 500.00
    Enter credit limit: 5500.00
    Account:     100
    Credit Limit:     5500.00
    Balance:     5894.78
    Credit limit exceeded

    Enter account number (-1 to end): 200
    Enter beginning balance: 1000.00
    Enter total charges: 123.45
    Enter total credits: 321.00
    Enter credit limit: 1500.00

    Enter account number (-1 to end): 300
    Enter beginning balance: 500.00
    Enter total charges: 274.73
    Enter total credits: 100.00
    Enter credit limit: 800.00

    Enter account number (-1 to end): -1
    ----------------------------------------------------------------------------

================================================================================
*/

#include <stdio.h>

int main( void )
{

	int accountNumber;
	float initialBalance;
	float charges;
	float credits;
	float creditLimit;
	
	float newBalance = 0;

	printf("Enter account number (-1 to end): ");
	scanf("%d", &accountNumber);

	while(accountNumber != -1)
	{

		printf("Enter beginning balance: ");
		scanf("%f", &initialBalance);

		printf("Enter total charges: ");
		scanf("%f", &charges);

		printf("Enter total credits: ");
		scanf("%f", &credits);

		printf("Enter credit limit: ");
		scanf("%f", &creditLimit);

		newBalance = initialBalance + charges - credits;
		
		if(newBalance > creditLimit)
		{

		
		printf("Account:     %d\n", accountNumber);
		printf("Credit Limit:     %.2f\n", creditLimit);
		printf("Balance:     %.2f\n", newBalance);
		printf("Credit limit exceeded\n");
				

		}

		printf("\nEnter account number (-1 to end): ");
        	scanf("%d", &accountNumber);
		

	}

	


	return 0;

}
