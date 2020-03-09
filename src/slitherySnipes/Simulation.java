package slitherySnipes;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Simulation {
	//vars
	private List<DeathReport> deaths = new ArrayList<DeathReport>();
	private List<Snipe> snipes = new ArrayList<Snipe>();
	Environment env = new Environment();
	public int numYears;
	
	
	
	//start a new simulation
	public void RunNewSimulation() {
		deaths.clear();
		snipes.clear();
		numYears = 0;
		Random rand = new Random();
		int berries = 0;
		int berriesPerYear = 0;
		int predators = 0;
		
		//environmental setup
			//berries
			if (env.isPlentiful) { berriesPerYear = 400;}
			else { berriesPerYear = 200;}
			//predators
			if(env.isDangerous) { predators = 400;}
			else { predators = 200;}
		
		//generate 300 initial snipes with random traits
		for(int s=0; s<300; s++) {
			boolean trait0 = rand.nextBoolean();
			boolean trait1 = rand.nextBoolean();
			boolean trait2 = rand.nextBoolean();
			boolean trait3 = rand.nextBoolean();
			snipes.add(new Snipe(trait0, trait1, trait2, trait3));
		}
		
		for(numYears = 0; numYears<200; numYears++){
			System.out.println("Year: " + String.valueOf(numYears+1));
			System.out.println("Population: " + String.valueOf(snipes.size()));
			
			//environment produces berries (max 600)
			berries += berriesPerYear;
			if (berries > 600) { berries = 600;}
				
			//how many predators encounter a snipe
			int encounters = 0;
			for(int p=0; p<predators; p++) {
				if(rand.nextInt(99) < 75) {encounters += 1; }			
			}
				
			//predator encounter with a snipe
			int snipeCaughtIdx;
			for (int i=0; i < encounters; i++){
				//make sure snipes exist
				if(snipes.size() <= 0) {
					System.out.println("Snipe Population After " + String.valueOf(numYears) + " Years: " + String.valueOf(snipes.size())); 
					return; }
				
				//randomize which snipes are caught
				snipeCaughtIdx = rand.nextInt(snipes.size());
				
				//check snipe chance of survival
				float survChance = snipes.get(snipeCaughtIdx).GetSurvivalChance();
				if(rand.nextFloat() < survChance) {//survives
					snipes.get(snipeCaughtIdx).LoseEnergy(1);
				}
				else {//dies
					//if killed, remove from snipelist, deathreport
					deaths.add(new DeathReport(numYears, snipes.get(snipeCaughtIdx).age, CauseOfDeath.PREDATION));
					snipes.remove(snipeCaughtIdx);
				}
			}
		
			float foodChance = 0;
			for(int k = 0; k < snipes.size(); k++) {
			//snipe look for food
				foodChance = snipes.get(k).GetFoodChance();
				if(rand.nextFloat() < foodChance) {
					if(berries > 0) {
						snipes.get(k).energy += 4;
						berries -= 1;
					}
				}
						
			//snipes lose energy for surviving
				snipes.get(k).LoseEnergy(2);
		
			//snipes with <0 energy die
				if (snipes.get(k).energy < 0) {
					//generate death report
					deaths.add(new DeathReport(numYears, snipes.get(k).age, CauseOfDeath.STARVATION));
					//remove from snipeList
					snipes.remove(k);	
				}
				else { snipes.get(k).age++; }
					
			}
			
			//snipes reproduce 
			for(int j = 0; j < snipes.size(); j+=2) {
				if(rand.nextInt(2) == 1) {
					if(j < (snipes.size()-1)) {
						Snipe newSnipe = snipes.get(j).GenerateOffspring(snipes.get(j+1));
						snipes.add(newSnipe);
					}
				}
			}
			
		}//end of year
		
		//sim ended, output info
		System.out.println("Snipe Population After 200 Years: " + String.valueOf(snipes.size()));
		
	}//end of simulation
	
	
	
	//give death strings to menu
	public String SummarizeDeaths() {
		String summary = "";
		
		for(int i=0; i<deaths.size(); i++)
		{
			summary += "Snipe " + String.valueOf(i) + " died due to " + 
					String.valueOf(deaths.get(i).cause) + " in year " + String.valueOf(deaths.get(i).year) + 
					" at age " + String.valueOf(deaths.get(i).age) + "\n";
			
		}

				
		return summary;
	}
	
}
