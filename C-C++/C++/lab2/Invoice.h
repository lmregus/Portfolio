/*
 * Author: Luis Regus
 * Date: 8/23/2015
 * File name: Invoice.h
 * Class: Computing III
 *
 * Description : This program contains the Invoice class declaration
 *
 */

#ifndef INVOICE_H
#define INVOICE_H 1

#include <iostream>
#include <string>

using std::string;

class Invoice{
    
    private:
        string part_number;
        string part_description;
        int part_quantity;
        double part_price;
    public:
        Invoice();
        void setPartNumber(string p_number);
        string getPartNumber();
        void setPartDescription(string p_description);
        string getPartDescription();
        void setPartQuantity(int p_quantity);
        int getPartQuantity();
        void setPartPrice(double p_price);
        double getPartPrice();
        double getInvoiceAmount();

};

#endif
