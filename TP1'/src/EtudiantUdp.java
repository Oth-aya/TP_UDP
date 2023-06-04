import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EtudiantUdp {

	public static void main(String[] args) {
		int port = 5000;
		
		
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		String msg;
		try { 
			InetAddress adr = InetAddress.getByName("127.0.0.1");
		
			do {
				System.out.print("Entre votre ##login##nom##niveau##");
				msg=in.readLine();
			}
			while(!msg.startsWith("##"));
			
			DatagramSocket sc = new DatagramSocket ();
			DatagramPacket pk=new DatagramPacket(msg.getBytes(),msg.length(),adr,3000);
			sc.send(pk);
			String login =msg.substring(2);
			//System.out.print(login);

			SendTh s= new SendTh(sc,login);
			ReceiveEtd r=new ReceiveEtd(sc);
			s.start();
			r.start();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
