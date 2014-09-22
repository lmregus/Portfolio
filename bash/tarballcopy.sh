#!/bin/bash

#Name: Luis Regus 
#Date: 11/12/2013

#This program creates a tarball backup of a given directory

echo "What's the name of the directory you want to tar?" #prints the message

read nameOfDirectory	#reads from the standard input device

echo "What's the name of the tar you want to create?" #prints the message
read nameOfTar   #reads from the standard input device


if [ ! -e "${nameOfTar}_backup$(date +_%m-%d-%Y)".tar ]  # ! not expression, if the name of the tar backup is not in the directory 
  
    then

         if [ ! -d "${nameOfTar}_backup$(date +_%m-%d-%Y)".tar ]
  
             then #if the condition is true do the following

                    tar -cvf ${nameOfTar}_backup$(date +_%m-%d-%Y).tar ${nameOfDirectory} #if the tarball backup name doesn't exist, creat a tarball backup
                    echo "Great the tarball backup was created!"  #prints the message
	 fi

   else #if the condition is false

	while [ -e "${nameOfTar}_backup$(date +_%m-%d-%Y)".tar ]
         
         do
		echo "Sorry the name already exist. Please choose another name!" #if the file exist, print the message

		echo "What's the name of the directory you want to tar?" #prints the message

		read nameOfDirectory	#reads from the standard input device

		 echo "What's the name of the tar you want to create?" #prints the message
		
        	 read nameOfTar   #reads from the standard input device
        done
	
	             	      
	
fi  #end of the if statement

ls -l    #list files
