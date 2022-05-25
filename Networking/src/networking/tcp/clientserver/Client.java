package networking.tcp.clientserver;

public class Client {
	private static final String SERVER_NAME = "localhost";
	private static final int SERVER_PORT = 8080;

	public static void main(String[] args) throws IOException {
		Socket clientSocket = null;
		PrintWriter writer = null;
		BufferedReader bufferReader = null;

		try {
			clientSocket = new Socket(SERVER_NAME, SERVER_PORT);
			System.out.println("Connected to server");

			// sending data
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println("Hello people");
			
			// create reader
			bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			// reading
			String line = bufferReader.readLine();
			System.out.println("server says: " + line);

		} catch (UnknownHostException e) {
			System.err.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Socket failed");
			e.printStackTrace();
		} finally {
			if (clientSocket != null) {
				clientSocket.close();
			}
			if (writer != null) {
				writer.close();
			}
			if (bufferReader != null) {
				bufferReader.close();
			}
		}
	}
}
