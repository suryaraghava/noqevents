package com.noq.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class PassowrdHash {

	 public synchronized String encrypt(String plaintext) {
	        MessageDigest msgDigest = null;
	        String hashValue = null;
	        try {
	            msgDigest = MessageDigest.getInstance("SHA");
	            msgDigest.update(plaintext.getBytes("UTF-8"));
	            byte rawByte[] = msgDigest.digest();
	            hashValue = (new BASE64Encoder()).encode(rawByte);
	 
	        } catch (NoSuchAlgorithmException e) {
	            System.out.println("No Such Algorithm Exists");
	        } catch (UnsupportedEncodingException e) {
	            System.out.println("The Encoding Is Not Supported");
	        }
	        return hashValue;
	    }
	
}
