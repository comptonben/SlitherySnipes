package slitherySnipes;

public class Snipe {
	public boolean beakIsLong;
	public boolean bodyIsFat;
	public boolean longDistanceFlier;
	public boolean conservativeGenes;
	public int age;
	public boolean isAlive;
	public int energy;
	
	
	//return snipe's chance of getting food this year
	public Float GetFoodChance() {
		return (float) 1.0; //test value
	}
	
	
	//return snipe's chance of survival this year
	public Float GetSurvivalChance() {
		return (float) 1.0; //test value
	}
	
	
	//generate a new snipe from 2 snipes mating
	public Snipe GenerateOffspring() {
		Snipe newSnipe = new Snipe(); //test snipe
		return newSnipe;
	}
	
	
	//lose energy
	public void LoseEnergy() {
		
	}
}
