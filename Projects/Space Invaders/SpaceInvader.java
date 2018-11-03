import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class SpaceInvader extends JComponent implements Runnable, KeyListener {

	InvaderImage1 kitty, frog;
	player playerOne = new player(50, 500);
	bullet star = new bullet(300, 500);
	ArrayList<InvaderImage1> invaders = new ArrayList<InvaderImage1>();
	ArrayList<Rectangle> invaderBounds = new ArrayList<Rectangle>();
	int startX = 50;
	int startY = 50;
	int rectangleInvaderX;
	int rectangleInvaderY;
	public int finalInvaderY;

	public SpaceInvader() {

		this.setSize(700, 700);
		this.createInvaders(6, 10);
		addKeyListener(this);
		Thread t = new Thread(this);
		t.start();

	}

	/// you may need to create a new method that creates the bounds
	public void createInvaders(int needRow, int needCol) {
		for (int row = 0; row < needRow; row++) {
			startY = InvaderImage1.yStart + (50 * row);
			for (int col = 0; col < needCol; col++) {
				startX = InvaderImage1.xStart + (50 * col);
				invaders.add(new InvaderImage1(startX, startY));
				rectangleInvaderX = startX;
				rectangleInvaderY = startY;
				invaderBounds.add(new Rectangle(rectangleInvaderX, rectangleInvaderY, 50, 50));

				System.out.println(rectangleInvaderX + "," + rectangleInvaderY);
			}
		}
	}

	public void updateBounds() {

	}

	public void paint(Graphics g) {
		// System.out.println("Inside Paint");
		for (int i = 0; i < invaders.size(); i++) {
			invaders.get(i).paint(g, this);
			// System.out.println("Painting invader object");
		}
		playerOne.paint(g, this);
		star.paint(g, this);
	}

	public static void main(String[] args) {
		System.out.println("main");
		JFrame frame = new JFrame("Dencker is better thaN EVERYTHING!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		SpaceInvader invaders = new SpaceInvader();
		frame.add(invaders);
		frame.addKeyListener(invaders);
		frame.getContentPane().setBackground(Color.black);
	}

	/*
	 * public boolean doesInvaderHitBullet(){
	 * //System.out.println("checking invader"); return
	 * star.doesBulletHit(invaderBound); } public boolean
	 * doesInvaderHitPlayer(){ return playerOne.doesPlayerHit(invaderBound); }
	 */

	@Override
	public void run() {
		while (true) {
			// System.out.print("Running update");

			if (invaders != null && invaders.size() > 0) {
				boolean hitWall = false;
				for (int i = 0; i < invaders.size(); i++) {
					invaders.get(i).update();
					updateBounds();
					// System.out.println(invaders.get(i).doesInvaderHit(player.playerBound));

					int currRectangleX = invaderBounds.get(i).x +
					InvaderImage1.vx;
					int currRectangleY = invaderBounds.get(i).y;

					invaderBounds.get(i).setBounds(currRectangleX,currRectangleY, 50, 50);
					
					//System.out.println(invaders.get(5).currx);
					if (invaders.get(i).currx >= (invaders.get(i).width - 65) || invaders.get(i).currx <= 0) {
						hitWall = true;
						
					}
					if(invaders.get(5).currx ==435 || invaders.get(0).currx == 0){
					invaderBounds.get(i).setBounds(currRectangleX, currRectangleY+50 , 50, 50);
					}
					System.out.println(invaderBounds.get(0).getX()+"--"+invaderBounds.get(0).getY());
					System.out.println(invaders.get(0).currx+ " -- "+invaders.get(0).curry);
					// System.out.println(invaderBounds.get(i).getY());
					finalInvaderY = invaders.get(i).curry + InvaderImage1.vy;
				}

				if (hitWall == true) {
					InvaderImage1.vy = InvaderImage1.vy + 50;
					InvaderImage1.vx = InvaderImage1.vx * -1;
					

				}
				star.update();

				repaint();

			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent d) {
		// TODO Auto-generated method stub
		player.moveRight();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}