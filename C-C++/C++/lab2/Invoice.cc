/*
 * Author: Luis Regus
 * Date: 9/23/2015
 * File name: Invoice.cc
 * Class: Computing III
 *
 * Description: This program contains the Invoice class definition
 *
 */

#include <iostream>
#include <string>

#include "Invoice.h"

using namespace std;

Invoice::Invoice(){
    part_number = "0";
    part_description = "N/A";
    part_quantity = 0;
    part_price = 0.0f;
}

void Invoice::setPartNumber(string p_number){
    part_number = p_number;
}

string Invoice::getPartNumber(){
    return part_number;
}

void Invoice::setPartDescription(string p_description){
    part_description = p_description;
}

string Invoice::getPartDescription(){
    return part_description;
}

void Invoice::setPartQuantity(int p_quantity){
    if (p_quantity >= 0){
        part_quantity = p_quantity;   
    }else{
        part_quantity = 0;
    }
}

int Invoice::getPartQuantity(){
    return part_quantity;
}

void Invoice::setPartPrice(double p_price){
    if (p_price >= 0){
        part_price = p_price;
    }else{
        part_price = 0.0f;
    }
}

double Invoice::getPartPrice(){
    return part_price;
}

double Invoice::getInvoiceAmount(){
    if( part_price >=0 && part_quantity >= 0){
        return (part_price * part_quantity);
    }else{
        return 0;
    }
}
