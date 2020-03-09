/**
 * Class for Testing the Weapon class
 * 
 * @author Jared Boggs
 * @author Emily Coke
 * @author Ben Compton
 */
package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeaponTest {

	/**
	 * test that you can instantiate an object of the Weapon class
	 * 
	 * @result an instance of the Weapon class is created.
	 */
	@Test
	public void canCreateWeaponTest() {
		Weapon testWeapon = new Weapon("short", 4, 1);
		
		assertNotNull(testWeapon);
	}
	
	/**
	 * test the getter of the attack of the weapon
	 * 
	 * @result the returned attack is the same as
	 * it was instantiated with
	 */
	@Test
	public void hasAttackRating() {
		Weapon testWeapon = new Weapon("short", 4, 1);
		
		assertEqual(testWeapon.getAttackRating(), 4);
	}
	
	/**
	 * test the getter of the defense of the weapon
	 * 
	 * @result the returned defense is the same as
	 * it was instantiated with
	 */
	@Test
	public void hasDefenseRating() {
		Weapon testWeapon = new Weapon("short", 4, 1);
		
		assertNotNull(testWeapon.getDefenseRating());
	}
}
