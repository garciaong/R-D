package learning.rnd.regexp;

public class FinalTest {

	public final static int a = 1;
	public final static FinalChildMethod obj = new FinalChildMethod();
	
	public static void main(String [] args) {
		//Final variable cannot be assigned
//		a = 2;
		obj.setB(2);
		System.out.println("B is "+obj.getB());
	}
	
}
