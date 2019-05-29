from behavior.fly_behavior import FlyBehavior


class FlyWithWings(FlyBehavior):
    """Concrete implementation of the FlyBehavior algorithm."""

    def fly(self):
        print('Fly with wings!')
