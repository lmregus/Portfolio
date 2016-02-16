/*
 * Author: Luis Regus
 * Date: 9/23/2015
 * File name: account_client.cc
 * Class: Computing III
 *
 * Description: This program runs the tests for the Account class  member functions
 *
 */
#include <iostream>

#include "Account.h"

using namespace std;

int main(){
    
    Account acc1;
    Account acc2(100);

    int acc1_amount;
    int acc2_amount;

    cout << "What is the amount you would like to withdraw today?\nPress enter after entering the amount." << endl;
    cout << "Account 1 withdrawal amount" << endl;
    cin >> acc1_amount;
    acc1.debit(acc1_amount);
    cout << "Account 1 new balance is" << endl << acc1.getBalance() << endl;

    cout << "Account 2 withdrawal amount" << endl;
    cin >> acc2_amount;
    acc2.debit(acc2_amount);
    cout << "Account 2 new balance is" << endl << acc2.getBalance() << endl;

    cout << "\nWhat is the amount you would like to deposit today?\nPress enter after entering the amount." << endl;
    cout << "Account 1 deposit amount" << endl;
    cin >> acc1_amount;
    acc1.credit(acc1_amount);
    cout << "Account 1 new balance is" << endl << acc1.getBalance() << endl;

    cout << "Account 2 deposit amount" << endl;
    cin >> acc2_amount;
    acc2.credit(acc2_amount);
    cout << "Account 2 new balance is" << endl << acc2.getBalance() << endl;

    cout << "\nAccount 1 total amount: " << acc1.getBalance() << endl;
    cout << "Account 2 total amount: " << acc2.getBalance() << endl;

    cout << "\nTotal sum of the two accounts: " << acc1.AddAccountBalance(acc2) << endl;

    return 0;
    
}
