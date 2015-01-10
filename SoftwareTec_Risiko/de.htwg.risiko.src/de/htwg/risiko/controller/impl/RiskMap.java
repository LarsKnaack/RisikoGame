package de.htwg.risiko.controller.impl;

import java.awt.Point;

import de.htwg.risiko.model.CountryI;
import de.htwg.risiko.model.WorldI;
import de.htwg.risiko.model.impl.Country;

public class RiskMap {

	private static WorldI w;

	public static void create(WorldI world) {
		CountryI alaska = new Country("Alaska", new Point(51, 112));
		CountryI alberta = new Country("Alberta", new Point(99, 148));
		CountryI northwestTerritory = new Country("Northwest Territory", new Point (120, 104));
		CountryI ontario = new Country("Ontario", new Point (152, 153));
		CountryI westernUS = new Country("Western US", new Point(115, 201));
		CountryI easternUS = new Country("Eastern US", new Point(169, 205));
		CountryI quebec = new Country("Quebec", new Point (216, 158));
		CountryI greenland = new Country("Greenland", new Point(226, 55));
		CountryI centralAmerica = new Country("Central America", new Point (145, 259));
		CountryI venezuela = new Country("Venezuela", new Point(198, 297));
		CountryI brazil = new Country("Brazil", new Point(236, 336));
		CountryI peru= new Country("Peru", new Point(199, 348));
		CountryI argentina = new Country("Argentina", new Point(211, 390));
		CountryI iceland = new Country("Iceland", new Point(269, 103));
		CountryI greatBritain = new Country("Great Britain", new Point(294, 132));
		CountryI westernEU= new Country("Western Europe", new Point(306, 197));
		CountryI northernEU = new Country("Northern Europe", new Point(361, 140));
		CountryI southernEU = new Country("Southern Europe", new Point(379, 175));
		CountryI scandinavia = new Country("Scandinavia", new Point(368, 90));
		CountryI ukraine = new Country("Ukraine", new Point(436, 135));
		CountryI northAfrica = new Country("North Africa", new Point(316, 277));
		CountryI egypt = new Country("Egypt", new Point(368, 245));
		CountryI congo = new Country("Congo", new Point(369, 327));
		CountryI eastAfrica = new Country("East Africa", new Point(416, 308));
		CountryI southAfrica = new Country("South Africa", new Point(376, 388));
		CountryI madagascar = new Country("Madagascar", new Point(440, 383));
		CountryI ural = new Country("Ural", new Point(497, 114));
		CountryI siberia = new Country("Siberia", new Point(550, 106));
		CountryI yakutsk = new Country("Yakutsk", new Point(602, 82));
		CountryI kamchatka = new Country("Kamchatka", new Point(639, 111));
		CountryI irkutsk = new Country("Irkutsk", new Point(596, 133));
		CountryI afghanistan = new Country("Afghanistan", new Point(493, 186));
		CountryI china = new Country("China", new Point(563, 218));
		CountryI mongolia = new Country("Mongolia", new Point(603, 170));
		CountryI japan = new Country("Japan", new Point(658, 195));
		CountryI middleEast = new Country("Middle East", new Point(442, 242));
		CountryI india = new Country("India", new Point(510, 263));
		CountryI siam = new Country("Siam", new Point(568, 270));
		CountryI indonesia = new Country("Indonesia", new Point(592, 328));
		CountryI newGuinea = new Country("New Guinea", new Point(661, 329));
		CountryI westernAustralia = new Country("Western Australia", new Point(605, 409));
		CountryI easternAustralia = new Country("Eastern Australia", new Point(661, 416));
		
		world.addCountry(alaska);
		world.addCountry(alberta);
		world.addCountry(northwestTerritory);
		world.addCountry(ontario);
		world.addCountry(westernUS);
		world.addCountry(easternUS);
		world.addCountry(quebec);
		world.addCountry(greenland);
		world.addCountry(centralAmerica);
		world.addCountry(venezuela);
		world.addCountry(brazil);
		world.addCountry(peru);
		world.addCountry(argentina);
		world.addCountry(iceland);
		world.addCountry(greatBritain);
		world.addCountry(westernEU);
		world.addCountry(northernEU);
		world.addCountry(southernEU);
		world.addCountry(scandinavia);
		world.addCountry(ukraine);
		world.addCountry(northAfrica);
		world.addCountry(egypt);
		world.addCountry(congo);
		world.addCountry(eastAfrica);
		world.addCountry(southAfrica);
		world.addCountry(madagascar);
		world.addCountry(ural);
		world.addCountry(siberia);
		world.addCountry(yakutsk);
		world.addCountry(kamchatka);
		world.addCountry(irkutsk);
		world.addCountry(afghanistan);
		world.addCountry(china);
		world.addCountry(mongolia);
		world.addCountry(japan);
		world.addCountry(middleEast);
		world.addCountry(india);
		world.addCountry(siam);
		world.addCountry(indonesia);
		world.addCountry(newGuinea);
		world.addCountry(westernAustralia);
		world.addCountry(easternAustralia);
		
		world.addEdge(alaska, kamchatka);
		world.addEdge(alaska, alberta);
		world.addEdge(alaska, northwestTerritory);
		world.addEdge(alberta, northwestTerritory);
		world.addEdge(alberta, ontario);
		world.addEdge(alberta, westernUS);
		world.addEdge(brazil, argentina);
		world.addEdge(china, afghanistan);
		world.addEdge(china, mongolia);
		world.addEdge(china, siam);
		world.addEdge(china, siberia);
		world.addEdge(china, ural);
		world.addEdge(eastAfrica, congo);
		world.addEdge(eastAfrica, madagascar);
		world.addEdge(eastAfrica, middleEast);
		world.addEdge(easternAustralia, newGuinea);
		world.addEdge(easternUS, centralAmerica);
		world.addEdge(easternUS, ontario);
		world.addEdge(egypt, northAfrica);
		world.addEdge(egypt, eastAfrica);
		world.addEdge(egypt, middleEast);
		world.addEdge(greatBritain, northernEU);
		world.addEdge(greatBritain, westernEU);
		world.addEdge(iceland, greatBritain);
		world.addEdge(iceland, greenland);
		world.addEdge(india, afghanistan);
		world.addEdge(india, china);
		world.addEdge(india, siam);
		world.addEdge(indonesia, newGuinea);
		world.addEdge(indonesia, siam);
		world.addEdge(indonesia, westernAustralia);
		world.addEdge(irkutsk, kamchatka);
		world.addEdge(irkutsk, mongolia);
		world.addEdge(japan, kamchatka);
		world.addEdge(japan, mongolia);
		world.addEdge(middleEast, afghanistan);
		world.addEdge(middleEast, india);
		world.addEdge(middleEast, southernEU);
		world.addEdge(mongolia, kamchatka);
		world.addEdge(northAfrica, brazil);
		world.addEdge(northAfrica, congo);
		world.addEdge(northAfrica, eastAfrica);
		world.addEdge(northernEU, scandinavia);
		world.addEdge(northernEU, southernEU);
		world.addEdge(northernEU, westernEU);
		world.addEdge(northwestTerritory, greenland);
		world.addEdge(northwestTerritory, ontario);
		world.addEdge(northwestTerritory, quebec);
		world.addEdge(peru, argentina);
		world.addEdge(peru, brazil);
		world.addEdge(quebec, easternUS);
		world.addEdge(quebec, greenland);
		world.addEdge(quebec, ontario);
		world.addEdge(siberia, irkutsk);
		world.addEdge(siberia, mongolia);
		world.addEdge(siberia, ural);
		world.addEdge(siberia, yakutsk);
		world.addEdge(southAfrica, congo);
		world.addEdge(southAfrica, madagascar);
		world.addEdge(southAfrica, eastAfrica);
		world.addEdge(southernEU, egypt);
		world.addEdge(southernEU, northAfrica);
		world.addEdge(ural, afghanistan);
		world.addEdge(ukraine, afghanistan);
		world.addEdge(ukraine, middleEast);
		world.addEdge(ukraine, northernEU);
		world.addEdge(ukraine, scandinavia);
		world.addEdge(ukraine, southernEU);
		world.addEdge(ukraine, ural);
		world.addEdge(venezuela, brazil);
		world.addEdge(venezuela, centralAmerica);
		world.addEdge(venezuela, peru);
		world.addEdge(westernAustralia, easternAustralia);
		world.addEdge(westernAustralia, newGuinea);
		world.addEdge(westernEU, northAfrica);
		world.addEdge(westernEU, southernEU);
		world.addEdge(westernUS, centralAmerica);
		world.addEdge(westernUS, easternUS);
		world.addEdge(westernUS, ontario);
		world.addEdge(yakutsk, irkutsk);
		world.addEdge(yakutsk, kamchatka);
		
		w = world;
	}

	
	public static CountryI check(Point p) {
		for(CountryI c : w.getWorld().keySet()) {
			if(c.getLocation().distance(p) <= 20) {
				return c;
			}
		}
		return null;
	}
}
