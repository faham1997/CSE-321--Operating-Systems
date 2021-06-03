package Task03;

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
  
  new ServerThread(s).start();
  
  ss.close();
  
  }
  
 }catch(Exception e){
	 System.out.println(e);}
}
}