from abc import ABC
from abc import abstractmethod
from behavior.fly_behavior import FlyBehavior
from behavior.quack_behavior import QuackBehavior


class Duck(ABC):

    def __init__(self):
        self._fly_behavior
        self._quack_behavior

    @abstractmethod
    def display(self):
        return NotImplemented()

    def fly(self):
        self._fly_behavior.fly()

    def quack(self):
        self._quack_behavior.quack()

    def swim(self):
        print('Swim')

    def set_fly_behavior(self, fly_behavior: FlyBehavior):
        self._fly_behavior = fly_behavior

    def set_quack_behavior(self, quack_behavior: QuackBehavior):
        self._quack_behavior = quack_behavior

    """
    __slots__ = (
        '_fly_behavior',
        '_quack_behavior'
    )
    """
