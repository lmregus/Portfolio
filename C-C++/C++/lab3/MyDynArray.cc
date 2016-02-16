/*
 *  Author: Luis Regus 
 *  Date: 10/07/2015
 *  File Name: MyDynArray.cc
 *  Class: Computing III
 *
 *  Description: This program defines the MyDynArray class
 */

#include <iostream>


#include "MyDynArray.h"

using namespace std;

//Constructor definition
MyDynArray::MyDynArray(size_t size_){
    int size_cast = static_cast<int>(size_);            //size_t cast to int to test for negative values
    if (size_cast > 0){
        size = size_;
        array_ptr = new T[size_];
    }else{
        size = 0;
        array_ptr = new T[size];
    }
    cout << "Constructor called with: " << size_cast << endl;
}

size_t MyDynArray::getSize() const{
    return size;
}

//Set function definition
bool MyDynArray::set(T element, size_t index){
    bool r_bool = false;
    if( index > size){
        T *new_arr_ptr = new T[index];                  //Creates temporal array pointer
        for (int x = 0; x < size; x++){
            new_arr_ptr[x] = array_ptr[x];              //Copies what's in the array to the temporal array
        }
        
        array_ptr = new_arr_ptr;                        //Sets the array to the temporal array
        delete[] new_arr_ptr;                           //Deletes the temporal array
        array_ptr[index] = element;                     //Assign what's in the index position to the element
        
    }else{
        array_ptr[index] = element;
        r_bool = true;
    }
    cout << "Function set() called with element: " << element << " and index:" << index << endl;
    return r_bool;
}

T MyDynArray::get(size_t index) const{
    return array_ptr[index];
}

//Copy constructor definition
MyDynArray::MyDynArray(const MyDynArray& arg){
    size = arg.size;                                    //Shallow copy

    if (arg.array_ptr){                                 //Deep copy
        array_ptr = new T[size];
        for (int x = 0; x < size; x++){
            array_ptr[x] = arg.array_ptr[x];
        }
    }
    cout << "Copy constructor called" << endl;
}

//Assignment operator definition
MyDynArray& MyDynArray::operator=(const MyDynArray& rhs){
    if(this == &rhs){                                   //Self assignment checking
        return *this;
    }
    delete[] array_ptr;

    size = rhs.size;
    
    if (rhs.array_ptr){                                 //Deep copy
        array_ptr = new T[size];
        for (int x = 0; x < size; x++){
            array_ptr[x] = rhs.array_ptr[x];
        }
    }
    cout << "Assignment operator called" << endl;
    return *this;
}

//Destructor definition
MyDynArray::~MyDynArray(){
    cout << "Destructor called" << endl;
    delete[] array_ptr;
}
