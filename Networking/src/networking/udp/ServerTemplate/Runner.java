package networking.udp.ServerTemplate;

public class Runner {

	public static void main(String[] args) {
		int serverPort = 4444;
		Server server = new Server(serverPort);
		server.start();
	}

}
