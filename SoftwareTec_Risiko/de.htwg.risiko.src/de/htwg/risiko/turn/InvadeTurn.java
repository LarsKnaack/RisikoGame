package de.htwg.risiko.turn;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.PlayerI;

public class InvadeTurn implements TurnState{
	
	private PlayerI opponent;
	private CountryI invadingCountry;
	private CountryI defendingCountry;
	private StringBuilder sb;
	
	private int maxDefDice = 0;
	private int maxInvDice = 0;
	
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
		PlayerI player = turn.getPlayer();
		opponent = turn.getOpponent();
		invadingCountry = turn.getInvader();
		defendingCountry = turn.getDefender();
		sb = new StringBuilder();

		if (winner().equals(invadingCountry) && defendingCountry.getSoldiers() == 0) {
			sb.append(String.format("%s conquered %s!\n", player.getName(), defendingCountry.getName()));
			player.addCountry(defendingCountry);
			opponent.removeCountry(defendingCountry);
			invadingCountry.setSoldiers(invadingCountry.getSoldiers() - maxInvDice);
			defendingCountry.setSoldiers(maxInvDice);
		}
		turn.setStatus(sb.toString());
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

		int[] invaderDice = new int[maxInvDice];
		int[] defenderDice = new int[maxDefDice];
		dice.roll(invaderDice);
		dice.roll(defenderDice);

		for (int i = 0; i < defenderDice.length && i < invaderDice.length; i++) {
			
			int a = max(invaderDice);
			int d = max(defenderDice);

			sb.append(String.format("%d - %d\n", invaderDice[a], defenderDice[d]));

			if (invaderDice[a] > defenderDice[d]) {
				maxDefDice--;
				defendingCountry.setSoldiers(defendingCountry.getSoldiers() - 1);
			} else {
				invadingCountry.setSoldiers(invadingCountry.getSoldiers() - 1);
				maxInvDice--;
			}
			invaderDice[a] = 0;
			defenderDice[d] = 0;
		}
	}
	
	public CountryI winner() {
		invade();
		if (maxDefDice <= 0) {
			sb.append("Invader wins\n");
			return invadingCountry;
		} else {
			sb.append(String.format("%s has successfully defended %s!\n", opponent.getName(), defendingCountry.getName()));
			return defendingCountry;
		}
	}
	
	private int max(int[] a) {
		int max = 0;
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
