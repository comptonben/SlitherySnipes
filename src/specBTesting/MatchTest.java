package specBTesting;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MatchTest {
	private Fighter fighter1;
	private Fighter fighter2;
	private Jester jester;
	
	@Before
	public void setup() {
		fighter1 = new Fighter(10, 5, 5, WeaponFactory.MakeWeapon(), "Hercules");
		fighter2 = new Fighter(10, 5, 5, WeaponFactory.MakeWeapon(), "Hades");
		jester = new Jester();
	}

	@Test
	public void PlayMatchTest() {
		final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outStream));
		
		Match match = new Match(fighter1, fighter2, jester);
		match.PlayMatch();
		
		String regex = "(Start Comment\\r\\nMiddle Comment\\r\\nEnd Comment\\r\\n)";
		Pattern pat = Pattern.compile(regex);
		
		Matcher m = pat.matcher(outStream.toString());
		assertTrue(m.find());
		
		System.setOut(System.out);
	}

}
