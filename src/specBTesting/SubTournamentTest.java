package specBTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SubTournamentTest {
	private List<Fighter> fighters = new ArrayList<Fighter>();
	private Jester jester;
	
	@Before
	public void setup() {
		Fighter f1 = new Fighter(1, 1, 1, WeaponFactory.MakeWeapon(), "Hercules");
		Fighter f2 = new Fighter(1, 1, 1, WeaponFactory.MakeWeapon(), "Hades");
		fighters.add(f1);
		fighters.add(f2);
		
		jester = new Jester();
	}
	
	@Test
	public void canCreateSubTournamentTest() {
		SubTournament subTourney = new SubTournament(fighters, jester);
		
		assertTrue(subTourney instanceof SubTournament);
	}
	
	@Test
	public void determineWinnerTest() {
		SubTournament subTourney = new SubTournament(fighters, jester);
		
		assertTrue(subTourney.DetermineWinner() instanceof Fighter);
	}

}
