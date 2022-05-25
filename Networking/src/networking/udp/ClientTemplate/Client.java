package networking.udp.ClientTemplate;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import networking.udp.ServerTemplate.PacketUtil;

public class Client{

	InetAddress serverAddress; 
	InetAddress localAddress;
	protected String servername;
	protected int serverPort;
	protected int port;
	
	private final static String ERRMSG_SOCKET = "<UDP Client> Error opening socket";
	private final static String MSG_SOCKETOPEN = "<UDP Client> Socket open";
		
	DatagramSocket socket;
	
	DatagramPacket receivePacket;
	DatagramPacket sendPacket;
	
	public Client(String servername, int serverPort, int port) {
		this.servername = servername;
		this.serverPort = serverPort;
		this.port = port;
		
		try {
			localAddress = InetAddress.getLocalHost();
			serverAddress = InetAddress.getByName(servername);
		} catch (UnknownHostException e) {
			System.out.println("unknown host");
			e.printStackTrace();
		}
		openSocket();
	}

	public void start (){
		boolean keepGoing = true;
		
		while (keepGoing) {
			sendPacket = PacketUtil.makePacket("Testing", serverAddress, serverPort);
			PacketUtil.sendPacket(sendPacket, socket);
			receivePacket = PacketUtil.getPacket(socket);
			String msg = PacketUtil.getStringFromPacket(receivePacket);
			System.out.println(msg);
			keepGoing = false;
		}
	}
	
	private void openSocket() {
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			System.out.println(ERRMSG_SOCKET);
		}
		
		System.out.println(MSG_SOCKETOPEN);
	}
}
