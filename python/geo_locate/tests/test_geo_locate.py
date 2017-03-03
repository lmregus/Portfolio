from geo_locate import get_nearest
import pytest

# adds the geolocate package to sys.path
#package_path = os.path.abspath(os.path.join(os.getcwd(), os.pardir))
#sys.path.insert(0, package_path)

addresses = ('129 high st Lawrence MA, 01841', '909 Islington St, Portsmouth, NH 03801')

class TestGeoLocate:
    def test_empty_list(self):
        with pytest.raises(TypeError):
            get_nearest('01841', [])

    def test_list(self):
        with pytest.raises(TypeError):
            get_nearest('01841', ['address 1', 'address 2'])

    def test_empty_dictionary(self):
        with pytest.raises(TypeError):
            get_nearest('01841', {})

    def test_dictionary(self):
        with pytest.raises(TypeError):
            get_nearest('01841', {'1': 'uno', '2': 'dos'})

    def test_get_nearest_lawrence(self):
        assert get_nearest('01841', addresses) == '129, High Street, Lawrence, Essex County, Massachusetts, 01841, United States of America'

    def test_get_nearest_portsmouth(self):
        assert get_nearest('03842', addresses) == 'WSCA-FM LP, 909, Islington Street, Portsmouth Plains, Portsmouth, Rockingham County, New Hampshire, 03801, United States of America'

    def test_get_nearest_lawrence_google_api(self):
        assert get_nearest('01841', addresses, maps_api_key='AIzaSyCQWFqkc0ldZf6XykpTX8WY73I7hcFT948') == '129 High St, Lawrence, MA 01841, USA'

    def test_get_nearest_portsmouth_google_api(self):
        assert get_nearest('03842', addresses, maps_api_key='AIzaSyCQWFqkc0ldZf6XykpTX8WY73I7hcFT948') == '909 Islington St, Portsmouth, NH 03801, USA'

    def test_get_nearest_tuple(self):
        with pytest.raises(Exception):
            get_nearest('01841', ('address',))
