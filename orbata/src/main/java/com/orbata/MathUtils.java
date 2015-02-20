package com.orbata;

public class MathUtils {

	public static final String encrypt(String s, int rot) {
		String alphabet = StringConstants.LETTERS + StringConstants.LETTERS;
		StringBuilder sb = new StringBuilder();
		rot = rot > 25 ? rot % 25 : rot;
		for (int i = 0; i < s.length(); i++) {
			sb.append(alphabet.charAt(alphabet.indexOf(s.charAt(i)) + rot));
		}
		return sb.toString();
	}

	public static boolean entropy(String password) {
		return TextUtils.hasCapitals(password) && TextUtils.hasDigits(password)
				&& password.length() >= 8;

	}

	}
