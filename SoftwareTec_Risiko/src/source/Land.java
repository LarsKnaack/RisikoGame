package source;

public class Land {
	
	private int einheiten;
	private Spieler besatzer;
	private String name;
	private boolean angreifer;
	private boolean verteidiger;

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
	
	public void setAngreifer(boolean ang) {
		angreifer = ang;
	}
	
	public void setVerteidiger(boolean dev) {
		verteidiger = dev;
	}
	
	public boolean istAngreifer() {
		return angreifer;
	}
	
	public boolean istVerteidiger() {
		return verteidiger;
	}
}
