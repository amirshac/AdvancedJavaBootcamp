package networking.tcp.TcpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient {
	String serverName;
	int serverPort;
	
	BufferedReader reader;
	PrintWriter writer;
	
	Socket clientSocket;
		
	boolean clientActive;
	
	public TcpClient(String serverName, int serverPort) {
		this.serverName = serverName;
		
		this.serverPort = serverPort;
		reader = null;
		writer = null;
		clientSocket = null;
		
		clientActive = true;
		startClient();
	}
	
	
	protected void startClient() {
		try {
			clientSocket = new Socket(serverName, serverPort);
			initStreamReaderWriter();
			System.out.println("<TCP CLIENT> Connected to server " +serverName);
		} catch (IOException e) {
			System.out.println("<TCP CLIENT> Couldn't connect to server " + serverName);
			e.printStackTrace();
		} 
		
	}
	
	protected void initStreamReaderWriter() {
		try {
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("<TCP Client> Couldn't init reader writer");
			closeConnections();
		}
	}
	
	public void go() {
		while (clientActive) {
			sendLineToServer("Test");
			String line = getLineFromServer();
			System.out.println(line);
		}	
	}
	
	protected String getLineFromServer() {
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("<TCP Client> Couldn't get data");
			e.printStackTrace();
		}
		
		System.out.println("Server sent: " + line);
		return line;
	}
	
	protected void sendLineToServer(String lineToSend) {
		try {
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println(lineToSend);
		} catch (IOException e) {
			System.out.println("<TCP Client> Couldn't send line to client");
			e.printStackTrace();
		}
	}
	
	protected void closeConnections() {
		try {
			if (clientSocket != null)
				clientSocket.close();
			if (reader != null)
				reader.close();
		}catch (IOException e) {
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		TcpClient client = new TcpClient("localhost", 8080);
		client.go();
		client.closeConnections();
	}

}
