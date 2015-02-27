package com.orbata;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

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

	 public static String hash(String filename, String algo) throws Exception {  
		 InputStream fis = new FileInputStream(filename);  
	      byte[] buffer = new byte[1024];  
	      MessageDigest complete = MessageDigest.getInstance(algo); //One of the following "SHA-1", "SHA-256", "SHA-384", and "SHA-512"  
	      int numRead;  
	      do {  
	           numRead = fis.read(buffer);  
	           if (numRead > 0) {  
	                complete.update(buffer, 0, numRead);  
	           }  
	      } while (numRead != -1);  
	      fis.close();  
	      byte[] b = complete.digest(); 
	      String result = "";  
	      for (int i=0; i < b.length; i++) {  
	           result +=  
	                     Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );  
	      }  
	      return result;  
	 } 
	 
	 

}
