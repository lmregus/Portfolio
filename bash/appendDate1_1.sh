#!/bin/bash

# Written by: Luis Regus
# Version: 1.1

#This is an update version of the appendDate script. It does not change
#the name of the script in the directory

for file in `find . -maxdepth 1 -type f`  #searches for files in a directory

do					  #start of the loop

      if [ $file != $0 ]         	  #if the file is not the script itself

	then				  #if the 'if condition is true' do the following 
      	   mv $file $file$(date +_%a-%b-%d---%R:%S---%Y) #appends the timestamp to the file

      fi				  #end of the if statement 

done					  #end of the for loop						

ls -l                      		  #list the files in the directory




