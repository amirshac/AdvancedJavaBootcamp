package networking.udp.ServerTemplate;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PacketUtil {
	private final static int BUFFER_SIZE = 1024;
	private final static String ERRMSG_GETPACKET = "Error receiving packet";
	private final static String ERRMSG_SENDPACKET = "Error sending packet";
	
	public static DatagramPacket makePacket(String msg, InetAddress address, int port) {
		byte[] buffer = msg.getBytes();

		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
		return packet;
	}
	
	public static DatagramPacket getPacket(DatagramSocket socket) {
		byte[] buffer = new byte[BUFFER_SIZE];
		DatagramPacket packet = new DatagramPacket(buffer, BUFFER_SIZE);
		
		try {
			socket.receive(packet);
		} catch (IOException e) {
			System.out.println(ERRMSG_GETPACKET);
			e.printStackTrace();
		}
		
		return packet;
	}
	
	public static boolean sendPacket(DatagramPacket packet, DatagramSocket socket) {
		try {
			socket.send(packet);
		} catch (IOException e) {
			System.out.println(ERRMSG_SENDPACKET);
			e.printStackTrace();
			return false;
		}
		
		System.out.println("Packet sent");
		return true;
	}
	
	public static String getStringFromPacket(DatagramPacket packet) {
		return new String(packet.getData()).trim();
	}

}
