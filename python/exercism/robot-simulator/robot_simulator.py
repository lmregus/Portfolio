#########################
#                       #
# Developer: Luis Regus #
# Date: 11/24/15        #
#                       #
#########################

NORTH = "north"
EAST = "east"
SOUTH = "south"
WEST = "west"


class Robot:
    '''
        Custom object used to represent a robot
    '''

    def __init__(self, direction=NORTH, x_coord=0, y_coord=0):
        self.coordinates = (x_coord, y_coord)
        self.bearing = direction

    def turn_right(self):
        directions = {
                NORTH: EAST,
                EAST: SOUTH,
                SOUTH: WEST,
                WEST: NORTH}
        self.bearing = directions.get(self.bearing, NORTH)

    def turn_left(self):
        directions = {
                NORTH: WEST,
                EAST: NORTH,
                SOUTH: EAST,
                WEST: SOUTH}
        self.bearing = directions.get(self.bearing, NORTH)

    def advance(self):
        coords = {
                NORTH: (self.coordinates[0], self.coordinates[1] + 1),
                EAST: (self.coordinates[0] + 1, self.coordinates[1]),
                SOUTH: (self.coordinates[0], self.coordinates[1] - 1),
                WEST: (self.coordinates[0] - 1, self.coordinates[1])}
        self.coordinates = coords.get(self.bearing, self.coordinates)

    def simulate(self, movement):
        for m in movement:
            if m == 'R':
                self.turn_right()
            elif m == 'L':
                self.turn_left()
            elif m == 'A':
                self.advance()
