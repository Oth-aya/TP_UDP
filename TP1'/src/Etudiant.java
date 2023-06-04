

import java.net.InetAddress;

public class Etudiant {
 String nom;
 String login;
 int niveau;
 String etat;
 InetAddress adr;
 int port;
public Etudiant() {
	super();
}
public Etudiant(String nom, String login, int niveau, String etat,InetAddress adr,int port) {
	super();
	this.nom = nom;
	this.login = login;
	this.niveau = niveau;
	this.etat = etat;
	this.adr=adr;
	this.port=port;
}
public InetAddress getAdr() {
	return adr;
}
public void setAdr(InetAddress adr) {
	this.adr = adr;
}
public int getPort() {
	return port;
}
public void setPort(int port) {
	this.port = port;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public int getNiveau() {
	return niveau;
}
public void setNiveau(int niveau) {
	this.niveau = niveau;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
};
public void AddGroup (Groupe g) {
	
}
 
}
