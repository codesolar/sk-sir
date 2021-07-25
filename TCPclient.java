package socket;
import java.io.*;
import java.net.*;

public class TCPclient{
	public static void main(String[] args) throws Exception {
	String sentence="";
	String server_ip="localhost";
	int port=9980;
	File fh=new File(".\\bin\\socket\\basic.txt");
	FileReader fr=new FileReader(fh);
	try (BufferedReader br = new BufferedReader(fr)) {
		StringBuffer sb=new StringBuffer();
		String line=null;
		while((line=br.readLine())!=null) {
			sb.append(line);
			sb.append("\n");
		}
		sentence=sb.toString();
	}
	
	try (Socket ClientSocket = new Socket(server_ip,port)) {
		OutputStreamWriter outToServer=new OutputStreamWriter(ClientSocket.getOutputStream());
		outToServer.write(sentence);
		outToServer.flush();
		ClientSocket.close();
	}
	
}
}
