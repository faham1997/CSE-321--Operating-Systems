package Task01;

import java.io.*;  
import java.net.*; 

public class Client {
	private static int port = 7777;

	public static void main(String[] args) {
		try {
		Socket s = new Socket("localhost",port);
		InputStreamReader reader= new InputStreamReader(new DataInputStream(s.getInputStream()));
		BufferedReader input = new BufferedReader(reader);
		System.out.println(input.readLine());
		s.close();
		
		} catch(Exception e) {
			System.out.println(e);	
		}
		}

}
