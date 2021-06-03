package Task01;

import java.io.*;  
import java.net.*; 
import java.util.Date;

public class Server {
	private static int port = 7777;

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Connection Initiated");
			Socket s= ss.accept();
			System.out.print("Connectin Established");
			
			DataOutputStream output = new DataOutputStream(s.getOutputStream());
			PrintWriter writer = new PrintWriter(output,true);
			
			writer.println(new Date().toString());
			
			
			ss.close();
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
		

	}
}