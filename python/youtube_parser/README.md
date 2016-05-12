# Developer 
   * **Luis Regus**

# Description 
   * **This program parses a Youtube URL and gets its time and ID**

# Test Cases
    1.  url_parser.parse_url('https://www.youtube.com/embed/dolT4pz_oCg')
        returns {'id': 'dolT4pz_oCg', 'time': ''}

    2.  url_parser.parse_url('https://www.youtube.com/watch?v=dolT4pz_oCg')
        returns {'id': 'dolT4pz_oCg', 'time': ''}

    3.  url_parser.parse_url('https://youtu.be/dolT4pz_oCg?t=1h23s')
        returns {'id': 'dolT4pz_oCg', 'time': {'h_m_s': ['h', 's'], 'nums': ['1', '23']}} 
    
    4.  url_parser.parse_url('https://youtu.be/dolT4pz_oCg?t=1h23m')
        {'id': 'dolT4pz_oCg', 'time': {'h_m_s': ['h', 'm'], 'nums': ['1', '23']}}

    5.  url_parser.parse_url('https://youtu.be/dolT4pz_oCg?t=1h23m12s')
        {'id': 'dolT4pz_oCg', 'time': {'h_m_s': ['h', 'm', 's'], 'nums': ['1', '23', '12']}}

    6.  url_parser.parse_url('https://youtu.be/dolT4pz_oCg?t=1s')
        {'id': 'dolT4pz_oCg', 'time': {'h_m_s': ['s'], 'nums': ['1']}}

# Example
```python
from url_parser import parse_url
test = parse_url('https://youtu.be/dolT4pz_oCg?t=1h5m1s')

test
{'id': 'dolT4pz_oCg', 'time': '1h5m1s'}

```
