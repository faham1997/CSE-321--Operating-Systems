package Task03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{

	Socket s;
	ServerThread (Socket s){
		this.s = s;
	}
	
	public void run(){

		InputStream input = null;
		try{
			DataOutputStream output=new DataOutputStream(s.getOutputStream());
			PrintWriter writer=new PrintWriter(output,true);
			input= s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			while(true){
				String res =  reader.readLine();
				if(res.equalsIgnoreCase("end game")){
					break;
				}
				else
					writer.println(res);  
			}
		}catch (IOException e){
			System.out.println(e);
		}

	}
}
