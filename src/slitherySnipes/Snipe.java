package slitherySnipes;

import java.util.Random;

/**
 * @author Jared Boggs
 * @version 1.0
 * @since 1.0
 */
public class Snipe {
	public boolean beakIsLong;
	public boolean bodyIsFat;
	public boolean longDistanceFlier;
	public boolean conservativeGenes;
	public int age;
	public boolean isAlive;
	public int energy;
	
	/**
	 * general snipe class constructor
	 * 
	 * @param longBeak		is the snipe's beak long or short?
	 * @param fatBody		is the snipe's body fat or skinny?
	 * @param distanceFlier	is the snipe a long distance flier or short distance flier?
	 * @param conservGenes	does the snipe have conservative genes or spontaneous genes?
	 */
	public Snipe(boolean longBeak, boolean fatBody, boolean distanceFlier, boolean conservGenes) {
		beakIsLong = longBeak;
		bodyIsFat = fatBody;
		longDistanceFlier = distanceFlier;
		conservativeGenes = conservGenes;
		age = 0;
		isAlive = true;
		energy = 2; //snipes are born with 2 energy
	}
	
	/**
	 * calculates this snipe's probability of finding food
	 * 
	 * @param none
	 * @return Float
	 */
	public Float GetFoodChance() {  //MOVE TO CONSTRUCTOR
		float foodChance = (float) 0.5;
		
		//beak length
		if(beakIsLong) {
			foodChance += 0.1;}
		else {
			foodChance -= 0.1;}
		
		//flight type
		if(longDistanceFlier) {
			foodChance += 0.2;}
		else {
			foodChance -= 0.1;}
		
		return foodChance; //float btw 0-1
	}
	
	
	/**
	 * calculates this snipe's probability of surviving a predator encounter
	 * 
	 * @param none
	 * @return Float
	 */
	public Float GetSurvivalChance() {
		float survChance = (float) 0.5;
		
		//beak length
		if(beakIsLong) {
			survChance -= 0.05;}
		else {
			survChance += 0.05;}
		
		//flight type
		if(longDistanceFlier) {
			survChance -= 0.1;}
		else {
			survChance += 0.2;}
		
		//body type
		if(bodyIsFat) {
			survChance -= 0.1;
		}
		else {
			survChance += 0.1;
		}
		
		return survChance; //float btw 0-1
	}
		
	
	/**
	 * creates a new snipe offspring from this snipe and another snipe passed into method.
	 * Uses parents' genetic traits to determine traits of offspring snipe
	 * 
	 * @param mate	pointer to another snipe object
	 * @return 		new snipe object with traits of parents
	 */
	public Snipe GenerateOffspring(Snipe mate) {//pass mate and which traits from who
		boolean childBeakLong = false;
		boolean childBodyFat = false;
		boolean childDistanceFlier = false;
		boolean childConservGenes = false;
		
		Random random = new Random();
		int parent;
		
		//pass traits
		for(int i=0; i<4; i++) {
			parent = random.nextInt(1); //get if this snipe or mate passes down per trait
			
			//if this snipe passes trait
			if(parent == 0) { 
				//check if conservative
				if(this.conservativeGenes) {
					//pass down same trait
					switch (i) {
						case 0: childBeakLong = this.beakIsLong;
								break;
						case 1:	childBodyFat = this.bodyIsFat;
								break;
						case 2:	childDistanceFlier = this.longDistanceFlier;
								break;						
						case 3:	childConservGenes = this.conservativeGenes;
								break;
					}
				}
				else {//spontaneous snipe
					//prob of passing trait = 75%
					if(random.nextInt(99) < 75) {
						//pass trait
						switch (i) {
						case 0: childBeakLong = this.beakIsLong;
								break;
						case 1:	childBodyFat = this.bodyIsFat;
								break;
						case 2:	childDistanceFlier = this.longDistanceFlier;
								break;						
						case 3:	childConservGenes = this.conservativeGenes;
								break;
						}
					}
					else {
						//pass opposite trait
						switch (i) {
						case 0: childBeakLong = !this.beakIsLong;
								break;
						case 1:	childBodyFat = !this.bodyIsFat;
								break;
						case 2:	childDistanceFlier = !this.longDistanceFlier;
								break;						
						case 3:	childConservGenes = !this.conservativeGenes;
								break;
						}
					}
				}
				
			} //end of parent 1
			
			else {//if mate passes
				//check if conservative
				if(this.conservativeGenes) {
					//pass down same trait
					switch (i) {
						case 0: childBeakLong = mate.beakIsLong;
								break;
						case 1:	childBodyFat = mate.bodyIsFat;
								break;
						case 2:	childDistanceFlier = mate.longDistanceFlier;
								break;						
						case 3:	childConservGenes = mate.conservativeGenes;
								break;
					}
				}
				else {//spontaneous snipe
					//prob of passing trait = 75%
					if(random.nextInt(99) < 75) {
						//pass trait
						switch (i) {
						case 0: childBeakLong = mate.beakIsLong;
								break;
						case 1:	childBodyFat = mate.bodyIsFat;
								break;
						case 2:	childDistanceFlier = mate.longDistanceFlier;
								break;						
						case 3:	childConservGenes = mate.conservativeGenes;
								break;
						}
					}
					else {
						//pass opposite trait
						switch (i) {
						case 0: childBeakLong = !mate.beakIsLong;
								break;
						case 1:	childBodyFat = !mate.bodyIsFat;
								break;
						case 2:	childDistanceFlier = !mate.longDistanceFlier;
								break;						
						case 3:	childConservGenes = !mate.conservativeGenes;
								break;
						}
					}
				}			
			}
		}
	
		Snipe newSnipe = new Snipe(childBeakLong, childBodyFat, childDistanceFlier, childConservGenes);
		return newSnipe;
	}
	
	
	/**
	 * deduces energy units from snipe
	 * 
	 * @param energyLost	the amount of energy units to consume from this snipe
	 */
	public void LoseEnergy(int energyLost) {
		energy = energy - energyLost;
	}
	
	
}
