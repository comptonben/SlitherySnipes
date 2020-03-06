package specBTesting;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

public class JesterTest {
	private Jester jester;

	@Before
	public void setup() {
		jester = new Jester();
	}
	
	@Test
	public void canCreateJesterTest() {
		assertNotNull(jester);
	}
	
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
