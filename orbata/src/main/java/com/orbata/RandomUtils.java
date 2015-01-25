package com.orbata;

import java.util.List;
import java.util.Random;

public class RandomUtils {
	private static final Random rand = new Random();

	public static String randAlphabetic(int length) {
		return randomString(length, StringConstants.LETTERS);
	}

	public static String randAlphaNumeric(int length) {
		return randomString(length, StringConstants.NUMBERS
				+ StringConstants.LETTERS);

	}

	public static int randInt(int max) {
		return randInt(0, max);
	}

	public static int randInt(int min, int max) {
		// nextInt is normally exclusive of the top value, // so add 1 to make
		// it inclusive
		int randomNum = rand.nextInt(max - min + 1) + min;
		return randomNum;
	}

	public static String randNumeric(int length) {
		return randomString(length, StringConstants.NUMBERS);
	}

	public static String randomString(int length, String pool) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < length) {
			sb.append("" + pool.charAt(randInt(pool.length() - 1)));
			i++;
		}
		return sb.toString();
	}
	public static Object choice(List<? extends Object> list){
		
		return list.get(randInt(list.size()));
		
	}

}
