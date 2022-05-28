package networking.tcp.ex3.restaurant.server;

public class RunnerServer {
	public static void main(String[] args) {
		RegisterServer registerServer = new RegisterServer();
		registerServer.startServer();
		registerServer.go();
		registerServer.closeConnections();
	}
}
