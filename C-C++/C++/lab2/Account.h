/*
 * Name: Luis Regus
 * Date: 8/23/2015
 * File name: book_client.cc
 * Class: Computing III
 *
 * Description: This is the Account class declaration
 *
 */

#ifndef ACCOUNT_H
#define ACCOUNT_H 1

class Account{

    private:
        double balance;
    public:
        Account();
        Account(int initial_balance);
        void credit(int credit_amount);
        void debit(int debit_amount);
        double getBalance();
        double AddAccountBalance(Account& acc2);

};

#endif
