from duck import Duck


class MallardDuck(Duck):
    """Concrete implementation of a MallardDuck."""

    def __init__(self, fly_behavior, quack_behavior):
        super().__init__(fly_behavior, quack_behavior)

    def display(self):
        print('I am a mallard duck!')

    __slots__ = (
        '_fly_behavior',
        '_quack_behavior',
    )
