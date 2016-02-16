/*
 * Author: Luis Regus
 * Date: 9/23/2015
 * File name: invoice_client.cc
 * Class: Computing III
 *
 * Description: This program contains the test cases for the Invoice class member functions
 */
#include <iostream>
#include <string>

#include "Invoice.h"

using namespace std;

int main(){
    
    Invoice inv;
    string part_number;
    string part_description;
    int part_quantity;
    double part_price;

    //Test if default constructors set correct default values
    cout << "Void invoice" << endl;
    cout << "Part number:" << inv.getPartNumber() << endl;
    cout << "Part description:" << inv.getPartDescription() << endl;
    cout << "Part quantity:" << inv.getPartQuantity() << endl;
    cout << "Part price:" << inv.getPartPrice() << endl;
    
    //Test setters and getters
    cout << "\nEnter part number:" << endl;
    cin >> part_number;
    inv.setPartNumber(part_number);
    cin.ignore(255, '\n');                      //ignore until new line
    cout << "Part number:" << inv.getPartNumber() << endl;
    cout << "\nEnter part description:" << endl;
    getline(cin,part_description);
    inv.setPartDescription(part_description);
    cout << "Part description:" << inv.getPartDescription() << endl;
    cout << "\nEnter part quantity" << endl;
    cin >> part_quantity;
    inv.setPartQuantity(part_quantity);
    cout << "Part quantity:" << inv.getPartQuantity() << endl;
    cout << "\nEnter part price:" <<  endl;
    cin >> part_price;
    inv.setPartPrice(part_price);
    cout << "Part price:" << inv.getPartPrice() << endl;

    cout << "\nClient Invoice" << endl;
    cout << "Part number:" << inv.getPartNumber() << endl;
    cout << "Part description:" << inv.getPartDescription() << endl;
    cout << "Part quantity:" << inv.getPartQuantity() << endl;
    cout << "Part price:" << inv.getPartPrice() << endl;
    cout << "Invoice amount:" << inv.getInvoiceAmount() << endl;

    return 0;

}
