/*
================================================================================

    Name: Luis Regus
    ID: 00264958
    Created: 5/4/14

    Description: This program writes and reads user accounts to a file. The program takes the information of the user 
		 converts it to binary and display the binary information to the standard output. Then what's written to 
		 the file is unreadable information, so nobody can have access to the personal information of the users.
		 The account number, user and password must be entered in the previous order. Another file is created with 
		 formatted, readable data. The program reads the data in both files and print it to the standard output. 

    usage: 	 Just compile and run the program. In UNIX like environment use 
		 gcc filename.c -o nameyouchoose.


    Note: 	 EOF in linux is ctrl-d. Window ctrl-z. Mac ctrl-d. 


     sample:
 
		Enter the account, user, and password.
		Enter EOF to end input.
		? 1 luis regus786
		00000000 00000000 00000000 00000001 
		00000000 00000000 00000000 01101100 
		00000000 00000000 00000000 01110101 
		00000000 00000000 00000000 01101001 
		00000000 00000000 00000000 01110011 
		00000000 00000000 00000000 01110010 
		00000000 00000000 00000000 01100101 
		00000000 00000000 00000000 01100111 
		00000000 00000000 00000000 01110101 
		00000000 00000000 00000000 01110011 
		00000000 00000000 00000000 00110111 
		00000000 00000000 00000000 00111000 
		00000000 00000000 00000000 00110110 
		? PLEASE TYPE IN THE SAME INFO AGAIN.
		Enter the account, user, and password.
		Enter EOF to end input.
		? 1 luis regus786
		? This is the data written to the file.
		The file users.dat can be found in the directory where the program was compiled.
		Unreadable File Data:
		1108117105115114101103117115555654
		Readable File Data:
		Account   user         password
		1         luis         regus786

		

    ----------------------------------------------------------------------------
================================================================================
*/

#include <stdio.h>
#include <string.h>

void writeTofile(FILE *file);
void readFile(FILE *file);
unsigned convertTobinary(unsigned);

#define SIZE 30

int main( void )
{

	FILE *cfPtr; /* cfPtr = clients.dat file pointer */

	writeTofile(cfPtr);

	printf("This is the data written to the file.\n");
	printf("The file users.dat can be found in the directory where the program was compiled.\n");


	readFile(cfPtr);	

	
	return 0; 

} 

//This function writes to a file. It creates the file if this one doesn't exist.
void writeTofile(FILE *file)
{


	int account; 
	char user[SIZE]; 
	char password[SIZE]; 
	
	int counter;
	
	// fopen opens file. Exit program if unable to create file
	// creates the non-readable file
	if ( ( file = fopen( "users.dat", "w" ) ) == NULL ) {

			printf( "File could not be opened\n" );

	} 
	else {

		printf( "Enter the account, user, and password.\n" );
		printf( "Enter EOF(ctrl-d) to end input.\n" );
		printf( "? " );
		scanf( "%d%s%s", &account, user, password );

		

		/* write account, user and password into file with fprintf */
		while ( !feof( stdin ) ) {
			
			fprintf( file, "%u", convertTobinary(account) );

			for(counter = 0; counter < strlen(user); counter++)
			{

				fprintf(file, "%u ", convertTobinary(user[counter]));

			}

			for(counter = 0; counter < strlen(password); counter++)
			{

				fprintf(file, "%u ", convertTobinary(password[counter]));

			}


			
			printf( "? " );
			scanf( "%d%s%s", &account, user, password );

		} 

		fclose( file ); /* fclose closes file */

	//Creates the readable file

	printf("PLEASE TYPE IN THE SAME INFO AGAIN.\n");
	if ( ( file = fopen( "usersr.txt", "w" ) ) == NULL ) 
	{

			printf( "File could not be opened\n" );

	} /* end if */
	else {

		printf( "Enter the account, user, and password.\n" );
		printf( "Enter EOF to end input.\n" );
		printf( "? " );
		scanf( "%d%s%s", &account, user, password );

		

		/* write account, name and password into file with fprintf */
		while ( !feof( stdin ) ) 
		{

			fprintf( file, "%d %s %s\n", account, user, password );
			printf( "? " );
			scanf( "%d%s%s", &account, user, password );

		} /* end while */

		fclose( file ); /* fclose closes file */

		
	} 

    }

}

//This function reads from an existing file
void readFile(FILE *file)
{

	int account;
	char user[SIZE];
	char password[SIZE];
	

	
	/* fopen opens file; exits program if file cannot be opened */
	// reads and prints the info in the unreadeable file

	printf("Unreadable File Data:\n");
	if ( (file = fopen( "users.dat", "r" ) ) == NULL ) 
	{

		printf( "File could not be opened\n" );

	} 
	else 
	{ /* read account, name and password from file */

		
		fscanf( file, "%d%s%s", &account, user, password );

		/* while not end of file */
		while ( !feof( file ) ) 
		{

			printf( "%d%s%s", account, user, password );
			fscanf( file, "%d%s%s", &account, user, password );

		} 

		printf("\n");
		fclose( file ); 
	} 


	//Reads and prints readable file.
	printf("Readable File Data:\n");
	if ( (file = fopen( "usersr.txt", "r" ) ) == NULL ) 
	{

		printf( "File could not be opened\n" );

	} 
	else 
	{ 

		printf( "%-10s%-13s%s\n", "Account", "user", "password" );
		fscanf( file, "%d%s%s", &account, user, password );

		
		while ( !feof( file ) ) 
		{

			printf( "%-10d%-13s%s\n", account, user, password );
			fscanf( file, "%d%s%s", &account, user, password );

		}

		fclose( file );

	} 

	
	

}


//This function converts and displays the data of the user to binary.
unsigned convertTobinary( unsigned value )
{

	unsigned c; /* counter */

	/* define displayMask and left shift 31 bits */
	unsigned displayMask = 1 << 31;

	unsigned returnValue;

	returnValue = value;
	
	/* loop through bits */
	for ( c = 1; c <= 32; c++ ) 
	{

		putchar( value & displayMask ? '1' : '0' );
		value <<= 1; /* shift value left by 1 */
		
		if ( c % 8 == 0 ) 
		{ /* output space after 8 bits */

			putchar( ' ' );

		} 
	
	}

	putchar( '\n' );

	return returnValue;

} 
