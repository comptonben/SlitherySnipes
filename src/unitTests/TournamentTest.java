/**
 * Class for Testing the Match class
 * 
 * @author Jared Boggs
 * @author Emily Coke
 * @author Ben Compton
 */
package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TournamentTest {

	/**
	 * test that you can instantiate an object of the Tournament class
	 * 
	 * @result an instance of the Tournament class is created.
	 */
	@Test
	public void canCreateTournamentTest() {
		Tournament tourney = new Tournament();
		
		assertTrue(tourney instanceof Tournament);
	}
	
	/**
	 * test the initialization of a tournament
	 * 
	 * @result when the tournament is initialized it containes a list
	 * of subtournamet objects
	 */
	@Test
	public void initializeTournamentTest() {
		Tournament tourney = new Tournament();
		tourney.InitializeTournament(8);
		
		for(SubTournament subTourney: tourney.getSubTournamentList()) {
			assertTrue(subTourney instanceof SubTournament);
		}
	}
	
	/**
	 * test who will be the winner of the tournament
	 * 
	 * @result the DetermineWinner method will return an instance of the
	 * Fighter class as the winner of the tournament
	 */
	@Test
	public void determineWinnerTest() {
		Tournament tourney = new Tournament();
		tourney.InitializeTournament(8);
		
		assertTrue(tourney.DetermineWinner() instanceof Fighter);
	}

}
