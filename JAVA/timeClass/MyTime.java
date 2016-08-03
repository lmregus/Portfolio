/**
 * MyTime - a simple time class
 *
 * Add code to replace the temporary 'return' statements in the methods,
 * and additional parameter checking code in the setTime method, etc.
 * The temporary 'return' statements are needed to compile OK until
 * you replace them with the actual code.
 */
public class MyTime
{
    // Instance variables holding the time (in 24 hour universal form).
    private int mHour;      // 0 - 23
    private int mMinute;    // 0 - 59
    private int mSecond;    // 0 - 59

    /**
     * Sets the time value for this MyTime object. If *any* of the parameter
     * values are out of range, the time is set to 00:00:00.
     *
     * @param hour      the hour (0 to 23).
     * @param minute    the minute (0 to 59).
     * @param second    the second (0 to 59).
     */
    public void setTime(int hour, int minute, int second)
    {
        if (hour > 23 || minute > 59 || second > 59)
        {
            this.mHour = 0;
            this.mMinute = 0;
            this.mSecond = 0;            
        }else
        {
            this.mHour = hour;
            this.mMinute = minute;
            this.mSecond = second;            
        }
    }

    /**
     * Returns the hour value represented by this MyTime.
     *
     * @return the hour value of this object as an int.
     */
    public int getHour()
    {
        return this.mHour;
    }

    /**
     * Returns the minute value represented by this MyTime.
     *
     * @return the minute value of this object as an int.
     */
    public int getMinute()
    {
        return this.mMinute;
    }

    /**
     * Returns the second value represented by this MyTime.
     *
     * @return  the second value of this object as an int.
     */
    public int getSecond()
    {
        return this.mSecond;
    }

    /**
     * Compares this MyTime object against another MyTime object.
     * The result is true if and only if the argument is not null
     * and represents a time that is the same time as represented
     * by this object
     *
     * @param  other    the object to be compared.
     * @returns  true if both objects represent the same time value,
     *           false otherwise.
     */
    public boolean equals(MyTime other)
    {
        if (other != null && other.mHour == this.mHour && other.mMinute == this.mMinute && other.mSecond == this.mSecond)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * Returns the time of this MyTime object in HH:MM:SS AM/PM form.
     *
     * @return the time value represented by this object as a String
     *         formatted as HH:MM:SS AM/PM .
     */
    public String toString()
    {
        String result = "";

        if (this.mHour >= 1 && this.mHour <= 12)
        {
            result = this.mHour + ":" + twoDigits(this.mMinute) + ":" + twoDigits(this.mSecond) + " "+ "AM";
        }else
        {
            result = Integer.toString(Math.abs(this.mHour - 12)) + ":" + twoDigits(this.mMinute) + ":" + twoDigits(this.mSecond) + " "+ "PM";
 
        }
            return result;
    }

    /**
     * Returns the time of this MyTime object in 24 hour universal form.
     *
     * @return the time value represented by this object as a String
     *         formatted as HH:MM:SS universal time.
     */
    public String toUniversalString()
    {
        String result = "";
        result = twoDigits(this.mHour) + ":" + twoDigits(this.mMinute) + ":" + twoDigits(this.mSecond);
        return result;
    }

    /**
     * Returns the parameter value as a two digit String (with leading 0 if needed)
     *
     * @return the parameter 'value' formatted as a two digit String
     *         (with leading zero if needed).
     */
    private String twoDigits(int value)
    {
        String result = "";

        // TODO - Use the Integer.toString(int) method to convert
        // 'value' to String format, and add a leading "0" if
        // value is less than 10 in order to return a string with
        // two digits.
        if (value < 10)
        {
            result =  "0" + Integer.toString(value);
        }else
        {
            result = Integer.toString(value);
        }
        return result;
    }

}
