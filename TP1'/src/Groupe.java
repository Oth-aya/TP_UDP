

import java.util.List;

public class Groupe {
String titre;
List <Etudiant> etd ;
List <Message> msgs;
public Groupe() {
	super();
}
public Groupe(String titre, List<Etudiant> etd, List<Message> msgs) {
	super();
	this.titre = titre;
	this.etd = etd;
	this.msgs = msgs;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public List<Etudiant> getEtd() {
	return etd;
}
public void setEtd(List<Etudiant> etd) {
	this.etd = etd;
}
public List<Message> getMsgs() {
	return msgs;
}
public void setMsgs(List<Message> msgs) {
	this.msgs = msgs;
}

}
