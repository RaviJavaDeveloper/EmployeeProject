/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cytrion.utility;

import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Ravi Kumar
 */
public class Base64Util {
    
    public static String encode(String encode){
        byte[] bytes=encode.getBytes();
        String encodedString=DatatypeConverter.printBase64Binary(bytes);
        return encodedString;
    }
    public static String decode(String decode){
        byte[] bytes=DatatypeConverter.parseBase64Binary(decode);
        String decodedString=new String(bytes);
        return decodedString;
    }
}
