#############################################
#                                           #
# Developer: Luis Regus                     #
# Date: 11/11/2015                          #
#                                           #
#############################################


def is_leap_year(year):
    """ Returns true or false

        This function gets a year and checks whether or
        not the year is leap

        Args:
            year (int): Year to be checked

        Returns:
            boolean: true or false
    """
    return year % 4 == 0 and not year % 100 == 0 \
            or year % 100 == 0 and year % 400 == 0
