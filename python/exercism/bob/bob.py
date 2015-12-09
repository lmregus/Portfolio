#########################
#                       #
# Developer: Luis Regus #
# Date: 11/13/2015      #
#                       #
#########################


def hey(what):
    what = what.strip()
    answer = "Whatever."
    if what.rfind('!') > 0 and what.isupper() \
            or what.rfind('?') and what.isupper():
        answer = 'Whoa, chill out!'
    elif what.endswith('?'):
        answer = 'Sure.'
    elif what == "":
        answer = 'Fine. Be that way!'
    return answer
