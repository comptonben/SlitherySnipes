package specBTesting;

public class Match {
	public static Fighter fighter1;
	public static Fighter fighter2;
	public static Jester jester;
	
	public Match(Fighter fighter1, Fighter fighter2, Jester jester) {
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.jester = jester;
	}
	
	public void PlayMatch() {
		jester.CommentOnStart();
		jester.CommentOnMiddle();
		jester.CommentOnEnd();
	}
}
