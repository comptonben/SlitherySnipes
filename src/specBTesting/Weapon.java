package specBTesting;

public class Weapon {
	private String archetype;
	private int attackRating;
	private int defenseRating;

	public Weapon(String arch, int attack, int defense) {
		this.archetype = arch;
		this.attackRating = attack;
		this.defenseRating = defense;
	}
	
	public int getAttackRating() {
		return this.attackRating;
	}
	
	public int getDefenseRating() {
		return this.defenseRating;
	}
}
