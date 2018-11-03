import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.Rectangle;

public class player {
	int lives;
	static int x;
	static int y;
	Image spaceship;
	Rectangle playerBound = new Rectangle(x, y, 150, 150);
	Rectangle objectBound;
	
	public player (int startX, int startY){
		x = startX;
		y = startY;
		spaceship = Toolkit.getDefaultToolkit().getImage("girl.png");
		lives = 3;
	}
	public static void moveRight(){
		x += 25;
	}
	public static void moveLeft(){
		x -=25;
	}
	public void paint(Graphics g, ImageObserver io) {		
		g.drawImage(spaceship,  x, y, 150, 150, io);
	}
	public boolean doesPlayerHit(Rectangle object){
		objectBound = object;
		//System.out.println("checking bullet");
		if (playerBound.intersects(objectBound)){
			return true;
		}
		return false;
		}
	}
	

