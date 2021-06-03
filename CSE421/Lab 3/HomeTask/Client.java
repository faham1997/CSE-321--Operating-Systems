package HomeTask;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client{
	private static int port = 6668;

	public static void main(String[]args){
		try{
			Socket s= new Socket("localhost",port);
			InputStreamReader input= new InputStreamReader(new DataInputStream(s.getInputStream()));
			BufferedReader reader=new BufferedReader(input);

			DataOutputStream output= new DataOutputStream(s.getOutputStream());
			PrintWriter writer=new PrintWriter(output,true);


			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("Please input something:");

				String k=sc.nextLine();
				writer.println(k);

				String response= reader.readLine();
				System.out.println("Output: "+ response);

			} 

		}
		catch(Exception e){
			System.out.print(e);
		}
	}

}
