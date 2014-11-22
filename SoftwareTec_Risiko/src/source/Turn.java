package source;

import java.util.Random;


public class Turn {

	private int maxDefDice = 0;
	private int maxInvDice = 0;
	
	private int dice() {
		return (int) (Math.random() * 6 + 1); 
	}
	
	public Player invadeTurn(Country inv, Country def) {
		setMaxDice(inv);
		setMaxDice(def);
		int[] invaderDices = new int[maxInvDice];
		int[] defenderDices = new int[maxDefDice];
		
		
		for(int i = 0; i < defenderDices.length; i++) {
			if (maxDefDice == 0) break;
			defenderDices[i] = dice();
			
		}
		
		for(int i = 0; i < invaderDices.length; i++) {
			if (maxInvDice == 1) break;
			invaderDices[i] = dice();
		}

		for (int i = 0; i <= maxInvDice; i++) {
			int a = max(invaderDices);
			int d = max(defenderDices);
			if (def.getSoldiers() == 0 || inv.getSoldiers() == 0) break;
			if (invaderDices[a] > defenderDices[d]) {
				def.setSoldiers(def.getSoldiers() - 1);
				maxDefDice--;
			} else {
				inv.setSoldiers(inv.getSoldiers() - 1);
				maxInvDice--;
			}
			invaderDices[a] = 0;
			defenderDices[d] = 0;
		}
		
		Player winner;
		if (maxInvDice == 1) {
			winner = def.getOccupying();
		} else {
			winner = inv.getOccupying();
		}
		return winner;
	}
	
	public int setMaxDice(Country l) {
		if (l.isInvader()) {
			maxInvDice = 3;
			if(l.getSoldiers() < 3) {
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
