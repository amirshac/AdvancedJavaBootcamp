package networking.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		
		InetAddress uniAddress = InetAddress.getByName("in.bgu.ac.il");
		System.out.println(uniAddress);
		
		InetAddress addresses[] = InetAddress.getAllByName("www.facebook.com");
		
		for (int i=0; i<addresses.length; i++)
			System.out.println(addresses[i]);		

	}	

}
