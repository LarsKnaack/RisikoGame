package test_source;
import static org.junit.Assert.*;
import java.awt.Color;
import junit.framework.TestCase;
import org.junit.Test;
import source.Spieler;
import source.Land;
import source.Runde;


public class RundeTest extends TestCase {

	public void testWuerfeln() {
		Runde r = new Runde();
		Land ang = new Land("Angreifer");
		Land dev = new Land("Verteidiger");
		Spieler s1 = new Spieler("s1", Color.BLACK);
		Spieler s2 = new Spieler("s2", Color.BLUE);
		ang.setBesatzer(s1);
		dev.setBesatzer(s2);
		ang.setAngreifer(true);
		dev.setVerteidiger(true);
		Spieler gewinner = r.wuerfeln(ang, dev);
		assertTrue(gewinner == s1 || gewinner == s2);
	}
	
	public void testSetWuerfelAngreifer() {
		Runde test = new Runde();
		Land ang = new Land("Angreifer");
		ang.setAngreifer(true);
		ang.setEinheiten(5);
		assertEquals(test.setWuerfel(ang), 3);
		ang.setEinheiten(2);
		assertEquals(test.setWuerfel(ang), 2);
	}
	
	public void testSetWuerfelVerteidiger() {
		Runde test = new Runde();
		Land dev = new Land("Verteidiger");
		dev.setVerteidiger(true);
		dev.setEinheiten(4);
		assertEquals(test.setWuerfel(dev), 2);
		dev.setEinheiten(1);
		assertEquals(test.setWuerfel(dev), 1);
	}

}
