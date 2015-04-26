package de.htwg.risiko.model.impl;

import java.awt.Point;

import de.htwg.risiko.model.ICountry;

public class Country implements ICountry {
	
	private int soldiers;
	private String name;
	private Point location;

	public Country(String n) {
		soldiers = 0;
		name = n;
		location = new Point();
	}
	
	public Country(String n, Point p) {
		soldiers = 0;
		name = n;
		location = p;
	}
	
	public void setLocation(Point p) {
		location = p;
	}
	
	public Point getLocation() {
		return location;
	}
	
	@Override
	public int getSoldiers() {
		return soldiers;
	}
	
	@Override
	public void setSoldiers(int e) {
		soldiers = e;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String n) {
		name = n;
	}
	
	@Override
	public String toString() {
		return name;
	}


	@Override
	public int compareTo(ICountry o) {
		return this.name.compareTo(o.getName());
	}
}
