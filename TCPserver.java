package socket;
import java.io.*;
import java.net.*;
public class TCPserver {
	public static void main(String[] args) throws Exception {
		System.out.println("server is now running");
		String sentence="",line="";
		int port=9980;
		while(true) {
		try (ServerSocket welcomeSocket = new ServerSocket(port)) {
			Socket connectionSocket=welcomeSocket.accept();
			System.out.println("connection is established");
			BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			while((line=inFromClient.readLine())!=null) sentence+=(line+"\n");
			System.out.println("client file="+sentence);
			connectionSocket.close();
		}
		}
	}
}
