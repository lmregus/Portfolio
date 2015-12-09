#########################
#                       #
# Developer: Luis Regus #
# Date: 11/13/2015      #
# Updated: 11/16/2015   #
#                       #  
#########################


def to_rna(sequence):
    ''' Returns the transcribed RNA of a DNA strand

        This functions gets a DNA strand a converts it
        to its transcribed RNA

        Args:
            sequence (str) = DNA strand

        Returns:
            str: RNA strand
    '''
    nucleotides = {'G':'C', 'C':'G', 'T':'A', 'A':'U'}
    sequence = sequence.upper()
    rna_strand = ""
    for s in sequence:
        for dna_trans, rna_trans in nucleotides.items():
            if s == dna_trans:
                rna_strand += rna_trans
    return rna_strand
