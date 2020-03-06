package specBTesting;

public class WeaponFactory {
	
	public static Weapon MakeWeapon() {
		Weapon weapon = new Weapon("short", 4, 1);
		return weapon;
	}
}
