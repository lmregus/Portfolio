#!/bin/bash

#This program creates a file in the current directory with a unique name

echo "What's the name of the file you want create"? #prints the message
read nameOfFile   #reads from the standard inpud device

if [ ! -e "$nameOfFile" ]  # ! not expression, if the name of the file is not in the directory 

  then #if the condition is true do the following

     touch "$nameOfFile"  #if the file doesn't exist, creat it
     echo "Great your file was created!"  #prints the message

  else #if the condition is false

     echo "Sorry the file already exist!" #if the file exist, print the message

fi  #end of the if statement

ls -l    #list files
