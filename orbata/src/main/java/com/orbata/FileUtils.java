package com.orbata;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

	public static String asString(String filepath) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(filepath));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = bf.readLine()) != null) {
			sb.append(line);
		}
		bf.close();
		return sb.toString();
	}

	public static String[] listFiles(String path) {
		return new String[0];

	}

}
