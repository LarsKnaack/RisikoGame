package de.htwg.risiko.view;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Coordinates {
	
	private static final Point ALASKA = new Point(51, 112);
	private static final Point NORTHWEST_TERRITORY = new Point (120, 104);
	private static final Point GREENLAND = new Point(226, 55);
	private static final Point ALBERTA = new Point(99, 148);
	private static final Point ONTARIO = new Point (152, 153);
	private static final Point QUEBEC = new Point (216, 158);
	private static final Point WESTERN_US = new Point(115, 201);
	private static final Point EASTERN_US = new Point(169, 205);
	private static final Point CENTRAL_US = new Point (145, 259);
	private static final Point VENEZUELA = new Point(198, 297);
	private static final Point PERU = new Point(199, 348);
	private static final Point BRAZIL = new Point(236, 336);
	private static final Point ARGENTINA = new Point(211, 390);
	private static final Point NORTH_AFRICA = new Point(316, 277);
	private static final Point EGYPT = new Point(368, 245);
	private static final Point CONGO = new Point(369, 327);
	private static final Point EAST_AFRICA = new Point(416, 308);
	private static final Point SOUTH_AFRICA = new Point(376, 388);
	private static final Point MADAGASCAR = new Point(440, 383);
	private static final Point ICELAND = new Point(269, 103);
	private static final Point GREAT_BRITAIN = new Point(294, 132);
	private static final Point NORTHERN_EUROPE = new Point(361, 140);
	private static final Point SOUTERN_EUROPE = new Point(379, 175);
	private static final Point SCANDINAVIA = new Point(368, 90);
	private static final Point UKRAINE = new Point(436, 135);
	private static final Point MIDDLE_EAST = new Point(442, 242);
	private static final Point INDIA = new Point(510, 263);
	private static final Point SIAM = new Point(568, 270);
	private static final Point AFGHANISTAN = new Point(493, 186);
	private static final Point CHINA = new Point(563, 218);
	private static final Point MONGOLIA = new Point(603, 170);
	private static final Point JAPAN = new Point(658, 195);
	private static final Point KAMCHATKA = new Point(639, 111);
	private static final Point IRKTUSK = new Point(596, 133);
	private static final Point YAKTUSK = new Point(602, 82);
	private static final Point SIBERIA = new Point(550, 106);
	private static final Point URAL = new Point(497, 114);
	private static final Point INDONESIA = new Point(592, 328);
	private static final Point NEW_GUINEA = new Point(661, 329);
	private static final Point WESTERN_AUSTRALIA = new Point(605, 409);
	private static final Point EASTERN_AUSTRALIA = new Point(661, 416); 
	
	private static Map<Point, String> c = new HashMap<Point, String>();
	
	public static void setCoordinates() {
		c.put(ALASKA, "Alaska");
		c.put(NORTHWEST_TERRITORY, "Northwest Territory");
		c.put(GREENLAND, "Greenland");
		c.put(ALBERTA, "Alberta");
		c.put(ONTARIO, "Ontario");
		c.put(QUEBEC, "Quebec");
		c.put(WESTERN_US, "Western US");
		c.put(EASTERN_US, "Eastern US");
		c.put(CENTRAL_US, "Central America");
		c.put(VENEZUELA, "Venezuela");
		c.put(PERU, "Peru");
		c.put(BRAZIL, "Brazil");
		c.put(ARGENTINA, "Argentina");
		c.put(NORTH_AFRICA, "North Africa");
		c.put(EGYPT, "Eqypt");
		c.put(CONGO, "Congo");
		c.put(EAST_AFRICA, "East Africa");
		c.put(SOUTH_AFRICA, "South Africa");
		c.put(MADAGASCAR, "Madagascar");
		c.put(ICELAND, "Iceland");
		c.put(GREAT_BRITAIN, "Great Britain");
		c.put(NORTHERN_EUROPE, "Northern Europe");
		c.put(SOUTERN_EUROPE, "Southern Europe");
		c.put(SCANDINAVIA, "Scandinavia");
		c.put(UKRAINE, "Ukraine");
		c.put(MIDDLE_EAST, "Middle East");
		c.put(INDIA, "India");
		c.put(SIAM, "Siam");
		c.put(AFGHANISTAN, "Afghanistan");
		c.put(CHINA, "China");
		c.put(MONGOLIA, "Mongolia");
		c.put(JAPAN, "Japan");
		c.put(KAMCHATKA, "Kamchatka");
		c.put(IRKTUSK, "Irktusk");
		c.put(YAKTUSK, "Yaktusk");
		c.put(SIBERIA, "Siberia");
		c.put(URAL, "Ural");
		c.put(INDONESIA, "Indonesia");
		c.put(NEW_GUINEA, "New Guinea");
		c.put(WESTERN_AUSTRALIA, "Western Australia");
		c.put(EASTERN_AUSTRALIA, "Eastern Australia");
	}
	
	public static List<String> getCountries() {
		List<String> res = new LinkedList<String>();
		res.addAll(c.values());
		return res;
	}
	
	public static String check(Point p) {
		
		for(Point tmp : c.keySet()) {
			if (tmp.distance(p.getX(), p.getY()) <= 20) {
				return c.get(tmp);
			}
		}
		return null;
	}
	
	

}
