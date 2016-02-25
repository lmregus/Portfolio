#!/bin/bash
#########################################################
#   Developer: Luis Regus                               #
#   ID: 01314711                                        #
#   Date: 02/24/16                                      #
#                                                       #
#   Description: This script sends a disk space         #
#                warning to the user specified          #
#                in the command line, if it's           #
#                over the spcified level.               #
#                                                       #
#   Example: ./script_name.sh user_name@host_name       #
#                                                       #
#########################################################

user_email=$1
WARNING_LEVEL=60
CRITICAL_LEVEL=90

if [[ $1 == *"@"* ]]
then
    df -T | grep -E '^Type|ext4|ext3|ext4|nfs|ufs' | awk '{ print $6 " " $1 }' | while read output;
    do
        filesystem_space=$(echo $output | awk '{ print $1}' | cut -d'%' -f1  )
        filesystem=$(echo $output | awk '{ print $2 }' )
        if [[ $filesystem_space -ge $WARNING_LEVEL ]]
            then
                mail -s "Warning: File system $filesystem here is at $filesystem_space%" $user_email
        elif [[ $filesystem_space -ge $CRITICAL_LEVEL ]]
            then
                mail -s "Critical Warning: File system $partition here is at $filesystem_space%" $user_email
        fi
    done
    echo "Email has been sent to $user_email"
else
    echo -e "Error!\nRun: script_name.sh userna_name@host_name"
fi
echo $user
