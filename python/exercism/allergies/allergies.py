#########################
#                       #
# Developer: Luis Regus #
# Date: 11/23/15        #
#                       #
#########################


class Allergies:
    '''
        Custom object used to represent a list of allergies
    '''
    allergies = {'eggs': 1,
                    'peanuts': 2,
                    'shellfish': 4,
                    'strawberries': 8,
                    'tomatoes': 16,
                    'chocolate': 32,
                    'pollen': 64,
                    'cats': 128}

    def __init__(self, val):
        self.lst = list()
        for k, v in self.allergies.items():
            if v & val:
                self.lst.append(k)

    def is_allergic_to(self, k_allergy):
        return k_allergy in self.lst
