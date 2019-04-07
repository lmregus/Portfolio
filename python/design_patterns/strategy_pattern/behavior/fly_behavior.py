from abc import ABC
from abc import abstractmethod


class FlyBehavior(ABC):

    @abstractmethod
    def fly(self):
        return NotImplemented
