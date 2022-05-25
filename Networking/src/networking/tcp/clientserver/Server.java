package networking.tcp.clientserver;

public class Server {
	private static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		BufferedReader bufferReader = null;
		PrintWriter writer = null;

		try {
			// start server
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started on port " + PORT);

			while (true) {
				// 3 way handshake
				Socket clientSocket = serverSocket.accept();
				System.out.println(
						"client is connected " + clientSocket.getInetAddress() + " port " + clientSocket.getPort());

				// create reader
				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				// reading
				String line = bufferReader.readLine();
				System.out.println("client says: " + line);
				
				// sending data
				writer = new PrintWriter(clientSocket.getOutputStream(), true);
				writer.println("call call call call from server...");

			}
		} catch (IOException e) {
			System.err.println("Failed to start server on port " + PORT);
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				serverSocket.close();
			}
			if (bufferReader != null) {
				bufferReader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}
}
