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
        String encoded=Base64Util.encode("ravi@gmail.com");
        System.out.println("Encoded String 'ravi@gmail.com' to "+encoded);
        String decoded=Base64Util.decode("cmF2aUBnbWFpbC5jb20=");
        System.out.println("Decode now : "+decoded);
        encoded=Base64Util.encode("password");
        System.out.println("Encoded String 'password' to "+encoded);
        decoded=Base64Util.decode("cGFzc3dvcmQ=");
        System.out.println("Decode now : "+decoded);
    }
}
