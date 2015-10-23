import re, urlparse

def get_time(query_t):
        """Returns a dictionary with the time, hours, minutes, seconds.

            This function gets a query that contains a string like(1h30m, 1h, 1m20s or 1h2m23s)
            extactly. It breaks it apart to put in a time dict for the get_url_time function.

            Args:
                query_t (string): Query string to be processed.

            Returns:
                string: An empty string if no digits were found, a number string
                with the found numbers otherwise.
        """
        num = ''
        counter = 0
        time_dict = {                                                 #This dictionary holds
                    'nums':list(),                                    #the time(hour, minutes, seconds).
                    'h_m_s':list(),
                }
        h_pos = query_t.rfind('h')                                    #h:hour position
        m_pos = query_t.rfind('m')                                    #m:minutes position
        s_pos = query_t.rfind('s')                                    #s:seconds position
        if h_pos >= 0 and m_pos >= 0 and s_pos >= 0:
            time_dict['nums'].append(query_t[:h_pos])                 #appends number of hours
            time_dict['h_m_s'].append(query_t[h_pos:h_pos+1:])        #appends h char
            time_dict['nums'].append(query_t[h_pos+1:m_pos])          #appends number of minutes
            time_dict['h_m_s'].append(query_t[m_pos:m_pos+1])         #appends m char
            time_dict['nums'].append(query_t[m_pos+1:s_pos])          #appends number of seconds
            time_dict['h_m_s'].append(query_t[s_pos:s_pos+1])         #appends s char
        elif m_pos >= 0 and s_pos >= 0:
            time_dict['nums'].append(query_t[:m_pos])
            time_dict['h_m_s'].append(query_t[m_pos:m_pos+1:])
            time_dict['nums'].append(query_t[m_pos+1:s_pos])
            time_dict['h_m_s'].append(query_t[s_pos:s_pos+1])
        elif h_pos >= 0 and m_pos >= 0:
            time_dict['nums'].append(query_t[:h_pos])
            time_dict['h_m_s'].append(query_t[h_pos:h_pos+1:])
            time_dict['nums'].append(query_t[h_pos+1:m_pos])
            time_dict['h_m_s'].append(query_t[m_pos:m_pos+1])
        elif h_pos >= 0 and s_pos >= 0:
            time_dict['nums'].append(query_t[:h_pos])
            time_dict['h_m_s'].append(query_t[h_pos:h_pos+1:])
            time_dict['nums'].append(query_t[h_pos+1:s_pos])
            time_dict['h_m_s'].append(query_t[s_pos:s_pos+1])
        else:
            time_dict['nums'].append(query_t[:h_pos])
            time_dict['h_m_s'].append(query_t[h_pos:])
        return time_dict

def get_url_time(parsed_url):
        """Return a dictionary with the time, hours, minutes, seconds.

            This function gets a parsed url and makes sure that there's
            time in the query or fragment key.

            Args:
                parsed_url: Youtube URL already parsed using urlparse.

            Returns:
                string: Returns a string with the time found in the query, returns
                an empty string otherwise.
        """
        url_time = dict()
        if parsed_url:
            query = urlparse.parse_qs(parsed_url.query)
            for key, val in query.items():                            #looking for the t char
                if key == 't':                                        #if t is found
                    if parsed_url.query:
                        query_t = urlparse.parse_qs(parsed_url.query)['t'][0]
                        url_time = get_time(query_t)
                    elif parsed_url.fragment:
                        query_t = urlparse.parse_qs(parsed_url.fragment)['t'][0]
                        url_time = get_time(query_t)
        return url_time

def parse_url(url):
        """Returns a dictionary that holds the id and time of the given URL.

            This function get a Youtube URL and look for the id and time query.

            Args:
                url: Youtube URL to parsed.

            Returns:
                dict: Returns a dictionary that contains the time and id of the
                Youtube URL.
        """
        result_url = ''
        if url:
            parsed = urlparse.urlparse(url)
            embed_url = 'embed'
            youtu_url = 'youtu.be'
            youtube_url = 'youtube.com'
            path = parsed.path
            host_name = parsed.netloc
            regex = re.compile('.{11}')
            result_url = {
                    'id': '',
                    'time': '',
                }
            if len(url) <= 11 and regex.match(url):
                result_url['id'] = url
                return result_url
            if parsed.query and youtube_url in path or youtube_url in host_name and embed_url not in path:
                result_url['id'] = urlparse.parse_qs(parsed.query)['v'][0]
                return result_url
            if embed_url in path and youtube_url in path or youtube_url in host_name:
                embed = path[path.find(embed_url):]
                result_url['id'] = embed.split('/')[1]
            if youtu_url in path:
                result_url['id'] = path.split('/')[1]
                result_url['time'] = get_url_time(parsed)
            elif parsed.scheme and youtu_url in host_name:
                result_url['id'] = path.split('/')[1]
                result_url['time'] = get_url_time(parsed)
        return result_url
