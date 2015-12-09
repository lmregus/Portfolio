import string


def is_pangram(sentence):
    ''' This function determines if a sentence is a pangram

        Args:
            word (string): sentence to test
        Returns:
            bool: True is the sentence is pangram
                False otherwise
    '''
    pangram = list()
    alphabet = string.ascii_lowercase
    for w in sentence:
        if w.lower() in alphabet and w.lower() not in pangram:
            pangram.append(w)
    return len(pangram) >= len(alphabet)
