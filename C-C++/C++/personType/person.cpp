//personType class implementation

#include "personType.h"
#include <iostream>
#include <string>


using namespace std;

personType::personType()
{
	firstName = "personName";
	lastName = "personLast";
	age = 0;
	gender = 'N';

}

void personType::setFirstName(string pfirstName)
{

	firstName = pfirstName;

}


void personType::setLastName(string plastName)
{

	lastName = plastName;

}

void personType::setAge(int page)
{

	age = page;

}



void personType::setGender(char pgender)
{

	gender = pgender;

}


void personType::setName(string pfirstName, string plastName)
{

	firstName = pfirstName;
	lastName = plastName;

}

void personType::printPersonData()
{

	cout << "Person Information: " << endl;
	cout << "First Name: " << firstName << endl;
	cout << "Last Name: " << lastName << endl;
	cout << "Age: " << age << endl;
	cout << "gender: " << gender << endl;
}



