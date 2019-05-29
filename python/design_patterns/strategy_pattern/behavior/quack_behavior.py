from abc import ABC
from abc import abstractmethod


class QuackBehavior(ABC):
    """Interface that defines a quack algorithm."""
    @abstractmethod
    def quack(self):
        return NotImplemented
