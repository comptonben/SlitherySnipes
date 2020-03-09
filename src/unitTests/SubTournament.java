package unitTests;

import java.util.ArrayList;
import java.util.List;

public class SubTournament {
	private List<Match> matches = new ArrayList<Match>();
	
	public SubTournament(List<Fighter> fighters, Jester jester) {
		for(int i=0; i<fighters.size(); i+=2) {
			Match match = new Match(fighters.get(i), fighters.get(i+1), jester);
			matches.add(match);
		}
	}
	
	public Fighter DetermineWinner() {
		return matches.get(0).fighter1;
	}
}
