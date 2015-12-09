#########################
#                       #
# Developer: Luis Regus #
# Date: 11/23/15        #
#                       #
#########################
import itertools


def slices(num, n_slice):
    ''' Returns all possible consecutive numbers series
        of length n_slice in the num string

        Args:
            num (string): String to be check
            n_slice (int): Series length

        Returns:
            list: A list of n_slice(length) series
    '''
    end = itertools.count(n_slice)
    if n_slice < 1 or n_slice > len(num):
        raise ValueError("{} not a valid slice length".format(n_slice))
    series_list = [num[start:next(end)] for start in range(len(num) - (n_slice - 1))]
    return [map(int, seq) for seq in series_list]
