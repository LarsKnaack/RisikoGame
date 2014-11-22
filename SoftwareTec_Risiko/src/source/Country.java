package source;

public class Country {
	
	private int soldiers;
	private Player occupying;
	private String name;
	private boolean invader;
	private boolean defender;

	public int getSoldiers() {
		return soldiers;
	}
	
	public void setSoldiers(int e) {
		soldiers = e;
	}
	
	public Player getOccupying() {
		return occupying;
	}
	
	public void setOccupying(Player s) {
		occupying = s;
	}
	
	public Country(String n) {
		soldiers = 0;
		occupying = null;
		name = n;
	}
	
	public void setInvader(boolean ang) {
		invader = ang;
	}
	
	public void setDefender(boolean dev) {
		defender = dev;
	}
	
	public boolean isInvader() {
		return invader;
	}
	
	public boolean isDefender() {
		return defender;
	}
}
