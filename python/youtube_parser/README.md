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
    
    test = url_parser.parse_url('https://youtu.be/dolT4pz_oCg?t=1h5m1s')
    
    To get the id:
        test['id']
        returns 'dolT4pz_oCg'
    To get the time:
        test['time']['nums'][0]+test['time']['h_m_s'][0] 
        retunrs 1h
    
    The order in the time dictionary will match the order of the time in the URL, 
    for exmaple, if the URL has q time query like t=1h5m1s, the hour in the time 
    dictionary will be in the 0 index and so on.

