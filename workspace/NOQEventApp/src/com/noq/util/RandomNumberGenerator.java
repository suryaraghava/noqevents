package com.noq.util;

import java.util.Random;

public class RandomNumberGenerator {

	public static String generateRandomn(){
		String number = "";
		Random ran = new Random();
		int numbers = 100000 + (int)(ran.nextFloat() * 899900);
		number += String.valueOf(numbers);
		return number;
	}
	public static void main(String args[]){
		System.out.println(RandomNumberGenerator.generateRandomn());
		
	}
}
