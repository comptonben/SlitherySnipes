package unitTests;

public class Fighter {

	private int strength;
	private int reach;
	private int speed;
	private Weapon weapon;
	private String name;

	public Fighter(int strength, int reach, int speed, Weapon weapon, String name) {
		this.strength = strength;
		this.reach = reach;
		this.speed = speed;
		this.weapon = weapon;
		this.name = name;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public boolean StrongerThan(Fighter fighter) {
		if(this.strength > fighter.strength) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean LongerReachedThan(Fighter fighter) {
		if(this.reach > fighter.reach) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean FasterThan(Fighter fighter) {
		if(this.speed > fighter.speed) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int GetAttackPerformance() {
		return this.weapon.getAttackRating();
	}
	
	public int GetDefensePerformance() {
		return this.weapon.getDefenseRating();
	}
}
