def sieve(limit):
    ''' This function find all primes up to a certain limit
        using the sieve of Eratosthenes algorithm

        Args:
            limit (int): primes range

        Returns:
            list: a list of prime numbers
    '''
    num_lst = [2]
    # marks multiples of 2
    num_lst += [x if x % 2 != 0 else 0 for x in range(3, limit + 1)]

    for p in num_lst:
        if p ** 2 < limit and p:
            for i in range(p * p, limit + 1, 2 * p):
                num_lst[i - 2] = 0
    return [p for p in num_lst if p]
