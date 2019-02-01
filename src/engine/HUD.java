package engine;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

/*Heads Up Display class*/


public class HUD {
	
	public static int your_BASE = 100;
	public static int enemy_BASE = 100;
	
	public static int workers = 1;
	public static int warriors = 0;
	public static int food = 0;
	public static int wood = 0;
	public static int stone = 0;
	
	
	public static boolean SELECT_RESOURCE = false;
	
	
	private Image img_tab =  new ImageIcon("res\\tab.png").getImage();
	
	public HUD() {
		this.start();
	}
	
	
	public static int secondsPassed = 0;
	
	Timer timer = new Timer();
	TimerTask task_seconds = new TimerTask() {
		public void run() {
			secondsPassed++;
			System.out.println("Seconds passed: " + secondsPassed);
		}
	};
	
	public void start() {
		//MILISECONDS
		timer.scheduleAtFixedRate(task_seconds, 1000, 1000);
	}
	
	
	public static char consumeMaterial(GameObject object)
	{
		switch(World.cworld[object.getY()][object.getX()]) {
		case 'T' :
			World.cworld[object.getY()][object.getX()] = 'G';
			return 'T';
			
		case 'S' :
			World.cworld[object.getY()][object.getX()] = 'G';
			return 'S';
			
		case 'C' :
			World.cworld[object.getY()][object.getX()] = 'G';
			return 'C';
			
		default:
			return 'G';
				
		}
	}
	public static void updateMaterial(char type)
	{
		System.out.println("Material: " + type );
		switch(type) {
		case 'T' :
			wood += 2;
			break;
		case 'S' :
			stone += 2;
			break;
		case 'C' :
			food += 2;
			break;
		}
	}
	

	
	
	public void tick() {
		
		
		
	}
	
	public void render(Graphics g) {
		
		
		Graphics2D graphics2 = (Graphics2D) g;
		
		
		
		
		graphics2.drawImage(img_tab,0,700,null);
		
		graphics2.setColor(Color.RED);
		
		//CREATE WORKER BUTTON
		if(stone>=1 && food >=2) {
			graphics2.setColor(Color.GREEN);
		}
		graphics2.drawRect(795, 705, 390, 41);
		graphics2.setColor(Color.RED);
				
		//SENT WORKER BUTTON
		if(workers>0) {
			graphics2.setColor(Color.GREEN);
		}
		graphics2.drawRect(795, 754, 390, 41);
		graphics2.setColor(Color.RED);
		
		//DEPLOY WARRIOR BUTTON
		if(stone>=3 && food >=1 && wood>=1) {
			graphics2.setColor(Color.GREEN);
		}
		graphics2.drawRect(795, 802, 390, 41);
		graphics2.setColor(Color.RED);
		
		//REPAIR CASTLE BUTTON
		if(stone>=5 && wood >=2) {
			graphics2.setColor(Color.GREEN);
		}
		graphics2.drawRect(677, 708, 107, 138);
		
		
		
		graphics2.setColor(Color.BLACK);
		
		Font f = new Font ("Monospaced", Font.BOLD | Font.ITALIC, 18);
	    g.setFont (f);
		
		graphics2.drawString( secondsPassed + "sec", 325, 750);
		graphics2.drawString("" + food, 115, 747);
		graphics2.drawString("" + wood, 118, 780);
		graphics2.drawString("" + stone,120, 815);
		graphics2.drawString("" + workers, 340, 810);
		
		graphics2.setColor(Color.GREEN);
		graphics2.drawString("" + your_BASE,533, 763);
		graphics2.setColor(Color.RED);
		graphics2.drawString("" + enemy_BASE, 549, 823);
		
	}
	
	public void reset() {
		
		secondsPassed = 0;
	}
	
	
	
	


}







