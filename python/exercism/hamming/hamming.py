#########################
#                       #
# Developer: Luis Regus #
# Date: 11/13/2015      #
#                       #
#########################


def distance(strand_a, strand_b):
    ''' Returns the hamming distance of two DNA strands

        This function calculates the hamming distance
        between two DNA strands

        Args:
            strand_a (string): DNA strand
            strnad_b (string): DNA strand

        Returns:
            int: hamming distance
    '''
    hamming_distance = 0
    if len(strand_a) == len(strand_b):
        for char_a, char_b in zip(strand_a, strand_b):
            if char_a != char_b:
                hamming_distance += 1
    return hamming_distance
