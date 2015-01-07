package de.htwg.risiko.view;

import static java.lang.System.*;
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
		out.println("q:     quit\nn:     new game\na:     select attacker\nt:     select target\nat:    attack\nr:     select country for recruitment\nnum:   select number of recruitments\nm:     recruit");
		out.println("_______________________________________________________________________\n");
	}

	public boolean processInputLine(String line) {
		boolean continu = true;

		switch (line) {
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

			}
		}
		return continu;
	}
}