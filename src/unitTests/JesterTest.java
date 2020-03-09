/**
 * Class for Testing the Jester class
 * 
 * @author Jared Boggs
 * @author Emily Coke
 * @author Ben Compton
 */
package unitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

public class JesterTest {
	private Jester jester;

	/**
	 * creates a new Jester object to use during the test cases
	 * that need one other than the test for instantiation
	 */
	@Before
	public void setup() {
		jester = new Jester();
	}
	
	/**
	 * test that you can instantiate an object of the Jester class
	 * 
	 * @result an instance of the Jester class is created.
	 */
	@Test
	public void canCreateJesterTest() {
		assertNotNull(jester);
	}
	
	/**
	 * test that the jester will relay the start comment
	 * 
	 * @result the start comment is captured from stdout of the program
	 */
	@Test
	public void startCommentTest() {
		final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outStream));
		
		jester.CommentOnStart();
		
		String regex = "(Start Comment\\r\\n)";
		Pattern pat = Pattern.compile(regex);
		
		Matcher m = pat.matcher(outStream.toString());
		assertTrue(m.find());
		
		System.setOut(System.out);
	}
	
	/**
	 * test that the jester will relay the middle comment
	 * 
	 * @result the middle comment is captured from stdout of the program
	 */
	@Test
	public void middleCommentTest() {
		final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outStream));
		
		jester.CommentOnMiddle();
		
		String regex = "(Middle Comment\\r\\n)";
		Pattern pat = Pattern.compile(regex);
		
		Matcher m = pat.matcher(outStream.toString());
		assertTrue(m.find());
		
		System.setOut(System.out);
	}
	
	/**
	 * test that the jester will relay the end comment
	 * 
	 * @result the end comment is captured from stdout of the program
	 */
	@Test
	public void endCommentTest() {
		final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outStream));
		
		jester.CommentOnEnd();
		
		String regex = "(End Comment\\r\\n)";
		Pattern pat = Pattern.compile(regex);
		
		Matcher m = pat.matcher(outStream.toString());
		assertTrue(m.find());
		
		System.setOut(System.out);
	}

}
