
public class Cups {
	private String Name = new String("");
	private int serialNum;
	private String Color = new String("");
	private boolean hasHandle;
	private boolean isBroken;
	private double maxFluid;
	private double currFluid;
	
	public Cups(String name, int serNum, String col, boolean handle, double max, double curr){
		Name = name;
		serialNum = serNum;
		Color = col;
		hasHandle = handle;
		isBroken = false;
		maxFluid = max;
		currFluid = curr;
		
		
	}
	
	public void fillCup(){
		currFluid = maxFluid;
			}
	public void fillCup(double fillFluid){
		if (fillFluid+currFluid > maxFluid){
			currFluid = maxFluid;
		}else{
			currFluid += fillFluid;
		}
	}
	public void emptyCup(){
		currFluid = 0;
	}
	public void emptyCup(double Fluid){
		if(currFluid - Fluid < 0){
			currFluid = 0;
		}else{
			currFluid -= Fluid;
		}
	}
	public void dropCup(){
		int randomNum = (int)(Math.random()*10);
		if(randomNum <= 2){
			breakCup();
		}
		/*		int num = 0;
		while(num < 10){
			System.out.println(randomNum);
			num++;
		}
		*/
		}
	public void breakCup(){
		isBroken = true;
	}
	public String toString(){
		return Name + "\t" + serialNum + "\t" + Color + "\t" + currFluid + "\t" + hasHandle + "\t" + isBroken;
	}
	public String toName(){
		return Name;
	}
	public double getMax() {
		return maxFluid;
	}
	public double getCurr() {
		return currFluid;
	}
	public boolean getIsBroken() {
		return isBroken;
	}
}
