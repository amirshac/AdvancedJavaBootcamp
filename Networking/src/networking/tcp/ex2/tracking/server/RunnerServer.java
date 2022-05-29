package networking.tcp.ex2.tracking.server;

import java.io.IOException;

public class RunnerServer {

	private static int SERVER_PORT = 8080;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		TrackingServer server = new TrackingServer(SERVER_PORT);
		server.go();
	}

}