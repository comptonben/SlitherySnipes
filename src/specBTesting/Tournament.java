package specBTesting;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
	private List<SubTournament> subTournaments = new ArrayList<SubTournament>();
	private List<Fighter> fighters = new ArrayList<Fighter>();
	
	public void InitializeTournament(int entrants) {
		Jester jester = new Jester();
		int entrantsPerSub = entrants/4;
		for(int j=0; j < 4; j++) {
			for(int i=0; i < entrantsPerSub; i++) {
				Fighter fighter = new Fighter(1, 1, 1, WeaponFactory.MakeWeapon(), Integer.toString(i));
				fighters.add(fighter);
			}
			SubTournament subTourney = new SubTournament(fighters, jester);
			subTournaments.add(subTourney);
		}		
	}
	
	public Fighter DetermineWinner() {
		return subTournaments.get(0).DetermineWinner();
	}
	
	public List<SubTournament> getSubTournamentList() {
		return subTournaments;
	}
}
