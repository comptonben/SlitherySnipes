package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TournamentTest {

	@Test
	public void canCreateTournamentTest() {
		Tournament tourney = new Tournament();
		
		assertTrue(tourney instanceof Tournament);
	}
	
	@Test
	public void initializeTournamentTest() {
		Tournament tourney = new Tournament();
		tourney.InitializeTournament(8);
		
		for(SubTournament subTourney: tourney.getSubTournamentList()) {
			assertTrue(subTourney instanceof SubTournament);
		}
	}
	
	@Test
	public void determineWinnerTest() {
		Tournament tourney = new Tournament();
		tourney.InitializeTournament(8);
		
		assertTrue(tourney.DetermineWinner() instanceof Fighter);
	}

}
