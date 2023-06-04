

public class Message {
Etudiant etdEXp;
Etudiant etdDes;
String msg;

public Message() {
	super();
}
public Message(Etudiant etdEXp, Etudiant etdDes, String msg) {
	super();
	this.etdEXp = etdEXp;
	this.etdDes = etdDes;
	this.msg = msg;
}
public Etudiant getEtdEXp() {
	return etdEXp;
}
public void setEtdEXp(Etudiant etdEXp) {
	this.etdEXp = etdEXp;
}
public Etudiant getEtdDes() {
	return etdDes;
}
public void setEtdDes(Etudiant etdDes) {
	this.etdDes = etdDes;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}


}
