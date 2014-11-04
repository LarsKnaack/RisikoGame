package source;

import java.awt.Color;
import java.util.LinkedList;

public class Spieler {
	private LinkedList<Land> laender;
	private String name;
	private Color farbe;
	private int verstaerkung;
	
	public Spieler(String n, Color f) {
		name = n;
		farbe = f;
		verstaerkung = 0;
		laender = new LinkedList<Land>();
	}
	
	public void addLand(Land l){
		laender.add(l);
		l.setBesatzer(this);
	}
	
	public void removeLand(Land l){
		laender.remove(l);
		l.setBesatzer(null);
	}
	
	public LinkedList<Land> getLaender(){
		return  laender;
	}
	
	public String getName() {
		return name;
	}
	
	public void setVerstaerkung() {
		verstaerkung = laender.size() / 3;
		if (verstaerkung < 3) {
			verstaerkung = 3;
		}
	}
	
	public int getVerstaerkung() {
		return verstaerkung;
	}
	
	public int addEinheit(Land l, int e) {
		if (e > verstaerkung || l.getBesatzer() != this) return -1;
		int aktuell = l.getEinheiten();
		l.setEinheiten(aktuell + e);
		return 0;
	}
	
}

