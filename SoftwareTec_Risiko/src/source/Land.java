package source;

public class Land {
	
	private int einheiten;
	private Spieler besatzer;
	private String name;

	public int getEinheiten() {
		return einheiten;
	}
	
	public void setEinheiten(int e) {
		einheiten = e;
	}
	
	public Spieler getBesatzer() {
		return besatzer;
	}
	
	public void setBesatzer(Spieler s) {
		besatzer = s;
	}
	
	public Land(String n) {
		einheiten = 0;
		besatzer = null;
		name = n;
	}
}
