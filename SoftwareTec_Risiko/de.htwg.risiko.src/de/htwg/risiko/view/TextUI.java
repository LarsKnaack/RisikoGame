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
		out.println(">>>"+ge.getStatus()+"<<<");
		out.println("-----------------------------------------------------------------------\n");
		for (Country c : ge.getWorld().getWorld().keySet()) {
			String s1 = c.getName();
			String s2 = ge.getOwner(c).getName();
			int s3 =  ge.getSoldiers(c);
			int p1 = 30 - s1.length();
			int p2 = 30;// - s2.length();
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
			break;
		case "e":
			ge.endTurn();
			break;
		}

		if (line.matches("[A-Za-z ]+[,][ ][A-Za-z-]+")) {
			int aFlag = 0;
			int tFlag = 0;
			if (ge.getStatus().equals("now select recruitment")) {
				out.println("You already finished your turn!");
				return continu;
			}
			String arg[] = line.split(", ");
			for (CountryI c : ge.getWorld().getWorld().keySet()) {
				if (arg[0].equals(c.getName())) {
					aFlag++;
					if (!ge.selectAttacker(c)) {
						out.println("Attacker is invalid!");
						return continu;	    
					}
				}
				if (arg[1].equals(c.getName())) {
					tFlag++;
					if (!ge.selectTarget(c)) {
						out.println("Target is invalid!");
					    return continu;
					}
				}
			}
			if (aFlag < 1) {
				out.println("Attacker is invalid!");
			} else if (tFlag < 1) {
				out.println("Target is invalid!");
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
			if (!ge.getStatus().equals("now select recruitment")) {
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
			} else {
				printTUI();
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
/*		switch (line) {
		case "q":
			continu = false;
			break;
		case "n":
			ge.createMap(1);
			ge.startGame();
			break;
		case "a":
			mode = 'a';
			break;
		case "t":
			mode = 't';
			break;
		case "r":
			mode = 'r';
			break;
		case "e":
			ge.endTurn();
			break;
		case "at":
			ge.invade();
			if(ge.getOpponent().getCountries().isEmpty()) {
				out.println("\n" + ge.getCurrentPlayer().getName() + " has won!");
				continu = false;
			}
			break;
		case "m":
			ge.recruit();
			if (ge.getMaxRecruitment() == 0) {
				ge.changePlayer();
				mode = '0';
			} else {
				printTUI();
			}
			break;
		case "num":
			mode = 'n';
			break;
		}

		if (mode == 'm') {
			mode = 'n';
			num = Integer.parseInt(line);
		}
		if (mode == 'n') {
			if (num != 0) {
				if(!ge.selectRecruitment(rec, num)) {
					mode = '0';
				}
				num = 0;
			} else {
				mode = 'm';
			}
		}

		for (CountryI c : ge.getWorld().getWorld().keySet()) {
			if (line.equals(c.getName())) {
				if (mode == 'a') {
					if(!ge.selectAttacker(c)) {
						mode = '0';
					}
				} else if (mode == 't') {
					if(!ge.selectTarget(c)) {
						mode = '0';
					}
				} else if (mode == 'r') {
					//mode = 'n';
					rec = c;
				}
*/
		//	}
		//}
		return continu;
	}
}
