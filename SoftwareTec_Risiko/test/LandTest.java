import static org.junit.Assert.*;

import java.awt.Color;

import junit.framework.TestCase;

import org.junit.Test;

import  source.Land;
import source.Spieler;

public class LandTest extends TestCase {
	
	public void testGetAnzahlEinheiten() {
		Land test = new Land("test");
		test.setEinheiten(5);
		assertTrue(test.getEinheiten() == 5);
	}
	
	public void testSetEinheiten() {
		Land test = new Land("test");
		test.setEinheiten(5);
		assertTrue(test.getEinheiten() == 5);
	}
	
	public void testGetBesatzer() {
		Land test = new Land("test");
		Spieler s3 = new Spieler("s3", Color.GREEN);
		test.setBesatzer(s3);
		assertTrue(test.getBesatzer() == s3);
	}
	
	public void testSetBesatzer() {
		Land test = new Land("test");
		Spieler s3 = new Spieler("s3", Color.GREEN);
		test.setBesatzer(s3);
		assertTrue(test.getBesatzer() == s3);
	}
	
	public static void main(final String[] args) {
		junit.textui.TestRunner.run(LandTest.class);
	}
}
