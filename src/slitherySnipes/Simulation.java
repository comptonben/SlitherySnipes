package slitherySnipes;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
	//vars
	private List<DeathReport> deaths = new ArrayList<DeathReport>();
	private List<Snipe> snipes = new ArrayList<Snipe>();
	public int numYears;
	Environment env = new Environment();
	
	
	//start a new simulation
	public void RunNewSimulation() {
		
	}
	
	
	//give death strings to menu
	public String SummarizeDeaths() {
		return "test";
	}
}
