/**
 * Class for Testing the SubTournament class
 * 
 * @author Jared Boggs
 * @author Emily Coke
 * @author Ben Compton
 */
package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SubTournamentTest {
	private List<Fighter> fighters = new ArrayList<Fighter>();
	private Jester jester;
	
	/**
	 * setup two fighters in a list of Fighter objects and a jester to
	 * be used to setup a subtournament
	 */
	@Before
	public void setup() {
		Fighter f1 = new Fighter(1, 1, 1, WeaponFactory.MakeWeapon(), "Hercules");
		Fighter f2 = new Fighter(1, 1, 1, WeaponFactory.MakeWeapon(), "Hades");
		fighters.add(f1);
		fighters.add(f2);
		
		jester = new Jester();
	}
	
	/**
	 * test that you can instantiate an object of the SubTournament class
	 * 
	 * @result an instance of the SubTournament class is created.
	 */
	@Test
	public void canCreateSubTournamentTest() {
		SubTournament subTourney = new SubTournament(fighters, jester);
		
		assertTrue(subTourney instanceof SubTournament);
	}
	
	/**
	 * test who will be the winner of the subtournament
	 * 
	 * @result the DetermineWinner method will return an instance of the
	 * Fighter class as the winner of the subtournament
	 */
	@Test
	public void determineWinnerTest() {
		SubTournament subTourney = new SubTournament(fighters, jester);
		
		assertTrue(subTourney.DetermineWinner() instanceof Fighter);
	}

}
