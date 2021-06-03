package Task04;

import java.io.*;
import java.net.*;

public class Server {
	private static int port = 6668;
	public static void main(String[] args){
		try{

			while(true){

				ServerSocket ss=new ServerSocket(port);
				System.out.println("Server Initiated");
				Socket s = ss.accept();
				System.out.println("Server Connected");

				DataOutputStream output=new DataOutputStream(s.getOutputStream());
				PrintWriter writer=new PrintWriter(output,true);

				InputStream input=s.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));

				if(true){
					String from_client =  reader.readLine();
					if(from_client.equalsIgnoreCase("add")){
						String s1 = "Please give two inputs:"; 
						writer.println(s1);
						int n1=Integer.parseInt(reader.readLine());
						int n2=Integer.parseInt(reader.readLine());
						int n = n1 + n2;
						String val = String.valueOf(n);
						writer.println(val);
					}
					else if(from_client.equalsIgnoreCase("subtract")){
						String s1 = "Please give two inputs:"; 
						writer.println(s1);
						int n1=Integer.parseInt(reader.readLine());
						int n2=Integer.parseInt(reader.readLine());
						int n = n1 - n2;
						String val = String.valueOf(n);
						writer.println(val);
					}
					else{
						if(from_client.equalsIgnoreCase("multiply")){
							String s1 = "Please give two inputs:"; 
							writer.println(s1);
							int n1=Integer.parseInt(reader.readLine());
							int n2=Integer.parseInt(reader.readLine());
							int n = n1 * n2;
							String val = String.valueOf(n);
							writer.println(val);	   
						}
					}
				}
				ss.close();
			}
		}catch(Exception e)
		{
			System.out.println(e);}
	}
}