package field;

import entities.Country;
import world.World;

public class GameField {
	
	public static void main(final String[] args) {
	
		World gamefield = new World();
		
		Country germany = new Country("Germany");
		Country austria = new Country("Austria");
		Country france = new Country("France");
		Country switzerland = new Country("Switzerland");
		Country uk = new Country("UK");
		
		gamefield.addCountry(germany);
		gamefield.addCountry(austria);
		gamefield.addCountry(france);
		gamefield.addCountry(switzerland);
		gamefield.addCountry(uk);
		
		gamefield.addEdge(germany, austria);
		gamefield.addEdge(germany, switzerland);
		gamefield.addEdge(germany, france);
		gamefield.addEdge(france, uk);
		gamefield.addEdge(switzerland, austria);
		gamefield.addEdge(switzerland, france);
		
	}
	
	

}
