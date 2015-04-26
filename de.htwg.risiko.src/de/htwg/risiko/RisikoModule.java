package de.htwg.risiko;

import com.google.inject.AbstractModule;
import de.htwg.risiko.controller.IGameEngine;


public class RisikoModule extends AbstractModule {
	
		@Override
		protected void configure() {

		bind(IGameEngine.class).to(de.htwg.risiko.controller.logwrapper.GameEngine.class);
		}
}
