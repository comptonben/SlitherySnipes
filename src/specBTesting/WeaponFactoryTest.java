package specBTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeaponFactoryTest {

	@Test
	public void canMakeWeaponWithFactoryTest() {
		Weapon testWeapon = WeaponFactory.MakeWeapon();
		
		assertNotNull(testWeapon);
	}

}
