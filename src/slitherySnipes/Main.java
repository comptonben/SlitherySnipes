package slitherySnipes;

//use this class to test our code

public class Main {
	public static void main(String[] args) {
		Menu mainMenu = new Menu();
		mainMenu.SetSimulationParameters();
		mainMenu.RunSimulation();
		mainMenu.ReadDeathReport();
		
	}
}