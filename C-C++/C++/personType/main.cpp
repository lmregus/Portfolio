#include <iostream>
#include "personType.h"

using namespace std;

int main()
{


	personType person;
//	personType person2 = new personType("Luis","Regus",23,'M');
	personType person3;

	person.setFirstName("Miguel");
	person.setLastName("Perez");
	person.setAge(40);
	person.setGender('M');

	person3.setName("Anthony", "Ramos");

	person.printPersonData();
	//person2.printPersonData();
	person3.printPersonData();

	return 0;
}

