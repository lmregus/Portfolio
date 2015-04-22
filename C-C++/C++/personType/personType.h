//personType.h the specification file for the class personType
 
#ifndef PERSONTYPE.H
#define PERSONTYPE.H
#include <iostream>
#include <string>
using namespace std;

class personType
{


           string firstName;
	   string lastName;
	   int age;
	   char gender;

	public:
	
 	  personType();
	  //Default constructor 
	  //Sets the default value for each member
	  void setFirstName(string pfirstName);
	  //Function to set the first name of the person
	  //The name is set according to the parameters
	  //Postcondition: firstName = pfirstName
	  //		   The function checks whether the value of 
	  //		   pfirstName is valid
	  
	  string getFirstName() { return firstName;};
	  //Function to return the first name
	  //Postcondition: firstName = pfirstName
	  
	  void setLastName(string plastName);
	  //Function to set the last name of the person
	  //The name is set according to the parameters
	  //Postcondition: lastName = plastName
	  //		   The function checks whether the value of 
	  //		   plastName is valid

	  string getLastName() { return lastName;};
	  //Function to return the first name
	  //Postcondition: firstName = pfirstName
	  
	  void setAge(int page);
	  //Function to set the age of the person
	  //The name is set according to the parameters
	  //Postcondition: age = page
	  //		   The function checks whether the value of 
	  //		   page is valid

	  int getAge() { return age; };
	  //Function to return the age
	  //Postcondition: age = page
	
	  void setGender(char pgender);
	  //Function to set the gender of the person
	  //The name is set according to the parameters
	  //Postcondition: gender = pgender
	  //		   The function checks whether the value of 
	  //		   gender is valid

	  char getGender(){ return gender; };
	  //Function to return the gender
	  //Postcondition: gender = pgender
	
	  void setName(string pfirstName ,string plastName);
	  //Function to set the last and first name of the person
	  //The names are set according to the parameters
	  //Postcondition: firstName = pfirstName; lastName = plastName
	  //		   The function checks whether the values are 
	  //		   valid 

	  void printPersonData();
	  //Function to display the data of the person	
	  //Postcondition: after the data is set, it displats it
	  //		   if no data is set, it prints the default 
	  //		   values

};

#endif
