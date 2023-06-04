
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ServeurEtd {
	static List<Etudiant> etd = new ArrayList<Etudiant>();
	static List<Groupe> gr;
	static List<Message> m;
	static int port;
	InetAddress ad;

	public static void main(String[] args) {

		port = 3000;
		DatagramPacket pk;
		DatagramSocket sc;

		try {
			InetAddress ad = InetAddress.getByName("127.0.0.1");
			// System.out.print("login");

			sc = new DatagramSocket(port);
			// System.out.print("login");

			while (true) {
				// System.out.print("login");
				pk = new DatagramPacket(new byte[1024], 1024);

				sc.receive(pk);
				// System.out.print("login");

				String msg = new String(pk.getData(), 0, pk.getLength());
				if (msg.startsWith("##")) {
					//System.out.print("login" + msg);

					String[] ms = msg.split("##");
					boolean exist = false;
					for (Etudiant e : ServeurEtd.etd) {
						if (ms[1].equals(e.getLogin())) {
							exist = true;
							//System.out.print("exist");
						}
					}
					if (exist == false) {
						Etudiant et = new Etudiant(ms[1], ms[1], 1, "connectee", pk.getAddress(), pk.getPort());
						ServeurEtd.etd.add(et);
						System.out.print(et.login);
						String msg1 = "connecté avec succes";
						DatagramPacket pk1 = new DatagramPacket(msg1.getBytes(), msg1.length(), pk.getAddress(),pk.getPort());
						sc.send(pk1);

					} else {
						//System.out.println("eeeee");
						String msg1 = "login existant";
						DatagramPacket pk1 = new DatagramPacket(msg1.getBytes(), msg1.length(), pk.getAddress(),
								pk.getPort());
						sc.send(pk1);
					}

				}
				if (msg.startsWith("#List_EDTS")) {
					String Rep = "";

					for (Etudiant e : ServeurEtd.etd) {
						// System.out.print("liste des etudiants");
						Rep = e.getLogin() + "++" + e.getAdr() + "++" + e.getPort();
						DatagramPacket pks = new DatagramPacket(Rep.getBytes(), Rep.length(), pk.getAddress(),	pk.getPort());
						sc.send(pks);

					}

				}
				if (msg.startsWith("#HISTO")) {
					String Rep = "";

					for (Message mr : ServeurEtd.m) {
						// if(mr.etdDes.getLogin().equals(ad))
						Rep += mr.getMsg() + '\n';

					}
					DatagramPacket pks = new DatagramPacket(Rep.getBytes(), Rep.length(), pk.getAddress(), 3000);

				}
				if (msg.startsWith("#Groups")) {
					String Rep = "";

					for (Groupe g : ServeurEtd.gr) {
						// if(mr.etdDes.getLogin().equals(ad))
						Rep += g.getTitre() + '\n';

					}
					DatagramPacket pks = new DatagramPacket(Rep.getBytes(), Rep.length(), pk.getAddress(), pk.getPort());

				}
				if (msg.startsWith("#Group")) {
					System.out.println("goupe");

					String[] ms = msg.split("#");
					boolean exist = false;
					for (Groupe g : ServeurEtd.gr) {
						if (ms[2].equals(g.getTitre())) {
							exist = true;
						}
					}
					if (exist == false) {
						System.out.println("goupef");
						Etudiant et=null;
						for (Etudiant e : ServeurEtd.etd) {
							if (pk.getPort()==(e.getPort())) {
								 et = e;
							}
						}
						List <Etudiant>le=null;
						

						le.add(et);
						
						Groupe g1 = new Groupe (ms[2],le,null);
						ServeurEtd.gr.add(g1);
						
						String msg1 = "votre groupe a été créer";
						DatagramPacket pk1 = new DatagramPacket(msg1.getBytes(), msg1.length(), pk.getAddress(),pk.getPort());
						sc.send(pk1);

					} else {
						System.out.println("goupet");

						
						String msg1 = "Groupe existant";
						DatagramPacket pk1 = new DatagramPacket(msg1.getBytes(), msg1.length(), pk.getAddress(),pk.getPort());
						sc.send(pk1);
					}

				}
				if (msg.startsWith("#>")) {

				}

				if (msg.startsWith("#ETDS#")) {

				}
				if (msg.startsWith("@#")) {
					String[] s = msg.split("@#");
					String dest = s[1];
					Etudiant EtdDes = null;
					String m = "";
					for (Etudiant e : ServeurEtd.etd) {
						if (dest.equals(e.getLogin())) {
							EtdDes = e;

						}
					}
					if (EtdDes == null) {

						String msg1 = "Etudiant n'existe pas";
						DatagramPacket pk1 = new DatagramPacket(msg1.getBytes(), msg1.length(), pk.getAddress(),
								pk.getPort());
						sc.send(pk1);

					} else {

						String msg1 = EtdDes.getLogin() + ">>" + s[2];
						DatagramPacket pk1 = new DatagramPacket(msg1.getBytes(), msg1.length(), EtdDes.getAdr(),
								EtdDes.getPort());
						sc.send(pk1);

					}

				}
				if (msg.startsWith("@>")) {

				}
				else {
					String msg1 = "Commande eronnée";
					DatagramPacket pk1 = new DatagramPacket(msg1.getBytes(), msg1.length(), pk.getAddress(),pk.getPort());
					sc.send(pk1);
				}

			}

		} catch (Exception e) {

		}

	}
}
