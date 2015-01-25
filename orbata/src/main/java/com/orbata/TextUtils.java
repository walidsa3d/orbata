package com.orbata;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {
	// throws an exception if a string is null
	private static final void checkNotNull(String s) {
		if (s == null) {
			throw new IllegalArgumentException("String is null");
		}
	}

	// extracts email addresses from a string
	public static final String[] extractEmail(String s) {
		Pattern emailPattern = Pattern.compile(RegexConstants.EMAIL_REGEX,
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		return match(emailPattern, s);
	}

	// extracts URLs from a given string
	public static final String[] extractURL(String s) {
		Pattern linkPattern = Pattern.compile(RegexConstants.URL_REGEX,
				Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		return match(linkPattern, s);
	}

	// returns true if a string contains capitals
	public static final boolean hasCapitals(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				return true;
			}
		}
		return false;

	}

	// returns true if a string has digits
	public static final boolean hasDigits(String s) {
		for (int i = 0; i < 10; i++) {
			if (Character.isDigit(s.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static final String hash(String s, String hashtype) {
		return "";
	}

	// returns true if a given string is a palindrome
	public static final boolean isPalindrome(String s) {
		if (s.equals(TextUtils.reverse(s))) {
			return true;
		}
		return false;
	}

	// joins an array of string into one string using a delimiter
	public static final String join(String[] s, String delim) {
		StringBuilder sb = new StringBuilder();
		for (String si : s) {
			sb.append(si).append(delim);
		}
		sb.setLength(2 * s.length - 1);
		return sb.toString();

	}

	private static final String[] match(Pattern pattern, String s) {
		Matcher matcher = pattern.matcher(s);
		ArrayList<String> matches = new ArrayList<String>();

		while (matcher.find()) {
			matches.add(matcher.group());
		}

		String[] matchesArray = new String[matches.size()];

		for (int i = 0; i < matchesArray.length; i++) {
			matchesArray[i] = matches.get(i);
		}

		return matchesArray;
	}

	// reverses a string
	public static final String reverse(String s) {
		checkNotNull(s);
		char[] st = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		int n = st.length;
		for (int i = 0; i < n; i++) {
			sb.append(st[n - i - 1]);
		}
		return sb.toString();
	}

	public static final char[] rotate(String s) {
		String alphabet = StringConstants.LETTERS;
		char[] chars = s.toCharArray();
		alphabet.indexOf(chars[1]);
		for (int i = 0; i < s.length(); i++) {
			chars[i] = alphabet.charAt(alphabet.indexOf(chars[i]) + 1);
		}
		return chars;

	}

	// removes unwanted characters from a string
	public static final String strip(String s, String r) {
		for (char c : r.toCharArray()) {
			s = s.replace(Character.toString(c), "");
		}
		return s;
	}

	// @return an array of string characters composing a string
	public static final String[] toStringArray(String s) {
		char[] chars = s.toCharArray();
		String[] strings = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			strings[i] = String.valueOf(chars[i]);

		}
		return strings;
	};

	// @return an array of the words composing the string
	public static String[] toWordArray(String s) {

		StringTokenizer stringTokenizer = new StringTokenizer(s.trim());
		String[] strings = new String[stringTokenizer.countTokens()];

		int i = 0;
		while (stringTokenizer.hasMoreTokens()) {
			strings[i] = strip(stringTokenizer.nextToken(),
					StringConstants.PUNCTUATION);
			i++;
		}
		return strings;
	}

	// @return the number of words in a given string
	public static final int wordcount(String s) {
		return TextUtils.toWordArray(s).length;
	}

	// @return calculates the frequency of every word in a string
	public static final Map<String, Integer> wordfreq(String s) {

		String[] wordarray = TextUtils.toWordArray(s);
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (String word : wordarray) {
			Integer f = map.get(word);
			if (f != null) {
				map.put(word, f + 1);
			} else {
				map.put(word, 1);
			}
		}
		return map;
	}
}
