package com.orbata;
import java.util.ArrayList;
import java.util.List;

public class MathUtils {

	public static List<String> combine() {
		List<String> words = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;

			{
				add("A");
				add("B");
				add("C");
				add("D");
			}
		};
		List<String> combs = new ArrayList<String>();
		int n = words.size();
		System.out.println(n);
		String c;

		for (int y = 0; y < 6; y++) {
			c = "";
			for (int j = 0; j < n; j++) {
				c = c + words.get(j);
				combs.add(c);
				// combs.add(words.get(j) + c);
			}
			String x = words.get(0);
			words.remove(0);
			words.add(x);
		}
		return combs;

	}

	public static final String crypt(String s, int rot) {
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
