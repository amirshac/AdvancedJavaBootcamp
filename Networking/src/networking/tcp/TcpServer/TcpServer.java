package networking.tcp.TcpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	int port;
	ServerSocket serverSocket;
	BufferedReader bufferedReader;
	PrintWriter writer;
	
	Socket clientSocket;
	
	boolean serverActive;
	
	public TcpServer(int port) {
		this.port = port;
		serverSocket = null;
		bufferedReader = null;
		writer = null;
		clientSocket = null;
		serverActive = true;
		
		startServer();
	}
	
	
	protected void startServer() {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("<TCP Server> started on port " + port);
		} catch (IOException e) {
			System.out.println("<TCP Server> Couldn't start");
			e.printStackTrace();
		}
	}
	
	public void go() {
		while (serverActive) {
			waitForConnection();
			String clientLine = getLineFromClient();
			// process
			sendLineToClient("<Server echo>" + clientLine);
		}	
	}
	
	protected void waitForConnection() {
		try {
			clientSocket = serverSocket.accept();
			System.out.println("<TCP Server> Client connected");
		} catch (IOException e) {
			System.out.println("<TCP Server> Couldn't connect to client");
			e.printStackTrace();
		}	
	}
	
	protected String getLineFromClient() {
		String line = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			line = bufferedReader.readLine();
		} catch (IOException e) {
			System.out.println("<TCP Server> Couldn't get line from client");
			e.printStackTrace();
		}
		
		System.out.println("Client sent: " + line);
		return line;
	}
	
	protected void sendLineToClient(String lineToSend) {
		try {
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println(lineToSend);
		} catch (IOException e) {
			System.out.println("<TCP Server> Couldn't send line to client");
			e.printStackTrace();
		}
	}
	
	protected void closeConnections() {
		System.out.println("closing connections");
		try {
			if (serverSocket != null)
				serverSocket.close();
			if (bufferedReader != null)
				bufferedReader.close();
		}catch (IOException e) {
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		TcpServer server = null;
		try {
			server = new TcpServer(8080);
			server.go();
		}finally {
			server.closeConnections();
		}
	}

}
