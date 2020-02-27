package slitherySnipes;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	List<String> DeathReports = new ArrayList<String>();

	//get death reports from Sim, print out
	public void ReadDeathReport() {
		System.out.println("Reading out death reports");
	}
	
	
	//call RunNew on sim
	public void RunSimulation() {
		System.out.println("Running new simulation");
	}
	
	
	//get input
	public void SetSimulationParameters() {
		System.out.println("Enter Parameters!:");
		
		//test values, read in from user input for these
		int isPlentiful = 1;
		int isDangerous = 1;
			
		System.out.println("Plentiful: " + String.valueOf(isPlentiful));
		System.out.println("Dangerous: " +String.valueOf(isDangerous));
	}
		
}
