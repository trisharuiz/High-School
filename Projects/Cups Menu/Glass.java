
public class Glass extends Cups {

	public Glass(String name, int serNum, String col, boolean handle, double max, double curr) {
		super(name, serNum, col, handle, max, curr);
		// TODO Auto-generated constructor stub
	}
	public void dropCup() {
		int randomNum = (int)(Math.random()*10);
		if(randomNum > 2){
			breakCup();
		}
	}
}
