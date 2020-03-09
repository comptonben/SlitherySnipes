package slitherySnipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Menu {
	Simulation currentSim = new Simulation();
	List<String> DeathReports = new ArrayList<String>();
	Scanner inputScanner = new Scanner(System.in);
	
	//create user-facing menu
	public void uiMenu() {
		while(true) {
			boolean validIn = false;
			int selection = 0;
			
			while(!validIn) {
				//menu title
				System.out.println("\nSLITHERY SNIPES SIMULATION");
				
				//option 1 = set params
				System.out.println("1 - Set Simulation Parameters");
				
				//option 2 = run sim
				System.out.println("2 - Run Simulation");
				
				//option 3 = show report
				System.out.println("3 - Show Death Reports");
				
				//option 4 = exit
				System.out.println("4 - Quit");	
				
				//get user input
				try {
					selection = inputScanner.nextInt();
					validIn = true;
					} 
				catch (InputMismatchException e) {
						validIn = false;
						System.out.println("invalid entry");
						inputScanner.next();
					}
			
			}//end of while(!valid)
			
			//selection logic
			switch (selection) {
			case 1: this.SetSimulationParameters();
					break;
					
			case 2: this.RunSimulation();
					break;
					
			case 3: this.ReadDeathReport();
					break;
					
			case 4: inputScanner.close();
					return;
			
			}
			
		}//end of while true
	}
	
	//get death reports from Sim, print out
	public void ReadDeathReport() {
		int choice = 0;
		boolean validChoice = false;
		
		while(!validChoice) {
			//show option of simulation runs
			System.out.println("Choose number corresponding to Simulation to view its death report:");
			for(int i=0; i<DeathReports.size(); i++) {
				System.out.println("Simulation Run "+String.valueOf(i+1));
			}
			System.out.println("Type '0' to return to main menu");
			
			//get user input
			try {
				choice = inputScanner.nextInt();
				if(choice == 0) {
					return;
				}
				if((choice >= 1) && (choice <= DeathReports.size())) {
					validChoice = true;
				}
				else {
					validChoice = false;
				}
					
			}
			catch (InputMismatchException e) {
				validChoice = false;
				System.out.println("invalid entry");
				inputScanner.next();
			}
		}

		System.out.println(DeathReports.get(choice-1));
	}
	
	
	//call RunNew on sim
	public void RunSimulation() {
		System.out.println("Running new Snipe Simulation");
		currentSim.RunNewSimulation();
		DeathReports.add(currentSim.SummarizeDeaths());
		System.out.println("Finished Snipe Simulation");
	}
	
	
	//get input
	public void SetSimulationParameters() {
		
		//temp params
		int isPlentiful = 0;
		int isDangerous = 0;
		
		//user input
		System.out.println("Enter Parameters (0=false, 1=true) :");
		
		//food in environment
		boolean validInput = false;
		while(!validInput) {
			System.out.print("Plentiful Environment? : ");
			try {
			isPlentiful = inputScanner.nextInt();
			validInput = true;
			} catch (InputMismatchException e) {
				validInput = false;
				System.out.println("invalid entry");
			}
		}
		
		//danger of environment
		validInput = false;
		while(!validInput) {
			System.out.print("Dangerous Environment? : ");
			try {
			isDangerous = inputScanner.nextInt();
			validInput = true;
			} catch (InputMismatchException e) {
				validInput = false;
				System.out.println("invalid entry");
				inputScanner.next();
			}
		}
		
		//set environment in sim to params
		if (isPlentiful == 0)
			currentSim.env.isPlentiful = false;
		else
			currentSim.env.isPlentiful = true;
		if(isDangerous == 0)
			currentSim.env.isDangerous = false;
		else
			currentSim.env.isDangerous = true;
		
		//echo print for debug
		System.out.println("\nPlentiful: " + String.valueOf(currentSim.env.isPlentiful));
		System.out.println("Dangerous: " +String.valueOf(currentSim.env.isDangerous));
		
	}
	
}
