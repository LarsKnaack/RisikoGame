import static org.junit.Assert.*;
import org.junit.Test;


public class LandTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public int testGetAnzahlEinheiten() {
		Land.setEinheiten(5);
		assertTrue(Land.getEinheiten() == 5);
	}
	
	public void testSetEinheiten(int einheiten) {
		Land.setEinheiten(einheiten);
		assertTrue(Land.getEinheiten() == einheiten);
	}
	
	public void testGetBesatzer() {
		Spieler s3 = new Spieler();
		Land.setBesatzer(s3);
		assertTrue(Land.getEinheiten() == s3);
	}
	
	public void testSetBesatzer(Spieler s) {
		Land.setBesatzer(s);
		assertTrue(Land.getBesatzer() == s);
	}
}
