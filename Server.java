import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
class Server implements Runnable{
	ServerSocket welcomeSocket;
	Socket connectionSocket;
	public void chat() throws IOException {
    welcomeSocket=new ServerSocket(4000);
     while(true) {
    	 System.out.println("Waiting for connection");
    	 connectionSocket=welcomeSocket.accept();
    	 System.out.println("Connection accepted");
    	 Thread obj=new Thread(this);
    	 obj.start();
    	 
     }
	}
	public void run()  {
		try {
		 Scanner sc =new Scanner(System.in);
		 while(true) {
		BufferedReader in =new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
   	 OutputStream outToClient=connectionSocket.getOutputStream();
   	 String sentenceReceived=in.readLine();
   	 System.out.println("Client: "+sentenceReceived);
   	 if(sentenceReceived.trim().equalsIgnoreCase("Quit")) {
   		 connectionSocket.close();
   		 break;
   	 }
   	 System.out.print("Server: ");
   	 String sentenceSent=sc.nextLine();
   	 outToClient.write((sentenceSent+"\n").getBytes());
		 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String args[]) throws IOException {
		(new Server()).chat();
	}
}