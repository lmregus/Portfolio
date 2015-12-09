#########################
#                       #
# Developer: Luis Regus #
# Date: 11/18/2015      #
#                       #
#########################


def detect_anagrams(word, word_list):
    ''' This function finds the anagram of a word
        in a list of words

        Args:
            word (string): word to check against the
                anagrams
            word_list (list): list of possible anagrams

        Returns:
            list: an anagrams list
    '''
    anagrams = list()
    word_chars = sort_word(word)
    for a_word in word_list:
        a_word_chars = sort_word(a_word)
        if word_chars == a_word_chars and a_word.lower() != word.lower():
            anagrams.append(a_word)
    return anagrams


def sort_word(word):
    ''' This function sorts the words
        in a string

        Args:
            word (string): word to be proccessed

        Returns:
            list: a list of sorted characters
    '''
    chars = list(word.lower())
    chars.sort()
    return chars
