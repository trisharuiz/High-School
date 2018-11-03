
public class Tumbler extends Cups{
	private boolean isBroken;
	public Tumbler(String name, int serNum, String col, boolean handle, double max, double curr) {
		super(name, serNum, col, handle, max, curr);
		handle = false;
		isBroken = false;
		//maxFluid = max;
		//curr = (((curr/max)-(0.2))*10);
	}
		public void fillCup(){
			super.fillCup(super.getMax()*.80);
		}
		public void fillCup(double fillFluid){
			super.fillCup(fillFluid*.80);
		}
		public void emptyCup(){
			super.emptyCup(super.getMax());
		}
		public void emptyCup(double Fluid){
			super.emptyCup(Fluid);
			super.emptyCup(super.getCurr()*.20);
		}
		public void dropCup(){
			int randomNum = (int)(Math.random()*10);
			if(randomNum == randomNum){
				breakTumbler();
		}
		
		// TODO Auto-generated constructor stub
		}
		public void breakTumbler(){
			isBroken = false;
		}
		public void breakCup(){
			isBroken = false;
		}
}

