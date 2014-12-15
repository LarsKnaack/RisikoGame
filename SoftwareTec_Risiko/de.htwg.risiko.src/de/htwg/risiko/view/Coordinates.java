package de.htwg.risiko.view;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Coordinates {
	
	private static final Point Alaska = new Point(51, 112);
	private static final Point NorthwestTerritory = new Point (120, 104);
	private static final Point Greenland = new Point(226, 55);
	private static final Point Alberta = new Point(99, 148);
	private static final Point Ontario = new Point (152, 153);
	private static final Point Quebec = new Point (216, 158);
	private static final Point WesternUS = new Point(115, 201);
	private static final Point EasternUS = new Point(169, 205);
	private static final Point CentralAmerica = new Point (145, 259);
	private static final Point Venezuela = new Point(198, 297);
	private static final Point Peru = new Point(199, 348);
	private static final Point Brazil = new Point(236, 336);
	private static final Point Argentina = new Point(211, 390);
	private static final Point NorthAfrica = new Point(316, 277);
	private static final Point Eqypt = new Point(368, 245);
	private static final Point Congo = new Point(369, 327);
	private static final Point EastAfrica = new Point(416, 308);
	private static final Point SouthAfrica = new Point(376, 388);
	private static final Point Madagascar = new Point(440, 383);
	
	private static Map<Point, String> c = new HashMap<Point, String>();
	
	public static String check(Point p) {
		c.put(Alaska, "Alaska");
		c.put(NorthwestTerritory, "NorthwestTerritory");
		c.put(Greenland, "Greenland");
		c.put(Alberta, "Alberta");
		c.put(Ontario, "Ontario");
		c.put(Quebec, "Quebec");
		c.put(WesternUS, "WesternUS");
		c.put(EasternUS, "EasternUS");
		c.put(CentralAmerica, "CentralAmerica");
		c.put(Venezuela, "Venezuela");
		c.put(Peru, "Peru");
		c.put(Brazil, "Brazil");
		c.put(Argentina, "Argentina");
		c.put(NorthAfrica, "NorthAfrica");
		c.put(Eqypt, "Eqypt");
		c.put(Congo, "Congo");
		c.put(EastAfrica, "EastAfrica");
		c.put(SouthAfrica, "SouthAfrica");
		c.put(Madagascar, "Madagascar");
		for(Point tmp : c.keySet()) {
			if (tmp.distance(p.getX(), p.getY()) <= 20) {
				return c.get(tmp);
			}
		}
		return null;
	}
	
	

}
