package entities;

public class Country {
	
	private int soldiers;
	private String name;

	public Country(String n) {
		soldiers = 0;
		name = n;
	}
	
	public int getSoldiers() {
		return soldiers;
	}
	
	public void setSoldiers(int e) {
		soldiers = e;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}
}
