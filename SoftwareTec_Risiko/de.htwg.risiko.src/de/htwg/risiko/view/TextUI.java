package de.htwg.risiko.view;


import java.util.Scanner;
import org.apache.log4j.Logger;
import com.google.inject.Inject;

import static java.lang.System.out;
import de.htwg.risiko.controller.IGameEngine;
import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.impl.Country;
import de.htwg.risiko.util.observer.IObserver;

@SuppressWarnings("unused")
public class TextUI implements IObserver {

	private IGameEngine ge;
	
	private int num = 0;
	private CountryI rec;
	private char mode = 0;
	private Logger logger = Logger.getLogger("de.htwg.risiko.view");
	
	private static final int LENGTH = 30;

	@Inject
	public TextUI(IGameEngine controller) {
		ge = controller;
		controller.addObserver(this);
	}

	@Override
	public void update() {
		printTUI();
	}

	public void printTUI() {
		logger.info("\n["+ge.getCurrentPlayer().getName()+"]\n");
		logger.info("-----------------------------------------------------------------------");
		logger.info(">>>"+ge.getStatus());
		logger.info("-----------------------------------------------------------------------\n");
		for (CountryI c : ge.getWorld().getWorld().keySet()) {
			String s1 = c.getName();
			String s2 = ge.getOwner(c).getName();
			int s3 =  ge.getSoldiers(c);
			int p1 = LENGTH - s1.length();
			int p2 = LENGTH;
			logger.info(String.format("%s:%"+p1+"s%"+p2+"d\n", s1, s2, s3));
		}
		logger.info("\n_______________________________________________________________________\n");
		logger.info("q:     quit              country1, country2:     attack\nn:     new game          country, x:             recruit\ne:     end turn          country:                show candidates");
		logger.info("_______________________________________________________________________\n");
	}

	public boolean processInputLine(String line) {
		boolean continu = true;

		switch (line) {
		case "q":
			logger.info("Are you sure? (y/n)");
			Scanner scan1 = new Scanner(System.in);
			if (scan1.next().equals("y")) {
				System.exit(0);
			}
			break;
		case "n":
			logger.info("Player1, please enter your name:");
			Scanner scanner = new Scanner(System.in);
			ge.getOpponent().setName(scanner.nextLine());
			logger.info("Player2, please enter your name:");

			ge.getCurrentPlayer().setName(scanner.nextLine());
			ge.createMap();
			ge.startGame();
			return continu;
		case "e":
			ge.endTurn();
			return continu;
		}

		continu = checkAttackerTarget(line, continu);

		if (line.matches("[A-Za-z ]+[,][ ][1-99]")) {
			int rFlag = 0;
			if (!ge.getStatus().contains("now select recruitment")) {
				logger.info("You have to end your turn first before you can recruit!");
				return continu;
			}
			String arg[] = line.split(", ");
			for (CountryI c : ge.getWorld().getWorld().keySet()) {
				if (arg[0].equals(c.getName())) {
					rFlag++;
					if (!ge.selectRecruitment(c, Integer.parseInt(arg[1]))) {
						logger.info("Recruitment is invalid!");
					    return continu;
					}
					break;
				}
			}
			if (rFlag > 0) {
				ge.recruit();
			} else {
				logger.info("Country is invalid!");
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
			logger.info("Country is invalid!");
		}

		if (line.matches("[A-Za-z ]+[,][ ][A-Za-z ]+[,][ ][1-99]")) {
			int sFlag = 0;
			int tFlag = 0;
			CountryI source = new Country("");
			CountryI target = new Country("");
			if (ge.getStatus().contains("now select recruitment")) {
				logger.info("You already finished your turn!");
				return continu;
			}
			String arg[] = line.split(", ");
			for (CountryI c : ge.getCountries(ge.getCurrentPlayer())) {
				if (arg[0].equals(c.getName())) {
					source = c;
					sFlag++;
					for (CountryI c1 : ge.getNeighbours(c)) {
						if (arg[1].equals(c1.getName())) {
							target = c1;
							tFlag++;
						}
					}
					break;
				}
			}

			if (sFlag < 1) {
				logger.info("Invalid source country!");
			} else if (tFlag < 1) {
				logger.info("Invalid target country!");
			} else {
				ge.moveSoldiers(Integer.parseInt(arg[2]), source, target);
			}

			continu = checkAttackerTarget(line, continu);
		}
		return continu;
	}

	private boolean checkAttackerTarget(String line, boolean continu) {
		if (line.matches("[A-Za-z ]+[,][ ][A-Za-z ]+")) {
			int aFlag = 0;
			int tFlag = 0;
			if (ge.getStatus().contains("now select recruitment")) {
				logger.info("You already finished your turn!");
				return continu;
			}
			String arg[] = line.split(", ");
			for (CountryI c : ge.getWorld().getWorld().keySet()) {
				if (arg[0].equals(c.getName())) {
					aFlag++;
					if (!ge.selectAttacker(c)) {
						logger.info(String.format("Attacker %s is invalid!\n", c.getName()));
						return continu;	    
					}
					for (CountryI c1 : ge.getCandidates(c)) {
						if (arg[1].equals(c1.getName())) {
							tFlag++;
							if (!ge.selectTarget(c1)) {
								logger.info(String.format("Target %s is invalid!\n", c1.getName()));
							    return continu;
							}
						}
					}
					break;
				}
			}

			if (aFlag < 1) {
				logger.info("No such attacking country!");
			} else if (tFlag < 1) {
				logger.info("No such target country!");
			} else {
				ge.invade();
			}
			if(ge.getOpponent().getCountries().isEmpty()) {
				logger.info("\nCongratulations, " + ge.getCurrentPlayer().getName() + " has won!");
				return false;
			}
		}
		return continu;
	}
}
