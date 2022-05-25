package networking.udp.ClientTemplate;

public class Runner {

	public static void main(String[] args) {
		String serverName = "localHost";
		int serverPort = 4444;
		int clientPort = 4445;
		Client client = new Client(serverName, serverPort, clientPort);
		client.start();
		
	}

}
