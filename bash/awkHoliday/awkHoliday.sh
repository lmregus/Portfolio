#!/bin/bash

#Name: Luis Regus
#Date: 21/11/13

#This program tells the user if today is a geeky holiday

FORMATTED_DATE=`date +"%d-%b"` #assign the current date to the variable %d -> day, %b -> 3 letters month
GEEKY_DATE=`cat GeekyHolidays.txt | awk -F: '{printf "%s\n", $2}' | grep $FORMATTED_DATE`   #Look for a match with the value of the FORMATTED_DATE variable


if [ "$GEEKY_DATE" ]  #if the date matches

  then 


	echo "Today is "`awk -F: '{if ( $2 ~ /'$(date +"%d-%b")'/) print $1 }' GeekyHolidays.txt` #print the first field of the line. -F-> determines the field delimite. ~ -> means if matches

  
   else #if the date does not match

	echo "Today it is not a geeky holiday" #print the message
fi


case "$(date +%A)" in # %A -> current day of the week
  Saturday)
  echo ":(! 6 days to go until it's friday"  #prints the message
  ;;
  Sunday)
  echo "5 days to go until it's friday"  #prints the message
  ;;
  Monday)
  echo "4 days to go until it's friday" #prints the message
  ;;
  Tuesday)
  echo "3 days to go until it's friday" #prints the message
  ;;
  Wednesday)
  echo "2 day to go until it's friday" #prints the message
  ;;
  Thursday)
  echo "Yay, 1 day to go until it's friday" #prints the message
  echo "\@/"	#prints the message
  echo " | "	#prints the message
  ;;
esac





