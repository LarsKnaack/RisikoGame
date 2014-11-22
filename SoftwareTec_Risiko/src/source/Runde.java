package source;

import java.util.Random;


public class Runde {

	private int devWuerfel = 0;
	private int angWuerfel = 0;
	
	private int wuerfel() {
		return (int) (Math.random() * 6 + 1); 
	}
	
	public Spieler wuerfeln(Land ang, Land dev) {
		setWuerfel(ang);
		setWuerfel(dev);
		int[] angreifer = new int[angWuerfel];
		int[] verteidiger = new int[devWuerfel];
		
		
		for(int i = 0; i < verteidiger.length; i++) {
			if (devWuerfel == 0) break;
			verteidiger[i] = wuerfel();
			
		}
		
		for(int i = 0; i < angreifer.length; i++) {
			if (angWuerfel == 1) break;
			angreifer[i] = wuerfel();
		}

		for (int i = 0; i <= angWuerfel; i++) {
			int a = max(angreifer);
			int d = max(verteidiger);
			if (dev.getEinheiten() == 0 || ang.getEinheiten() == 0) break;
			if (angreifer[a] > verteidiger[d]) {
				dev.setEinheiten(dev.getEinheiten() - 1);
				devWuerfel--;
			} else {
				ang.setEinheiten(ang.getEinheiten() - 1);
				angWuerfel--;
			}
			angreifer[a] = 0;
			verteidiger[d] = 0;
		}
		
		Spieler gewinner;
		if (angWuerfel == 1) {
			gewinner = dev.getBesatzer();
		} else {
			gewinner = ang.getBesatzer();
		}
		return gewinner;
	}
	
	public int setWuerfel(Land l) {
		if (l.istAngreifer()) {
			angWuerfel = 3;
			if(l.getEinheiten() < 3) {
				angWuerfel = l.getEinheiten();
			}
			return angWuerfel;
		} else {
			devWuerfel = 2;
			if(l.getEinheiten() < 2) {
				devWuerfel = l.getEinheiten();
			}
			return devWuerfel;
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
