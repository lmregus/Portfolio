from behavior.quack_behavior import QuackBehavior


class Quack(QuackBehavior):
    """Concrete implementation of the QuackBehavior algorithm."""

    def quack(self):
        print('Quack quack quack!!!')
