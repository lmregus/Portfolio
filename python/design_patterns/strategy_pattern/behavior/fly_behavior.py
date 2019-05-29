from abc import ABC
from abc import abstractmethod


class FlyBehavior(ABC):
    """Interface that defines the fly algorithm."""

    @abstractmethod
    def fly(self):
        return NotImplemented
