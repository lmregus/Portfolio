from behavior.quack import Quack
from behavior.fly_with_wings import FlyWithWings
from mallard_duck import MallardDuck

fly_behavior = FlyWithWings()
quack_behavior = Quack()
mallard = MallardDuck(fly_behavior, quack_behavior)

mallard.display()
mallard.quack()
mallard.fly()
