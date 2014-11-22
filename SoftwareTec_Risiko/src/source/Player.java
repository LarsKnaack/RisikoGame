package source;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class Player {
	private List<Country> countries;
	private String name;
	private Color color;
	private int recruitment;
	private int MAXRECRUITMENT = 3;
	
	public Player(String n, Color f) {
		name = n;
		setColor(f);
		recruitment = 0;
		countries = new LinkedList<Country>();
	}
	
	public void addCountry(Country l){
		countries.add(l);
		l.setOccupying(this);
	}
	
	public void removeCountry(Country l){
		countries.remove(l);
		l.setOccupying(null);
	}
	
	public List<Country> getCountries(){
		return  countries;
	}
	
	public String getName() {
		return name;
	}
	
	public void setRecruitment() {
		recruitment = countries.size() / MAXRECRUITMENT;
		if (recruitment < MAXRECRUITMENT) {
			recruitment = MAXRECRUITMENT;
		}
	}
	
	public int getRecruitment() {
		return recruitment;
	}
	
	public int addSoldier(Country l, int e) {
		if (e > recruitment || l.getOccupying() != this){
			return -1;
		}
		int aktuell = l.getSoldiers();
		l.setSoldiers(aktuell + e);
		return 0;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color c) {
		color = c;
	}
	
}

