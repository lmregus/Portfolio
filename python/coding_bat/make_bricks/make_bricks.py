#########################
#                       #
# Developer: Luis Regus #
#                       #
#########################


def make_bricks(small, big, goal):
        return goal <= (small +big *5) and goal % 5 <= small
