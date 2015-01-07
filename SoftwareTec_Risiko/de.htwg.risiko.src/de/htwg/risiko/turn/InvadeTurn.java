package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;
import de.htwg.risiko.model.WorldI;

public class InvadeTurn implements TurnState{
	
	private PlayerI player;
	private PlayerI opponent;
	private CountryI invadingCountry;
	private CountryI defendingCountry;
	
	int maxDefDice = 0;
	int maxInvDice = 0;
	
	private static final int MAX_RECRUITMENT = 3;
	private Die dice = new Die();
	
	
	@Override
	public void pull (Turn turn) {
		if (turn.hasFinished()) {
			turn.startTurn();
			turn.setState(new RecruitmentTurn());
			turn.initRecruitment();
			return;
		}
		player = turn.getPlayer();
		opponent = turn.getOpponent();
		invadingCountry = turn.getInvader();
		defendingCountry = turn.getDefender();


		if (winner().equals(invadingCountry) && defendingCountry.getSoldiers() == 0) {
			System.out.printf("%s conquered %s!\n", player.getName(), defendingCountry.getName());
			player.addCountry(defendingCountry);
			opponent.removeCountry(defendingCountry);
			invadingCountry.setSoldiers(invadingCountry.getSoldiers() - maxInvDice);
			defendingCountry.setSoldiers(maxInvDice);
		}
	}

	void setMaxDice() {
		maxInvDice = MAX_RECRUITMENT;
		if(invadingCountry.getSoldiers() <= MAX_RECRUITMENT) {
				maxInvDice = invadingCountry.getSoldiers() - 1;
			}			
		maxDefDice = 2;
		if(defendingCountry.getSoldiers() < 2) {
			maxDefDice = defendingCountry.getSoldiers();
		}
	}

	private void invade() {
		setMaxDice();
		if (maxInvDice < 1) {
			throw new IllegalArgumentException("Not enough Soldiers in Invader");
		}
		int[] invaderDice = new int[maxInvDice];
		int[] defenderDice = new int[maxDefDice];
		dice.roll(invaderDice);
		dice.roll(defenderDice);

		for (int i = 0; i < defenderDice.length; i++) {
			
			int a = max(invaderDice);
			int d = max(defenderDice);

			System.out.printf("%d - %d\n", invaderDice[a], defenderDice[d]);

			if (invaderDice[a] > defenderDice[d]) {
				maxDefDice--;
				defendingCountry.setSoldiers(defendingCountry.getSoldiers() - 1);
	            if (maxInvDice == 1) {
	                return;
	            }
			} else {
				invadingCountry.setSoldiers(invadingCountry.getSoldiers() - 1);
				maxInvDice--;
	            if (maxInvDice == 0) {
	                return;
	            }
			}
			invaderDice[a] = 0;
			defenderDice[d] = 0;
		}
	}
	
	public CountryI winner() {
		invade();
		if (maxDefDice <= 0) {
			System.out.println("Invader wins");
			return invadingCountry;
		} else {
			//System.out.println("defender wins");
			return defendingCountry;
		}
	}
	
	private int max(int[] a) {
		int max = a[0];
		int res = 0;
		for (int i = 0; i < a.length; i++){
			if (a[i] > max) {
				max = a[i];
				res = i;
			}
		}
		return res;
	}
	
	public void setDie(Die d) {
		dice = d;
	}
}
