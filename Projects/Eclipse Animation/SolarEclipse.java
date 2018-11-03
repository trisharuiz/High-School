import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

//Trisha Ruiz
//8/29/2017

public class SolarEclipse extends Applet implements Runnable {
	public int framePlayedCounter, framesTouchingCounter;
	public int gr, gg, gb;
	public int xcoor2, ycoor2;
	public int xcoor1, ycoor1;
	public int radius1, radius2;
	public double distance;
	public boolean isSunTouchingMoon, hasMoonFullyCoveredSun;

	public void init() {
		setSize(500, 500);
		setBackground(new Color(210, 210, 210));
		//moon
		xcoor2 = 150;
		ycoor2 = 0;
		
		//sun
		xcoor1 = 226;
		ycoor1 = 1;
		
		//sky color
		gr = 210;
		gg = 210;
		gb = 210;
		
		//is the sun touching the moon

		isSunTouchingMoon = false;
		
		//radius
		radius1 = 25;
		radius2 = 25;
		
		//counts frames that has sun touching moon.
		framesTouchingCounter = 0;
		
		//checks if moon has fully overlapped moon
		hasMoonFullyCoveredSun = false;
		
		//starts animation
		Thread t = new Thread(this);
		t.start();
		

	}

	public void paint(Graphics graphics) {
		//checks if sun is touching moon
		if (distance <= radius1 + radius2 ){
			isSunTouchingMoon = true;
		}else {
			isSunTouchingMoon = false;
		}
		
		//checks if sun and moon is touching to change sky color
		if (isSunTouchingMoon == true) {
			graphics.setColor(new Color(gr, gg, gb));
			
		}else{
			graphics.setColor(new Color(gr, gg, gb));
		}
		//sky
		graphics.fillRect(0, 0, 500, 500);
		
		//checks if sun and moon is touching to change its color

		//sun
		graphics.setColor(Color.orange);
		graphics.fillOval(xcoor1, ycoor1, 50, 50);
		//moon
		graphics.setColor(Color.gray);
		graphics.fillOval(xcoor2, ycoor2, 50, 50);
		//grass
		graphics.setColor(Color.green);
		graphics.fillRect(0, 400, 500, 100);
		
		

	}

	@Override
	public void run() {
		while (true) {
			//distance between sun and moon
			distance = Math.sqrt(Math.pow(xcoor2 - xcoor1, 2)+Math.pow(ycoor2 - ycoor1, 2));
			//counts the number of frames played
			framePlayedCounter++;
			//converts counter number to Radians
			double counterRad = Math.toRadians(framePlayedCounter);
			//moves the moon around a circle
			xcoor2 = (int) (250 + 190 * Math.sin(counterRad));
			ycoor2 = (int) (250 + 250 * Math.cos(counterRad));
			
			//checks if sun is touching moon
			if (isSunTouchingMoon == true && gr != 0 && gg != 0 && gb != 0 && hasMoonFullyCoveredSun == false) {
				gr = gr - 10;
				gg = gg - 10;
				gb = gb - 10;
				System.out.println(gr+" "+gb+" "+gb);
				if (gr == 100) {
					System.out.println("STOP");
					hasMoonFullyCoveredSun = true;
				}

			}else if (hasMoonFullyCoveredSun == true && isSunTouchingMoon == true && gr <= 240){
				System.out.println(gr+" "+gb+" "+gb);
				gr = gr + 10;
				gg = gg + 10;
				gb = gb + 10;
			}else if (hasMoonFullyCoveredSun == true){
				hasMoonFullyCoveredSun = false;
			}
			
			repaint();

			try {
				Thread.sleep(35);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}