############################
#                          #
#  Developer:              #
#           Luis Regus     #
#                          #
############################


# Populate this variable with the desired locations 
address_list = []

def geo_locate(user_location):
    ''' This function returns the nearest address to the
        user location. It compares the user location with an
        existing list of addresses.

        Args:
            user_location (string): can be either the zip code or address.

        Returns:
            string: the nearest address to the user_location
    '''
    geolocator = Nominatim()
    user_location = geolocator.geocode(user_location)
    user_latlon = (user_location.latitude, user_location.longitude)
    distance_dict = ''
    distance_dict = {vincenty((geolocator.geocode(address).latitude, geolocator.geocode(address).longitude),\
            user_latlon).miles:address for address in address_list if address is not None}
    min_distance = min(distance_dict.items(), key=lambda k: k[0])
    return min_distance[1]
