import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

class Client {
	public static void main(String args[]) throws IOException {
		Socket clientSocket=new Socket("localhost",4000);
		Scanner sc =new Scanner(System.in);
		 while(true) {
		 BufferedReader in =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    	 OutputStream outToServer=clientSocket.getOutputStream();
    	 System.out.print("Client: ");
    	 String sentenceSent=sc.nextLine();
    	 outToServer.write((sentenceSent+"\n").getBytes());
    	 if(sentenceSent.equalsIgnoreCase("Quit")) {
    		 clientSocket.close();
    		 break;
    	 }
    	 String sentenceReceived=in.readLine();
    	 System.out.println("Server : "+sentenceReceived);
    	 
		 }
	}
}