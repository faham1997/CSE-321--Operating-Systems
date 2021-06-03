package Task02;
import java.io.*;
import java.net.*;
public class Server {
	private static int port = 7777;

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

				while(true){
					String from_client =  reader.readLine();
					if(from_client.equalsIgnoreCase("end game")){
						break;
					}
					else
						writer.println(from_client);  
				}

				ss.close();

			}

		}
		catch(Exception e){
			System.out.println(e);
			}
	}
}