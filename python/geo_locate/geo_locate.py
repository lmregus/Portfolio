############################
#                          #
#  Developer:              #
#           Luis Regus     #
#                          #
############################


from geopy.geocoders import GoogleV3
from geopy.geocoders import Nominatim
from geopy.distance import vincenty


# Populate this tuple with the desired locations
# Example 322 Islington St Suite 3, Portsmouth, NH 03801
address_list = ()

def get_nearest(user_location, maps_api_key=None):
    ''' This function returns the nearest address to the
        user location. It compares the user location with an
        existing list of addresses.

        Args:
            user_location (string): can be either the zip code or address.

        Returns:
            string: the nearest address to the user_location
    '''
    if maps_api_key:
        geolocator = GoogleV3(maps_api_key, timeout=10)
    else:
        geolocator = Nominatim(timeout=10)
    user_location = geolocator.geocode(user_location)
    user_latlon = (user_location.latitude, user_location.longitude)
    geo_locations = [geolocator.geocode(address) for address in address_list]
    distance_dict = {vincenty((address.latitude, address.longitude),
                              user_latlon).miles: address for address in geo_locations if address is not None}
    min_distance = min(distance_dict.items(), key=lambda k: k[0])
    return min_distance[1]
