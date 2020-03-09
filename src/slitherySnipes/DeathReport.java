package slitherySnipes;

/**
 * @author Jared Boggs
 * @author Ben Compton
 * @author Emily Coke
 * @version 1.0
 * @since 1.0
 */
public class DeathReport {
	public int year;
	public int age;
	public CauseOfDeath cause;
	
	/**
	 * DeathReport constructor
	 * 
	 * @param yearIn	year in which a snipe died
	 * @param ageIn		age of snipe at death
	 * @param causeIn	snipe's cause of death
	 */
	public DeathReport(int yearIn, int ageIn, CauseOfDeath causeIn) {
		year = yearIn;
		age = ageIn;
		cause = causeIn;
	}
	
}
