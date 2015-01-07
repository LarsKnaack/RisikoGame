package de.htwg.risiko.model.impl;

import java.awt.Point;

import de.htwg.risiko.model.CountryI;

public class Country implements CountryI {
	
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
	
}
