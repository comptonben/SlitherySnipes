package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeaponTest {

	@Test
	public void canCreateWeaponTest() {
		Weapon testWeapon = new Weapon("short", 4, 1);
		
		assertNotNull(testWeapon);
	}
	
	@Test
	public void hasAttackRating() {
		Weapon testWeapon = new Weapon("short", 4, 1);
		
		assertNotNull(testWeapon.getAttackRating());
	}
	
	@Test
	public void hasDefenseRating() {
		Weapon testWeapon = new Weapon("short", 4, 1);
		
		assertNotNull(testWeapon.getDefenseRating());
	}
}
