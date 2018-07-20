/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cytrion.utility;

/**
 *
 * @author Ravi Kumar
 */
public class Base64Tester {
    public static void main(String[] args) {
        String encoded=Base64Util.encode("ravikumar.sukola@cytrion.com");
        System.out.println("Encoded String 'ravikumar.sukola@cytrion.com' to "+encoded);
        String decoded=Base64Util.decode("cmF2aWt1bWFyLnN1a29sYUBjeXRyaW9uLmNvbQ==");
        System.out.println("Decode now : "+decoded);
    }
}
