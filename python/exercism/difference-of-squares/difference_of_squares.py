#############################
#                           #
# Developer: Luis Regus     #
# Date: 11/16/2015          #
#                           #
#############################


def square_of_sum(n):
    ''' Calculates the square of the sum of the
        first n natural numbers

        Args:
            n (int): Natural number to calculate

        Returns:
            int: Square of the sum
    '''
    sq_sum = 0
    for x in range(1, n + 1):
        sq_sum += x
    return sq_sum**2


def sum_of_squares(n):
    ''' Calculates the sum of the squares of the
        first n natural numbers

        Args:
            n (int): Natural number to calculate

        Returns:
            int: Sum of the squares
    '''
    sum_sq = 0
    for x in range(1, n + 1):
        sum_sq += x**2
    return sum_sq


def difference(n):
    ''' Calculates the difference of the sum of the squares
        and square of the sum of the first n natural numbers

        Args:
            n (int): Natural number to calculate

        Returns:
            int: Difference between the square of the sum and
                the sum of the squares
    '''
    return square_of_sum(n) - sum_of_squares(n)
