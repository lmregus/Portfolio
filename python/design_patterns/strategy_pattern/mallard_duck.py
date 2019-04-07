from duck import Duck
from behavior.fly_with_wings import FlyWithWings
from behavior.quack import Quack


class MallardDuck(Duck):

    def __init__(self):
        self._fly_behavior = FlyWithWings()
        self._quack_behavior = Quack()

    def display(self):
        print('I am a mallard duck!')
