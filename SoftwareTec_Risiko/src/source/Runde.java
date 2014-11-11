package source;

public class Runde {

	int devWuerfel = setWuerfel(ang);
	int angWuerfel = setWuerfel(dev);
	
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
	
	private void setWuerfel(Land ang, Land dev) {
		if (dev.getEinheiten() >= 2) {
			devWuerfel = 2;
		} else {
			devWuerfel = dev.getEinheiten();
		}
		
		if (ang.getEinheiten() >= 3) {
			angWuerfel = 3;
		} else {
			angWuerfel = ang.getEinheiten();
		}
	}
}
