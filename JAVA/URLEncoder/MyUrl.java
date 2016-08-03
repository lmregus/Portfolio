/**
 *  MyUrl Class
 *  Developer: Luis Regus
 *  Class: Introduction to Java
 *  Date: 06/14/2016
 *  Description: This class represents a URL with optional URL encoded parameters attached.
 *
 */

public class MyUrl {
    private String mUrl;

    /**
     *  Secondary constructor
     *  Appends http:// in front of
     *  The string if not found
     *
     *  @param url url to check
     *
     */
    public MyUrl(String url) {
        if (url.indexOf("http://") != -1) {
            this.mUrl = url;
        }else {
            this.mUrl = "http://" + url;
        }
    }

    /**
     *  Appends the argument to the instance variable mUrl
     *
     *  @param name   argument identifier
     *  @param value  argument identifier value
     *  @return       void
     */
    public void addArgument(String name, String value) {
        this.mUrl += parseArgument(name, value);
    }

    /**
     *  Overloaded addArgument, gets an integer instead of 
     *  A string as the value of the argument
     */
    public void addArgument(String name, int value) {
        this.mUrl += parseArgument(name, Integer.toString(value));
    }

    /**
     *  Overloaded addArgument, gets a double instead of
     *  A string as the value of the argument
     */
    public void addArgument(String name, double dvalue) {
        this.mUrl += parseArgument(name, Double.toString(dvalue));
    }

    /**
     *  Returns the mUrl value
     *
     *  @return the object's url value
     */
    public String toString() {
        return this.mUrl;
    }

    /**
     *  Returns an URL encoded string
     *  The text argument must be string
     *
     *  @param text    a string to be URL encoded
     *  @return        the encoded text 
     */
    public static String urlEncode(String text) {
        int index;
        String encodedLine = "";
        String hexValue = "";
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-.*";
        
        for (index = 0; index < text.length(); index++) {
            char srcChar = text.charAt(index);

            if (srcChar == ' '){
                encodedLine += '+';
            }else if (chars.indexOf(srcChar) != -1) {
                encodedLine += srcChar;
            }else {
                hexValue = "%" + Integer.toHexString(srcChar);
                encodedLine  += hexValue;
            }
        }

        return encodedLine;
    }
 
    /**
     *  Returns the parsed version of the URL arguments
     *  Of the form name=value it appends a ? or & depending 
     *  On the set condition, the paramaters must be converted 
     *  To string object before they are send to the method
     *
     *  @param name    the identifier of the argument
     *  @param value   the value of the identifier of the argument
     *  @return        the parsed argument     
     */
    private String parseArgument(String name, String value) {
        String parsedArgument = "";
        if (this.mUrl.indexOf("?") == -1) {
            parsedArgument = "?" + urlEncode(name) + "=" + urlEncode(value);
        }else {
            parsedArgument = "&" + urlEncode(name) + "=" + urlEncode(value);
        }

        return parsedArgument;
    }
}
