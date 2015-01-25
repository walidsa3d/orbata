package com.orbata;

public class RegexConstants {
	public static final String EMAIL_REGEX = "([a-z0-9!#$%&'*+\\/=?^_`{|}~-]+@([a-z0-9]+\\.)+([a-z0-9]+))";
	public static final String URL_REGEX = "((?:https?:\\/\\/|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}\\/)(?:"
			+ "[^\\s()<>]+|\\((?:[^\\s()<>]+|(?:\\([^\\s()<>]+\\)))*\\))+(?:\\((?:[^\\s()<>]+|(?:\\([^\\s"
			+ "()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:\\'\".,<>?\\xab\\xbb\\u201c\\u201d\\u2018\\u2019]))";
	private static final String NUMBER_REGEX = "";
}
