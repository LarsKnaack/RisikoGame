package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import world.World;
import entities.Country;
import entities.Player;

public class GameEngine {
	
	private Map<Country, Player> occupying;
	
	
	public GameEngine() {
		occupying = new HashMap<Country, Player>();
	}

	public Player getOccupying(Country c) {
		return occupying.get(c);
	}
	
	public void setOccupying(Country c, Player p) {
		occupying.put(c, p);
	}

	
	public List<Country> getCountries(Player p){
		List<Country> res = new LinkedList<Country>();
		for (Country c: occupying.keySet()) {
			if(occupying.get(c).equals(p)) {
				res.add(c);
			}
		}
		return  res;
	}

}
