##########################
#                        #
# Developer: Luis Regus  #
# Date: 11/13/2015       #
#                        #
##########################

from datetime import datetime
from datetime import timedelta


def add_gigasecond(date):
    ''' Returns 1Gs anniversary

        This function calculates 1Gs date

        Args:
            date (datetime): Date

        Returns:
            datetime: New date (1G added)
    '''
    if isinstance(date, datetime):
        return date + timedelta(seconds=10**9)
    return date
