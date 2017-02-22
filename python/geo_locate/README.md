# Developer
   * **Luis Regus**

# Description
   * **This function returns the nearest address of a given address.**
   * **Address could be either a zip code or a complete address.**
   * **Use the parameter maps_api_key with your key if using google maps geolocation service.**
   * **[GeoPy!](https://geopy.readthedocs.org/en/1.10.0/#) needs to be installed.** 

# Example
```python
from geo_locate import get_nearest

closest_address = get_nearest(address)
```
