package networking.udp.ServerTemplate;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * This is an implementation of a UDP server
 */
public class Server{	
	
	protected DatagramSocket socket;
	protected int port;
	
	private final static String ERRMSG_SOCKET = "<UDP Server> Error opening socket";
	private final static String MSG_SOCKETOPEN = "<UDP Server> Socket open";
	private final static String MSG_SERVERWAITING = "<UDP Server> Waiting for packets";
	private final static String MSG_SERVERGOTPACKET = "<UDP Server> Got packet";
	
	DatagramPacket receivePacket;
	DatagramPacket sendPacket;
	
	public Server(int port) {
		this.port = port;
		openSocket();
	}

	public void start() {
		
		System.out.println(MSG_SERVERWAITING);
		
		while (true) {
			echoPackets();	
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
	
	private void echoPackets() {
		receivePacket = PacketUtil.getPacket(socket);
		String dataString = PacketUtil.getStringFromPacket(receivePacket);
		System.out.println(MSG_SERVERGOTPACKET + " " + dataString);
		
		sendPacket = PacketUtil.makePacket(dataString, receivePacket.getAddress(), receivePacket.getPort());
		PacketUtil.sendPacket(sendPacket, socket);
	}
}