import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
//Trisha Ruiz
//9/12/17

public class MyStory extends JComponent implements MouseListener {

	public static String nameOfApp = "Your Adventure!";
	public static int state = 0;
	public static int min;
	public static int max;
	public static int range;
	public int randomNum;
	public boolean threwNet = false;
	public boolean killedUnicorn = false;
	public boolean caughtUnicornPokeball = false;
	public int [] powerLevelList = new int [3];
	public int [] costOfUnicorn = new int [3];
	public String powerResult = new String("hi");

	public MyStory() {
		addMouseListener(this);
		
		
	}
	
	public void setCostUnicorn(int finalCostUnicorn){
		if (finalCostUnicorn < powerLevelList.length) {
			costOfUnicorn[finalCostUnicorn]= (int)(Math.random()*3);
			//printCostUnicorn(0);
			
			System.out.println(powerLevelList[finalCostUnicorn]);
			
		}else{
			return;
		}
		
	}
	//public int getCostUnicorn(int finalCostUnicorn){
	public void printCostUnicorn (int finalCostUnicorn){
		if (finalCostUnicorn < powerLevelList.length) {
			costOfUnicorn[finalCostUnicorn]= (int)(Math.random()*3);
			System.out.println("power level"+powerLevelList[finalCostUnicorn]);
			//setCostUnicorn(0);
		}else{
			return;
		}
		
	}
	public void setPowerLevel(int finalPowerLevel){
		if (finalPowerLevel < powerLevelList.length) {
			powerLevelList[finalPowerLevel]=(int)(Math.random()*3);
			System.out.println(powerLevelList[finalPowerLevel]);
		}
		
	}

	public void writePowerLevel(int finalPowerLevel) {
		setPowerLevel(0);
		if (powerLevelList[finalPowerLevel]== 0){
			System.out.println("It's not very effective...");
			powerResult = "It's not very effective...";
			killedUnicorn = false;
		}else if (powerLevelList[finalPowerLevel] == 1){
			System.out.println("It's effective.");
			powerResult = "It's effective.";
			killedUnicorn = true;
		}else if (powerLevelList[finalPowerLevel] == 2){
			System.out.println("It's very effective!");
			powerResult = "It's very effective!";
			killedUnicorn = true;
		}

	}
	public void paint(Graphics g) {
		setCostUnicorn(0);
		if (state == 0) {
			startScreen(g);
		}
		if (state == 1) {
			leftPath(g);
		}
		if (state == 2) {
			rightPath(g);
			
		}
		if (state == 3) {
			//end
			petTheUnicorn(g);
		}
		if (state == 4) {
			killTheUnicorn(g);
		}
		if (state == 5) {
			//end
			toTheSea(g);
		}
		if (state == 6) {
			toTheMountains(g);
		}
		if (state == 7) {
			//end
			slayTheDragon(g);
		}
		if (state == 8) {
			rideTheDragon(g);
		}
		if (state == 9) {
			exploreRightPath(g);
		}
		if (state == 10) {
			//end
			settleAtCastle(g);
		}
		if (state == 11) {
			//end
			apologizeToUnicorns(g);
		}
		if (state == 12) {
			runAhead(g);
		}
		if (state == 13) {
			crossBridge(g);
		}
		if (state == 14) {
			enterCave(g);
		}
		if (state == 15) {
			shield(g);
		}
		if (state == 16) {
			sword(g);
		}
		if (state == 17) {
			//end
			keepShield(g);
		}
		if (state == 18) {
			//end
			discardShield(g);
		}
		if (state == 19) {
			//end
			makeHome(g);
		}
		if (state == 20) {
			leaveCave(g);
		}
		if (state == 21) {
			//end
			ignoreWounds(g);
		}
		if (state == 22) {
			//end
			goDoctor(g);
		}
		if (state == 23) {
			//end
			keepWalking(g);
		}
		if (state == 24) {
			//end
			visitCabin(g);
		}
		if (state == 25) {
			leftAlternateUni(g);
		}
		if (state == 26) {
			caughtUnicorn(g);
		}
		if (state == 27) {
			rightAlternateUni(g);
		}
		if (state == 28){
			howToKillUnicorn(g);
		}
		if (state == 29) {
			pokeball(g);
		}
		if (state == 30) {
			splash(g);
		}
	}
	public void splash(Graphics g) {
		g.drawString("You use splash", 130, 30);
		if (killedUnicorn == false){
			g.drawString(powerResult, 130, 50);
			g.drawString("You fail to kill the Unicorn", 130, 70);
			g.drawString("So it chases you off a cliff instead", 130, 90);
			g.drawString("The End", 200, 120);
			g.drawString("Start Over", 200, 400);
		}else{
			//killTheUnicorn
			System.out.println("not");
			state = 4;
			repaint();
			System.out.println(state);
		}
		
	}

	public void pokeball(Graphics g) {
		g.drawString(powerResult, 130, 50);
		g.drawString("But it isn't a pokemon anyway", 130, 70);
		g.drawString("It doesn't work and you get chased of a cliff instead", 130, 90);
		g.drawString("The End", 200, 120);
		g.drawString("Start Over", 200, 400);
		
	}

	public void howToKillUnicorn(Graphics g) {
		g.drawString("How do you want to take down the Unicorn?", 110, 50);
		g.drawString("throw a pokeball", 100, 150);
		g.drawString("splash", 300, 150);
		
	}

	public void rightAlternateUni(Graphics g) {
		g.drawString("The right path is the wrong way!", 140,50);
		g.drawString("You lose the game.", 180, 80);
		g.drawString("The End", 200, 120);
		g.drawString("Start Over", 200, 400);
		
	}

	public void caughtUnicorn(Graphics g) {
		g.drawString("You successfully catch the unicorn", 130, 50);
		g.drawString("You sell it off to bounty hunters.", 130, 70);
		g.drawString("And become the richest person on earth.", 130, 90);
		g.drawString("The End", 220, 150);
		g.drawString("Start Over", 200, 400);
		
	}

	//generates the random number
	public int genRandomNum(int minVal, int maxVal) {
		max = maxVal;
		min = minVal;
		range = (max - min)+1;
		int randomNum = (int)(Math.random()* range)+min;
		System.out.print("randomNum = "+ randomNum);
		return randomNum;
	}
	public void startScreen(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString("Your Adventure Starts Here!", 150, 50);
		g.drawString("Which path would you like to take?", 140, 70);
		g.drawString("Left", 100, 150);
		g.drawString("Right", 300, 150);

	}

	public void leftPath(Graphics g) {
		if (threwNet == false) {
			g.drawString("You're in the left path.", 180, 50);
			g.drawString("Here you are met with a unicorn.", 155, 70);
			g.drawString("What do you do?", 195, 100);
			g.drawString("Pet the Unicorn", 100, 150);
			g.drawString("Kill the Unicorn", 300, 150);
			g.drawString("Throw a net to catch it", 184, 190);
		} else {
			g.drawString("Aww, so close, but the Unicorn did", 155, 50);
			g.drawString("not get caught in the net.", 180, 70);
			g.drawString("What do you do?", 195, 100);
			g.drawString("Pet the Unicorn", 100, 150);
			g.drawString("Kill the Unicorn", 300, 150);
		}
	}

	public void rightPath(Graphics g) {
		g.drawString("You take the right path.", 180, 50);
		g.drawString("Here you are met with a T-Rex.", 155, 70);
		g.drawString("What do you do?", 195, 100);
		g.drawString("Turn back and go to the Left Path", 50, 150);
		g.drawString("Run Ahead. YOLO!", 300, 150);
	}


	public void petTheUnicorn(Graphics g) {
		// END
		g.drawString("You decide the Unicorn is Friendly so", 130, 50);
		g.drawString("you walk up to it and begin petting it.", 130, 70);
		g.drawString("The Unicorn gets scared and charges at you.", 130, 90);
		g.drawString("You accidentally fall off a cliff while trying to run away.", 130, 110);
		g.drawString("The End", 220, 150);
		g.drawString("Start Over", 200, 400);
	}
	public void killTheUnicorn(Graphics g) {
		if (killedUnicorn == true){
			g.drawString(powerResult, 180, 30);
		}
		g.drawString("You kill the Unicorn with your sword", 150, 50);
		g.drawString("Knowing that it will give you the ability to fly.", 130, 70);
		g.drawString("Where do you fly to?", 175, 90);
		g.drawString("To the Sea", 80, 150);
		g.drawString("To the Mountains", 300, 150);


	}
	public void toTheSea(Graphics g) {
		// END
		g.drawString("You fly to the sea forgetting it's inhabited with monsters.", 110, 50);
		g.drawString("A kracken drags you from the sky into the sea.", 110, 70);
		g.drawString("The End", 220, 150);
		g.drawString("Start Over", 200, 400);
	}
	public void toTheMountains(Graphics g) {
		g.drawString("You fly to the Mountains", 170, 50);
		g.drawString("And meet a dragon", 180, 70);
		g.drawString("What do you do?", 185, 90);
		g.drawString("Slay the Dragon", 80, 150);
		g.drawString("It's friendly. Go for a ride.", 300, 150);
	}
	public void slayTheDragon(Graphics g) {
		//END
		g.drawString("You slay the Dragon", 170, 50);
		g.drawString("Good Job.", 190, 70);
		g.drawString("But its mother wakes up from its slumber, who is 10 times", 100, 90);
		g.drawString("larger than its child's size.", 145, 110);
		g.drawString("You make a good dragon snack. :)", 125, 130);
		g.drawString("Start Over", 200, 400);
		g.drawString("The End", 190, 170);
	}
	public void rideTheDragon(Graphics g) {
		g.drawString("You go for ride, but turns out the dragon isn't friendly", 120, 50);
		g.drawString("You fall off the dragon, but luckily you have the ability to fly.", 100, 70);
		g.drawString("You fly safely away from the mountains and find yourself bored.",100, 90);
		g.drawString("What now?", 225, 120);
		g.drawString("Go explore the right path.", 50, 150);
		g.drawString("Settle down at some castle that you saw", 240, 150);
		
	}
	public void exploreRightPath(Graphics g) {
		g.drawString("On your way to the left path though", 120, 50);
		g.drawString("The family of the Unicorn you killed appears.", 100, 70);
		g.drawString("What do you do?", 185, 90);
		g.drawString("Hurry to the right path.", 50, 150);
		g.drawString("Go apologize to the Unicorns", 240, 150);
	}
	public void settleAtCastle(Graphics g) {
		g.drawString("Have You forgotten!?", 170, 50);
		g.drawString("You're one of the most wanted fugitives.", 130, 70);
		g.drawString("In the castle you get arrested", 150, 90);
		g.drawString("and spend the rest of your life in a jail cell.", 110, 110);
		g.drawString("Start Over", 200, 400);
		g.drawString("The End", 190, 170);
	}
	public void apologizeToUnicorns (Graphics g) {
		g.drawString("You go apologize to the Unicorns.", 150, 50);
		g.drawString("But of course they don't understand.", 150, 70);
		g.drawString("And end up chasing you to your death.", 150, 90);
		g.drawString("Start Over", 200, 400);
		g.drawString("The End", 190, 170);
	}
	
	//right path
	
	public void runAhead (Graphics g) {
		g.drawString("You decide to run ahead", 155, 50);
		g.drawString("And make it safely away from the T-rex.", 130, 70);
		g.drawString("You see a cave and bridge before you.", 130,90);
		g.drawString("What do you do?", 175, 130);
		g.drawString("Cross the Bridge", 80, 150);
		g.drawString("Enter the Cave", 280, 150);
	}
	public void crossBridge (Graphics g) {
		g.drawString("When you make it across the bridge", 140, 50);
		g.drawString("You are presented two weapons.", 145, 70);
		g.drawString("Which do you take?", 175, 100);
		g.drawString("Shield", 100, 150);
		g.drawString("Sword", 300, 150);
		
	}
	public void shield (Graphics g) {
		g.drawString("You continue on and turns out", 140, 50);
		g.drawString("your next path has random marksmen shooting at you", 100, 70);
		g.drawString("With your shield you're able to block all the arrows off", 95, 90);
		g.drawString("and escape safely.", 180, 110);
		g.drawString("Now what?", 200, 130);
		g.drawString("You keep the shield with you.", 40, 150);
		g.drawString("Discard the shield.", 260, 150);
	}
	public void keepShield (Graphics g) {
		g.drawString("Keeping the shield you become invincible", 110, 50);
		g.drawString("Along with that you become the hero of the kingdom.", 100, 70);
		g.drawString("The king awards you with your very own castle.", 95, 90);
		g.drawString("So you no longer have to explore neither the left or right path.", 50, 110);
		g.drawString("The End", 200, 130);
		g.drawString("Start Over", 200, 400);
	}
	public void discardShield (Graphics g) {
		g.drawString("You discard the shield and become vulnerable to", 115, 50);
		g.drawString("the other monsters on your path.", 120, 70);
		g.drawString("Sadly, ending your life as their next meal.", 110, 90);
		g.drawString("The End", 200, 130);
		g.drawString("Start Over", 200, 400);
	}
	public void sword (Graphics g) {
		g.drawString("You continue on and turns out", 140, 50);
		g.drawString("your next path has random marksmen shooting at you", 100, 70);
		g.drawString("With your sword you're able to block some of the arrows off", 85, 90);
		g.drawString("but still get severely injured.", 160, 110);
		g.drawString("Now what?", 200, 130);
		g.drawString("The wounds are nothing.", 50, 150);
		g.drawString("it wil be fine.", 50, 170);
		g.drawString("Hurry to the village doctor.", 300, 150);
	}
	public void ignoreWounds (Graphics g) {
		g.drawString("Your wounds only worsen as you try to continue", 115, 50);
		g.drawString("to explore the path.", 190, 70);
		g.drawString("Next thing you know it everything around you turns dark.", 100, 90);
		g.drawString("The End", 200, 150);
		g.drawString("Start Over", 200, 400);
	}
	public void goDoctor (Graphics g) {
		g.drawString("Your wounds are healed by the village doctor", 115, 50);
		g.drawString("With that you become interested in the study in medicine.", 100, 70);
		g.drawString("The doctor takes you as his apprentice letting you settle down.", 90, 90);
		g.drawString("from your exploration of the right path.", 140, 110);
		g.drawString("The End", 200, 150);
		g.drawString("Start Over", 200, 400);
	}
	public void enterCave (Graphics g) {
		g.drawString("The cave is full of resources.", 140, 50);
		g.drawString("Enough to be a home", 159, 70);
		g.drawString("What do you do?", 166, 100);
		g.drawString("Make it your home.", 70, 150);
		g.drawString("Stay for a few days and then leave.", 240, 150);
	}
	public void makeHome (Graphics g) {
		g.drawString("Well, after few days", 180, 50);
		g.drawString("a family of bears who used to live there finds you sleeping in their cave", 60, 70);
		g.drawString("Luckily, they're friendly and only kick you out", 100, 90);
		g.drawString("But since it's in the middle of winter", 130, 110);
		g.drawString("You meet your demise buried under snow", 104, 130);
		g.drawString("The End", 200, 150);
		g.drawString("Start Over", 200, 400);
	}
	public void leaveCave (Graphics g) {
		g.drawString("Well, after few days", 170, 50);
		g.drawString("of relaxing in the cave. You set off to continue onto the right path.", 65, 70);
		g.drawString("You're able to bring some of the cave resources", 100, 90);
		g.drawString("with you, helping you survive through the harsh winter", 130, 110);
		g.drawString("conditions. At the end of the path you find a cabin.", 100, 130);
		g.drawString("What do you do?", 166, 150);
		g.drawString("Keep on walking past it.", 70, 190);
		g.drawString("Visit the cabin.", 240, 190);
	}
	public void keepWalking (Graphics g) {
		g.drawString("Past the Cabin you find a mountain", 140, 50);
		g.drawString("At the start it's an easy climb", 145, 70);
		g.drawString("But the conditions only worsen.", 145, 90);
		g.drawString("Suddenly an avalanche devours you.", 135, 110);
		g.drawString("The End", 200, 150);
		g.drawString("Start Over", 200, 400);
	}
	public void visitCabin (Graphics g) {
		g.drawString("The cabin is empty, but makes a", 140, 50);
		g.drawString("suitable home for you. No one", 145, 70);
		g.drawString("seems to own it so you decide to make it", 135, 90);
		g.drawString("your home. With the cave resources you're.", 135, 110);
		g.drawString("able to live in the cabin peacefully.", 140, 130);
		g.drawString("Settling you down from your exploration.", 135, 150);
		g.drawString("Of the right path.", 190, 170);
		g.drawString("The End", 200, 210);
		g.drawString("Start Over", 200, 400);
	}
	public void leftAlternateUni (Graphics g) {
		g.drawString("The left path is the wrong way!", 140,50);
		g.drawString("You lose the game.", 180, 80);
		g.drawString("The End", 200, 120);
		g.drawString("Start Over", 200, 400);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX() + "," + e.getY());
		// generate random number
		// start over button
		if (state == 3 || state == 5 || state == 7 || state == 10 || state == 11 || state == 17 || state == 18
				|| state == 19 || state == 21 || state == 22 || state == 23 || state == 24||state == 25||state == 26||
				state == 27|| state == 30|| state == 29) {
		if (e.getX() > 200 && e.getX() < 255 && e.getY() > 390 && e.getY() < 400) {
			threwNet = false;
			killedUnicorn = false;
			caughtUnicornPokeball = false;
			state = 0;
		}
		}
		// starting options
		if (state == 0) {

			if (e.getX() > 100 && e.getX() < 120 && e.getY() > 140 && e.getY() < 150) {
				// Left or leftalternate universe
				if (genRandomNum(1, 5) == 1) {
					state = 25;
				}else {
					state = 1;	
				}
			}
			if (e.getX() > 300 && e.getX() < 328 && e.getY() > 140 && e.getY() < 153) {
				if (genRandomNum(10, 14) == 13) {
					state = 27;
				}else {
				// Right
				state = 2;
				}
			}
		} else if (state == 1) { //left path options
			if (e.getX() > 100 && e.getX() < 180 && e.getY() > 140 && e.getY() < 153) {
				// Pet the Unicorn
				state = 3;
			} else if (e.getX() > 300 && e.getX() < 380 && e.getY() > 140 && e.getY() < 153) {
				// Kill the Unicorn
				state = 28;
				
			} else if (e.getX() > 183 && e.getX() < 302 && e.getY() > 180 && e.getY() < 190) {
				// throw a net to catch it
				if (genRandomNum(5, 8) == 5) {
					//if unicorn is caught
					state = 26;
				}else {
					//if unicorn not caught
					threwNet = true;
					state = 1;
				}
			}
		}  else if (state == 28) { // right path options
			if (e.getX() > 98 && e.getX() < 190 && e.getY() > 140 && e.getY() < 153) {
				//throw a pokeball
				writePowerLevel(0);
				
				
			}
			if  (e.getX() > 300 && e.getX() < 340 && e.getY() > 140 && e.getY() < 153) {
				//splash
				writePowerLevel(0);
				state = 30;
			}
		} else if (state == 2) { // right path options
			if (e.getX() > 50 && e.getX() < 230 && e.getY() > 140 && e.getY() < 153) {
				//turn back to left path
				state = 1;
				
			}
			if  (e.getX() > 300 && e.getX() < 400 && e.getY() > 140 && e.getY() < 153) {
				//Run ahead
				state = 12;
			}
		}
			else if (state == 4){
			if (e.getX() > 80 && e.getX() < 138 && e.getY() > 140 && e.getY() < 153) {
				//to the Sea
				state = 5;
			}
			if (e.getX() > 295 && e.getX() < 395 && e.getY() > 140 && e.getY() < 153) {
				//to the Mountains
				state = 6;
			} 
		}else if (state == 6) {
			if (e.getX() > 80 && e.getX() < 166 && e.getY() > 140 && e.getY() < 153) {
				//Slay the dragon
				state = 7;

			}
			if (e.getX() > 300 && e.getX() < 431 && e.getY() > 140 && e.getY() < 153) {
				//ride the dragon
				state = 8;
			}
		}else if (state == 8) {
			if (e.getX() > 50 && e.getX() < 175 && e.getY() > 140 && e.getY() < 153) {
				//explore left path
				state = 9;
			}
			if  (e.getX() > 240 && e.getX() < 460 && e.getY() > 140 && e.getY() < 153) {
				// settle down at castle
				state = 10;
			}
		}else if (state == 9) {
			if (e.getX() > 50 && e.getX() < 165 && e.getY() > 140 && e.getY() < 153) {
				//explore to the right path
				state = 2;
				
			}
			if  (e.getX() > 240 && e.getX() < 400 && e.getY() > 140 && e.getY() < 153) {
				//apologize to Unicorns
				state = 11;
			}
		}else if (state ==12) {
			if (e.getX() > 77 && e.getX() < 174 && e.getY() > 140 && e.getY() < 153) {
				//Cross the Bridge
				state = 13;
				
			}
			if  (e.getX() > 278 && e.getX() < 360 && e.getY() > 140 && e.getY() < 153) {
				//enter the cave
				state = 14;
			}

		}else if (state == 13) {//cross bridge
			if (e.getX() > 98 && e.getX() < 135 && e.getY() > 140 && e.getY() < 153) {
				//shield
				state = 15;
			
				
			}
			if  (e.getX() > 298 && e.getX() < 335 && e.getY() > 140 && e.getY() < 153) {
				//sword
				state = 16;
			}
		}else if(state == 15) {//shield
			 if  (e.getX() > 40 && e.getX() < 196 && e.getY() > 140 && e.getY() < 153) {
				 
				//keep shield
				state = 17;
			}
			if  (e.getX() > 259 && e.getX() < 362 && e.getY() > 140 && e.getY() < 153) {
				//discard shield
				state = 18;
			}
			
		}else if (state == 16) {//sword
			 if  (e.getX() > 48 && e.getX() < 185 && e.getY() > 140 && e.getY() < 172) {
				 
				//ignore wounds
				state = 21;
			}
			if  (e.getX() > 300 && e.getX() < 440 && e.getY() > 140 && e.getY() < 153) {
				//go doctor
				state = 22;
			}
		}else if(state == 14) {//cave
			
			 if  (e.getX() > 68 && e.getX() < 172 && e.getY() > 140 && e.getY() < 153) {
				 
				//make home
				state = 19;
			}
			if  (e.getX() > 239 && e.getX() < 426 && e.getY() > 140 && e.getY() < 153) {
				//leave cave
				state = 20;
				
			}

		}else if(state == 20) {// leave cave
			 if  (e.getX() > 68 && e.getX() < 200 && e.getY() > 178 && e.getY() < 190) {
				 
				//keep walking
				state = 23;
			}
			if  (e.getX() > 237 && e.getX() < 318 && e.getY() > 178 && e.getY() < 190) {
				//visit cabin
				state = 24;
			}
		}

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		state = 0;
		threwNet = false;
		
		repaint();

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame(nameOfApp);
		frame.getDefaultCloseOperation();
		frame.add(new MyStory());
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.white);
	}

}