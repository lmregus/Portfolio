#########################
#                       #
# Developer: Luis Regus #
#                       #
#########################


def end_other(a, b):
    a = a.lower()
    b = b.lower()
    return a[-(len(b)):] == b or a == b[-(len(a)):] 
