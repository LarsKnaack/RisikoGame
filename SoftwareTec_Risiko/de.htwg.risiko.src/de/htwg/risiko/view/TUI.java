package de.htwg.risiko.view;

import static java.lang.System.*;

import java.util.Scanner;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.controller.impl.GameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;

public class TUI {

	private static final Scanner INSERT = new Scanner(in);
	
	public static void main(final String[] args) {
		IGameEngine ge = new GameEngine();
		out.println("Wanna play?");
        while (INSERT.hasNext()) {
        	if (INSERT.next().equals("yes")) {
        		break;
        	} else {
        		ge.exit();
        	}
        }
        out.println("okay");
		ge.createMap();
		ge.setCurrentPlayer();
		ge.startGame();

		for (Country c : ge.getWorld().getWorld().keySet()) {
			out.printf("%s: %s %d\n", c.getName(), ge.getOwner(c).getName(), ge.getSoldiers(c));
		}

		out.println("\nselect attacker");
		while (INSERT.hasNext()) {
        	if (INSERT.next().equals(ge.getCountries(ge.getCurrentPlayer()).get(0).getName())) {
        		ge.selectAttacker(ge.getCountries(ge.getCurrentPlayer()).get(0));
        		break;
        	} else {
        		out.println("nope");
        	}
        }
		out.println("\nselect target");
		while (INSERT.hasNext()) {
        	if (INSERT.next().equals(ge.getCountries(ge.getOpponent()).get(0).getName())) {
        		ge.selectTarget(ge.getCountries(ge.getOpponent()).get(0));
        		break;
        	} else {
        		out.println("nope");
        	}
        }
		ge.invade();
		ge.endTurn();
		ge.invade();
		
		for (Country c : ge.getWorld().getWorld().keySet()) {
			out.printf("%s: %s %d\n", c.getName(), ge.getOwner(c).getName(), ge.getSoldiers(c));
		}
		
		out.println("\nselect recruitment");
		while (INSERT.hasNext()) {
        	if (INSERT.next().equals(ge.getCountries(ge.getCurrentPlayer()).get(1).getName())) {
        		ge.selectRecruitment(ge.getCountries(ge.getCurrentPlayer()).get(1), 3);
        		break;
        	} else {
        		out.println("nope");
        	}
        }
		ge.recruit();
		ge.recruit();

//		out.println(ge.world.toString());

		for (Country c : ge.getWorld().getWorld().keySet()) {
			out.printf("%s: %s %d\n", c.getName(), ge.getOwner(c).getName(), ge.getSoldiers(c));
		}
/*
		for (CountryI c : ge.getCountries(ge.player1)) {
			out.printf("%s: %d\n", c.getName(), c.getSoldiers());
		}*/

		ge.changePlayer();
	}
}
