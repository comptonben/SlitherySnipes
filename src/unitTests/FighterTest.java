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
	
	@Before
	public void setup() {
		testWeapon = WeaponFactory.MakeWeapon();
		strengths = IntStream.rangeClosed(1, 10).toArray();
		reaches = IntStream.rangeClosed(1, 10).toArray();
		speeds = IntStream.rangeClosed(1, 10).toArray();
	}
	
	@Test
	public void canCreateFighterTest() {
		Fighter fighter = new Fighter(10, 5, 5, testWeapon, "Hercules");
		
		assertNotNull(fighter);
	}
	
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
	
	@Test
	public void getAttackPerfTest() {
		Fighter fighter = new Fighter(5, 5, 5, testWeapon, "Hercules");
		
		assertEquals(fighter.GetAttackPerformance(), testWeapon.getAttackRating());
	}
	
	@Test
	public void getDefensePerfTest() {
		Fighter fighter = new Fighter(5, 5, 5, testWeapon, "Hercules");
		
		assertEquals(fighter.GetDefensePerformance(), testWeapon.getDefenseRating());
	}

}
