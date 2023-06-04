

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendTh extends Thread {
	DatagramSocket sc;
	String login;
	
	public SendTh(DatagramSocket sc,String login) {
		super();
		this.sc = sc;
		this.login=login;
	}
	public void run() {
		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DatagramPacket pk;
			while (true) {
				String msg=in.readLine();
				InetAddress ad=InetAddress.getLocalHost();
				pk=new DatagramPacket(msg.getBytes(),msg.length(),ad,3000);
				sc.send(pk);
				//System.out.print(11);
				
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
