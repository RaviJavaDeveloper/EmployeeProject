
package org.cytrion.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author Ravi Kumar
 */
public class DateUTCTest {
    public static void main(String[] args) throws ParseException{
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));   // This line converts the given date into UTC time zone
final java.util.Date dateObj = sdf.parse("2013-10-22 01:37:56");

String aRevisedDate = new SimpleDateFormat("MM/dd/yyyy KK:mm:ss a z").format(dateObj);
System.out.println("Revised date is: "+aRevisedDate);
    }
    
}
