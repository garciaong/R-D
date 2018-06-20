package learning.rnd.singleton;

public class SingletonManager {

	public static ObjectA getInstanceA() {
		return (ObjectA) SingletonRegistry.REGISTRY.getInstance("learning.rnd.singleton.ObjectA");
	}
	
	public static ObjectB getInstanceB() {
		return (ObjectB) SingletonRegistry.REGISTRY.getInstance("learning.rnd.singleton.ObjectB");
	}
	
}
