# Risiko

* Risiko
	* Contains a method to call UI
* Risiko Module
	* Util class needed for guice
* model
    * CountryI
        * Contains all attributes of a country (Name, number of Soldiers, Location)
        * Contains methods to get and set those attributes
    * PlayerI
        * Contains all attributes of a player (Name, owned countries)
        * Contains methods to get and set the name and countries owned
    * WorldI
        * Contains all attributes of the "game world"
        * Contains methods to edit the graph, which represents the "game world"
    * impl
    	* Contains implementations of the interfaces
* turn
	* Die
		* Represents a die
		* Contains methods to roll a die and to set the random
	* TurnState
		*
		*
	* Turn
		*
		*
	* StartTurn
		*
		*
	* InvadeTurn
		*
		*
	* RecruitmentTurn
		*
		*
* util.observer
	* contains observer pattern
* controller
	* IGameEngine
		* Contains various methods for UI to interact with "model" and "turn" package
	* impl
		* GameEngine
			* Implementation of "IGameEngine"
		* RiskMap
			* Util class to create a new gamefield
	* logwrapper
		* GameEngine
			* a fake implementation of IGameEngine needed for logging
*view
	* GUI
		* Contains main Frame and the main Panel, which contains "ControlPanel", "Statistics" and "Status"
		* Contains a method to update "Statistics" and "Status"
		* Calls StartDialog
	* StartDialog
		* Dialog to set names of both Players
	* ControlPanel
		* Provides interaction of user and program
		* calls "AttackDialog", "MoveDialog" and "RecruitmentDialog"
	* AttackDialog
		* provides the possibility to select a country to attack
	* MoveDialog
		* provides the possibility to move soldiers from one country to another
	* RecruitmentDialog
		* provides the possibility to add soldiers to a country
	* Statistics
		* Contains a textArea, which shows both players with their countries
	* Status
		* shows the actual status of the game
	* TextUI
		*implementation of a logger
	
		