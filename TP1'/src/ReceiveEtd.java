

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveEtd extends Thread{
   
	DatagramSocket sc;
public ReceiveEtd(DatagramSocket sc) {
	this.sc = sc;
}
public void run() {
	
	
	DatagramPacket pk;
	try {
		while(true){
		pk=new DatagramPacket(new byte[1024],1024);
		sc.receive(pk);
		System.out.print(new String(pk.getData(),0,pk.getLength()));
		}
	}catch(Exception e) {
		
	}
	
	
	
	
	

}

   
}
