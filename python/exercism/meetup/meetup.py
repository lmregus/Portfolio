#############################
#                           #
# Developer: Luis Regus     #
# Date: 11/16/2015          #
#                           #
#############################
from calendar import monthrange
from datetime import date


def meetup_day(year, month, day, pos):
    ''' Calculates the date of meetups

        Args:
            year (int): Meetup's year
            month (int): Meetup's month
            day (string): Meetup's day
            pos (string): Which day of the week
    '''
    month_days = monthrange(year, month)[1]
    dates = (date(year, month, day) for day in range(1, month_days + 1))
    days = [my_date for my_date in dates if my_date.strftime('%A') == day]

    if pos == 'last':
        return days[-1]
    if pos == 'teenth':
        return next(tnth_day for tnth_day in days
                    if tnth_day.day >= 13 and tnth_day.day <= 19)
    return days[int(pos[0]) - 1]
