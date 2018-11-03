import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class bullet {
	int bullX, bullY;
	int velocity;
	Image bullet;
	Rectangle bulletBound = new Rectangle(bullX, bullY, 50, 50);
	Rectangle objectBound;
	public bullet(int startX, int startY){
		bullX = startX;
		bullY = startY;
		bullet = Toolkit.getDefaultToolkit().getImage("star.png");
	}
	public void update(){
		bullY -= 4;
	}
	public void paint(Graphics g, ImageObserver io) {		
		g.drawImage(bullet,  bullX, bullY, 50, 50, io);
		
	}
	public boolean doesBulletHit(Rectangle object){
		objectBound = object;
			if (bulletBound.intersects(objectBound)){
			return true;
		}
		return false;
	}
}
