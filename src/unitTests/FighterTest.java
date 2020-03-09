/**
 * Class for Testing the Fighter class
 * 
 * @author Jared Boggs
 * @author Emily Coke
 * @author Ben Compton
 */
package unitTests;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class FighterTest {
	private Weapon testWeapon;
	int[] strengths;
	int[] reaches;
	int[] speeds;
	
	/**
	 * create a weapon and setup test ranges for the unit tests below
	 */
	@Before
	public void setup() {
		testWeapon = WeaponFactory.MakeWeapon();
		strengths = IntStream.rangeClosed(1, 10).toArray();
		reaches = IntStream.rangeClosed(1, 10).toArray();
		speeds = IntStream.rangeClosed(1, 10).toArray();
	}
	
	/**
	 * test that you can instantiate an object of the Fighter class
	 * 
	 * @result an instance of the Fighter class is created.
	 */
	@Test
	public void canCreateFighterTest() {
		Fighter fighter = new Fighter(10, 5, 5, testWeapon, "Hercules");
		
		assertTrue(fighter instanceof Fighter);
	}
	
	/**
	 * test that any fighter with a higher strength in the range is
	 * stronger than any fighter with a lower strength
	 * 
	 * @result fighters are created across each range and tested for strength
	 */
	@Test
	public void fighterIsStrongerTest() {
		for(int strength : strengths) {
            int[] differences = IntStream.range(1, strength).toArray();
            for (int difference : differences) {
                Fighter fighter1 = new Fighter(strength, 1, 1, testWeapon, "Hercules");
                Fighter fighter2 = new Fighter(difference, 1, 1, testWeapon, "Hades");
                assertEquals(fighter1.StrongerThan(fighter2), true);
            }
        }
	}
	
	/**
	 * test that any fighter with a lower strength in the range is
	 * weaker than any fighter with a higher strength
	 * 
	 * @result fighters are created across each range and tested for strength
	 */
	@Test
	public void fighterIsWeakerTest() {
		for(int strength : strengths) {
            int[] differences = IntStream.range(1, strength).toArray();
            for (int difference : differences) {
                Fighter fighter1 = new Fighter(difference, 1, 1, testWeapon, "Hercules");
                Fighter fighter2 = new Fighter(strength, 1, 1, testWeapon, "Hades");
                assertEquals(fighter1.StrongerThan(fighter2), false);
            }
        }
	}
	
	/**
	 * test that any fighter with a longer reach in the range has a
	 * longer reach than than any fighter with a shorter reach
	 * 
	 * @result fighters are created across each range and tested for reach
	 */
	@Test
	public void fighterHasLongerReachTest() {
		for(int reach : reaches) {
            int[] differences = IntStream.range(1, reach).toArray();
            for (int difference : differences) {
                Fighter fighter1 = new Fighter(1, reach, 1, testWeapon, "Hercules");
                Fighter fighter2 = new Fighter(1, difference, 1, testWeapon, "Hades");
                assertEquals(fighter1.LongerReachedThan(fighter2), true);
            }
        }
	}
	
	/**
	 * test that any fighter with a shorter reach in the range has a
	 * shorter reach than than any fighter with a longer reach
	 * 
	 * @result fighters are created across each range and tested for reach
	 */
	@Test
	public void fighterHasShorterReachTest() {
		for(int reach : reaches) {
            int[] differences = IntStream.range(1, reach).toArray();
            for (int difference : differences) {
                Fighter fighter1 = new Fighter(1, difference, 1, testWeapon, "Hercules");
                Fighter fighter2 = new Fighter(1, reach, 1, testWeapon, "Hades");
                assertEquals(fighter1.LongerReachedThan(fighter2), false);
            }
        }
	}
	
	/**
	 * test that any fighter with a higher speed in the range has a
	 * higher speed than than any fighter with a lower speed
	 * 
	 * @result fighters are created across each range and tested for speed
	 */
	@Test
	public void fighterIsFasterTest() {
		for(int speed : speeds) {
            int[] differences = IntStream.range(1, speed).toArray();
            for (int difference : differences) {
                Fighter fighter1 = new Fighter(1, 1, speed, testWeapon, "Hercules");
                Fighter fighter2 = new Fighter(1, 1, difference, testWeapon, "Hades");
                assertEquals(fighter1.FasterThan(fighter2), true);
            }
        }
	}
	
	/**
	 * test that any fighter with a lower speed in the range has a
	 * lower speed than than any fighter with a higher speed
	 * 
	 * @result fighters are created across each range and tested for speed
	 */
	@Test
	public void fighterIsSlowerTest() {
		for(int speed : speeds) {
            int[] differences = IntStream.range(1, speed).toArray();
            for (int difference : differences) {
                Fighter fighter1 = new Fighter(1, 1, difference, testWeapon, "Hercules");
                Fighter fighter2 = new Fighter(1, 1, speed, testWeapon, "Hades");
                assertEquals(fighter1.FasterThan(fighter2), false);
            }
        }
	}
	
	/**
	 * test the getter for attack performance within the Fighter class
	 * 
	 * this will change due to simulation randomness
	 * 
	 * @result the getter will return the same attack as the weapon that the fighter
	 * is constructed with
	 */
	@Test
	public void getAttackPerfTest() {
		Fighter fighter = new Fighter(5, 5, 5, testWeapon, "Hercules");
		
		assertEquals(fighter.GetAttackPerformance(), testWeapon.getAttackRating());
	}
	
	/**
	 * test the getter for defense performance within the Fighter class
	 * 
	 * this will change due to simulation randomness
	 * 
	 * @result the getter will return the same defense as the weapon that the fighter
	 * is constructed with
	 */
	@Test
	public void getDefensePerfTest() {
		Fighter fighter = new Fighter(5, 5, 5, testWeapon, "Hercules");
		
		assertEquals(fighter.GetDefensePerformance(), testWeapon.getDefenseRating());
	}

}
