package Task03;

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

			while(true){
				System.out.println("Write something to server: ");
				String user_input = sc.nextLine();
				writer.println(user_input);
				String from_server = reader.readLine();

				if(from_server.equalsIgnoreCase("//"))
					break;
				else
					System.out.println("Response From the server = " + from_server);
			}
			s.close();
		}
		catch(Exception e){
			System.out.println(e);}
	}
}