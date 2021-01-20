package application;

public class PostFixEvaluatorTest {
	
	public static void main(String[] args) {
		PostFixEvaluator postFixEvaluator = new PostFixEvaluator();
		System.out.println(postFixEvaluator.solve("42351-+*+")); //correct
		//System.out.println(postFixEvaluator.solve("42351-+*+*")); //operator extra
		//System.out.println(postFixEvaluator.solve("42351-+*")); //operator less
		System.out.println(postFixEvaluator.solve("42351-+*s")); //invalid entry
	}

}
