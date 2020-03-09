/**
 * Class for Testing the WeaponFactory class
 * 
 * @author Jared Boggs
 * @author Emily Coke
 * @author Ben Compton
 */
package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeaponFactoryTest {

	/**
	 * test that you can create a weapon with the
	 * weapon factory
	 * 
	 * @result a weapon is returned from the weapon
	 * factory
	 */
	@Test
	public void canMakeWeaponWithFactoryTest() {
		Weapon testWeapon = WeaponFactory.MakeWeapon();
		
		assertTrue(testWeapon instanceof Weapon);
	}

}
