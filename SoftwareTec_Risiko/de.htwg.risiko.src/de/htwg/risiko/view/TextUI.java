package de.htwg.risiko.view;


import java.util.Scanner;

import static java.lang.System.out;

import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.util.observer.Event;
import de.htwg.risiko.util.observer.IObserver;

public class TextUI implements IObserver {

	IGameEngine ge;
	int num = 0;
	CountryI rec;
	char mode = 0;

	public TextUI(IGameEngine controller) {
		ge = controller;
		controller.addObserver(this);
	}

	@Override
	public void update(Event e) {
		printTUI();
	}

	public void printTUI() {
		out.println("\n["+ge.getCurrentPlayer().getName()+"]\n");
		out.println("-----------------------------------------------------------------------");
		out.println(">>>"+ge.getStatus());
		out.println("-----------------------------------------------------------------------\n");
		for (Country c : ge.getWorld().getWorld().keySet()) {
			String s1 = c.getName();
			String s2 = ge.getOwner(c).getName();
			int s3 =  ge.getSoldiers(c);
			int p1 = 30 - s1.length();
			int p2 = 30;
			out.printf("%s:%"+p1+"s%"+p2+"d\n", s1, s2, s3);
		}
		out.println("\n_______________________________________________________________________\n");
		out.println("q:     quit              country1, country2:     attack\nn:     new game          country, x:             recruit\ne:     end turn          country:                show candidates");
		out.println("_______________________________________________________________________\n");
	}

	public boolean processInputLine(String line) {
		boolean continu = true;

		switch (line) {
		case "q":
			out.println("Are you sure? (y/n)");
			Scanner scan1 = new Scanner(System.in);
			if (scan1.next().equals("y")) {
				ge.exit();
			}
			break;
		case "n":
			out.println("Player1, please enter your name:");
			Scanner scanner = new Scanner(System.in);
			ge.getOpponent().setName(scanner.nextLine());
			out.println("Player2, please enter your name:");

			ge.getCurrentPlayer().setName(scanner.nextLine());
			ge.createMap(1);
			ge.startGame();
			return continu;
		case "e":
			ge.endTurn();
			return continu;
		}

		if (line.matches("[A-Za-z ]+[,][ ][A-Za-z ]+")) {
			int aFlag = 0;
			int tFlag = 0;
			if (ge.getStatus().contains("now select recruitment")) {
				out.println("You already finished your turn!");
				return continu;
			}
			String arg[] = line.split(", ");
			for (CountryI c : ge.getWorld().getWorld().keySet()) {
				if (arg[0].equals(c.getName())) {
					aFlag++;
					if (!ge.selectAttacker(c)) {
						out.printf("Attacker %s is invalid!\n", c.getName());
						return continu;	    
					}
					for (CountryI c1 : ge.getCandidates(c)) {
						if (arg[1].equals(c1.getName())) {
							tFlag++;
							if (!ge.selectTarget(c1)) {
								out.printf("Target %s is invalid!\n", c1.getName());
							    return continu;
							}
						}
					}
					break;
				}
			}

			if (aFlag < 1) {
				out.println("No such attacking country!");
			} else if (tFlag < 1) {
				out.println("No such target country!");
			} else {
				ge.invade();
			}
			if(ge.getOpponent().getCountries().isEmpty()) {
				out.println("\nCongratulations, " + ge.getCurrentPlayer().getName() + " has won!");
				continu = false;
			}
		}

		if (line.matches("[A-Za-z ]+[,][ ][1-99]")) {
			int rFlag = 0;
			if (!ge.getStatus().contains("now select recruitment")) {
				out.println("You have to end your turn first before you can recruit!");
				return continu;
			}
			String arg[] = line.split(", ");
			for (CountryI c : ge.getWorld().getWorld().keySet()) {
				if (arg[0].equals(c.getName())) {
					rFlag++;
					if (!ge.selectRecruitment(c, Integer.parseInt(arg[1]))) {
						out.println("Recruitment is invalid!");
					    return continu;
					}
					break;
				}
			}
			if (rFlag > 0) {
				ge.recruit();
			} else {
				out.println("Country is invalid!");
			}

			if (ge.getMaxRecruitment() == 0) {
				ge.changePlayer();
				mode = '0';
			}
		}

		if (line.matches("[A-Za-z ]+")) {
			for (CountryI c : ge.getWorld().getWorld().keySet()) {
				if (line.equals(c.getName())) {
					out.println(ge.getCandidates(c));
					return continu;
				}
			}
			out.println("Country is invalid!");
		}
		return continu;
	}
}
