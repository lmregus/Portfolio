from abc import ABC
from abc import abstractmethod


class QuackBehavior(ABC):

    @abstractmethod
    def quack(self):
        return NotImplemented
