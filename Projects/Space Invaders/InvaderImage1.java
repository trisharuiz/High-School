import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class InvaderImage1 {

	int currx, curry;
	double a;
	static int xStart = 0, yStart = 0;
	static int vx = 1, vy = 10;
	Image helloKitty;
	Image frog;
	int width = 700;
	int height = 700;
	int FinalInvaderY;

	Rectangle invaderBound = new Rectangle(300, 300, 50, 50);
	Rectangle objectBound;

	bullet star = new bullet(300, 500);
	player playerOne = new player(50, 500);

	public InvaderImage1(int startX, int startY) {
		currx = startX;
		curry = startY;
		a = Math.random();
		if (a <= .5) {
			helloKitty = Toolkit.getDefaultToolkit().getImage("hellokitty.png");
		} else {
			frog = Toolkit.getDefaultToolkit().getImage("kerropi.png");
		}
	}

	public void update() {

		currx += vx;
		
	}

	public void paint(Graphics g, ImageObserver io) {

		if (a <= .5) {
			g.drawImage(helloKitty, currx, curry + vy, 50, 50, io);
			
			
		} else {
			g.drawImage(frog, currx, curry + vy, 50, 50, io);
			
		}
	}

	public boolean doesInvaderHit(Rectangle object) {
		objectBound = object;
		if (invaderBound.intersects(objectBound)) {
			return true;
		}
		return false;
	}
	
}