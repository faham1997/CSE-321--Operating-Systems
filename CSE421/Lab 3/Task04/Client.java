package Task04;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	private static int port = 6668;
	public static void main(String[] args){
		try{
			Socket s=new Socket("localhost",port);

			DataOutputStream output=new DataOutputStream(s.getOutputStream());
			PrintWriter writer=new PrintWriter(output,true);

			InputStream input=s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			if(true){
				System.out.println("Add or Subtract or Multiply?");
				String user_input = sc.nextLine();
				writer.println(user_input);
				String from_server = reader.readLine();
				System.out.println(from_server);
				if(from_server.equalsIgnoreCase("Please give two inputs:")){   
					String num1 = sc.nextLine();
					String num2 = sc.nextLine();
					writer.println(num1);
					writer.println(num2);
					String result = reader.readLine();
					System.out.println(result);
				}
			}
			s.close();
		}
		catch(Exception e){
			System.out.println(e);}
	}
}