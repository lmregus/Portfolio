/*
 * Author: Luis Regus
 * Date: 9/23/21015
 * File name: book_client.cc
 * Class: Computing III
 *
 * Description: This is the Account class definition
 *
 */
#include <iostream>

#include "Account.h"

using namespace std; 

Account::Account(){
    balance = 0.0f;
}

Account::Account(int initial_balance){
    if (initial_balance >= 0){
        balance = initial_balance;
    }else{
        balance = 0.0f;
        cout << "Initial balance is invalid." << endl;
    }
}

void Account::credit(int credit_amount){
    if (credit_amount >= 0){
        balance += credit_amount;
    }else{
        cout << "Credit amount is invalid." << endl;
    }
}

void Account::debit(int debit_amount){
    if (debit_amount >= 0 && debit_amount <= balance){
        balance -= debit_amount;
    }else{
        cout << "Debit amount exceeded account balance." << endl;
    } 
}

double Account::getBalance(){
    return balance;
}

double Account::AddAccountBalance(Account& acc){
   return balance + acc.getBalance();
}
