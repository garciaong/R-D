package learning.rnd.regexp;

//Final class cannot be sub-classed
public class FinalChildMethod {//extends FinalMethod{
	private int b = 4;
	//Final method cannot be overrided
	public int getB() {
		return b;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
}
