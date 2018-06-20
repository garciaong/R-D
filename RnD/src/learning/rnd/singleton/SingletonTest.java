package learning.rnd.singleton;

public class SingletonTest {

	public static void main(String [] args) {
		SingletonManager.getInstanceA().print();
		SingletonManager.getInstanceB().print();
		SingletonManager.getInstanceA().print();
		SingletonManager.getInstanceB().print();
	}
	
}
