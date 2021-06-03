package  HomeTask;

import java.io.*;
import java.net.*;

public class Server{
	private static int port = 6668;


	public static void main(String[]args){

		try{

			ServerSocket ss= new ServerSocket(port);
			System.out.println("Server Running");
			Socket socket=ss.accept();

			InputStreamReader input= new InputStreamReader(new DataInputStream(socket.getInputStream()));
			BufferedReader reader=new BufferedReader(input);

			DataOutputStream output= new DataOutputStream(socket.getOutputStream());
			PrintWriter writer=new PrintWriter(output,true);

			while(true) {
				String client_response = reader.readLine();

				writer.println(client_response.toUpperCase());	
			}
		}
		catch(Exception e){
			System.out.print(e);
		}
	}


}