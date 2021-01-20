package application;

public class BalancedTest {
	
	public static void main(String[] args) {
		Balanced b = new Balanced("[{(","]})");
		System.out.println(b.checkExpression("[xx{hbm(avbv)xx}]"));
		System.out.println(b.checkExpression("[xx{h(bv)x}]vb)"));
		System.out.println(b.checkExpression("[xx{h(bv)x}"));
	}
}
