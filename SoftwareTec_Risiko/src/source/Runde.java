package source;

public class Runde {

	int devWuerfel;
	int angWuerfel;
	
	public Spieler wuerfeln(Land ang, Land dev) {
		
		int max = Math.max(devWuerfel, angWuerfel);
		
		
		
		
		for(int i = 0; i <= max; i++) {
			if (devWuerfel == 0 || angWuerfel == 1) break;
			int angreifer = (int) (Math.random() % 6);
			int verteidiger = (int) (Math.random() % 6);
			if (angreifer < verteidiger) {
				angWuerfel--;
			} else {
				devWuerfel--;
			}
		}
		Spieler gewinner;
		if (angWuerfel == 1) {
			gewinner = dev.getBesatzer();
		} else {
			gewinner = ang.getBesatzer();
		}
		return gewinner;
	}
	
	private int setWuerfel(Land l) {
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
}
