#########################
#                       #
# Developer: Luis Regus #
# Date: 12/11/2015      #
#                       #
#########################


def word_count(string):
    """ Returns the word count in a string

        This functions gets a string and counts the
        words in it

        Args:
            string (int): String to be processed

        Returns:
            dict: dictionary with word count
    """
    word_list = string.lower().split()
    word_list.sort()
    word_count = {x: 1 for x in (word_list)}

    for x in range(len(word_list) - 1):
        if word_list[x] == word_list[x+1]:
            word_count[word_list[x]] += 1
    return word_count
