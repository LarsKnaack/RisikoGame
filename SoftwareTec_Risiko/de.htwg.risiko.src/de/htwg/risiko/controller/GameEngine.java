package de.htwg.risiko.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.model.impl.Player;
import de.htwg.risiko.model.impl.World;

public class GameEngine {
	
	public static WorldI world = new World();
	public static PlayerI player1 = new Player("Hans");
	public static PlayerI player2 = new Player("Herbert");
	
	private Map<Country, Player> occupying;
	
	
	public GameEngine() {
		occupying = new HashMap<Country, Player>();
	}

	public PlayerI getOccupying(CountryI c) {
		return occupying.get(c);
	}
	
	public void setOccupying(Country c, Player p) {
		occupying.put(c, p);
	}

	
	public List<Country> getCountries(PlayerI p){
		List<Country> res = new LinkedList<Country>();
		for (Country c: occupying.keySet()) {
			if(occupying.get(c).equals(p)) {
				res.add(c);
			}
		}
		return  res;
	}

}
