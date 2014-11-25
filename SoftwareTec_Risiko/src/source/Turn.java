package source;

import java.util.Random;

public class Turn {

	private int maxDefDice = 0;
	private int maxInvDice = 0;
	
	private int[] invaderDice;
	private int[] defenderDice;
	
	private static final int UPPER = 6;
	private static final int MAX_RECRUITMENT = 3;
	public Random rand = new Random();
	
	private int dice(Random r) {
		return r.nextInt(UPPER) + 1;
	}
	
	private void roll(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = dice(rand);
		}
	}
	
	public int setMaxDice(Country l) {
		if (l.isInvader()) {
			maxInvDice = MAX_RECRUITMENT;
			if(l.getSoldiers() < MAX_RECRUITMENT) {
				maxInvDice = l.getSoldiers();
			}
			return maxInvDice;
		} else {
			maxDefDice = 2;
			if(l.getSoldiers() < 2) {
				maxDefDice = l.getSoldiers();
			}
			return maxDefDice;
		}
	}
	
	public Player invadeTurn(Country inv, Country def) {
		setMaxDice(inv);
		setMaxDice(def);
		

		invade(inv, def);
		
		Player winner;
		if (maxInvDice == 1) {
			winner = def.getOccupying();
		} else {
			winner = inv.getOccupying();
		}
		return winner;
	}

	private void invade(Country invader, Country defender) {
		invaderDice = new int[maxInvDice];
		defenderDice = new int[maxDefDice];
		roll(invaderDice);
		roll(defenderDice);
		for (int i = 0; i < invaderDice.length; i++) {
			
			int a = max(invaderDice);
			int d = max(defenderDice);

			if (invaderDice[a] > defenderDice[d]) {
				defender.setSoldiers(defender.getSoldiers() - 1);
				maxDefDice--;
			} else {
				invader.setSoldiers(invader.getSoldiers() - 1);
				maxInvDice--;
			}
			invaderDice[a] = 0;
			defenderDice[d] = 0;
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
}
