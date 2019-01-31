package engine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

/*Heads Up Display class*/


public class HUD {
	
	private static int workers = 1;
	private static int warriors = 0;
	private static int food = 0;
	private static int wood = 0;
	private static int stone = 0;
	
	
	public static boolean SELECT_RESOURCE = false;
	
	
	private Image img_tab =  new ImageIcon("res\\tab.png").getImage();
	
	public HUD() {
		this.start();
	}
	
	
	public static int secondsPassed = 0;
	
	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			secondsPassed++;
			System.out.println("Seconds passed: " + secondsPassed);
		}
	};
	
	public void start() {
		//MILISECONDS
		timer.scheduleAtFixedRate(task, 1000, 1000);
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
		graphics2.drawRect(800, 800, 70, 40);
		graphics2.drawString("Sent Worker", 800, 800);
		
		graphics2.setColor(Color.BLACK);
		graphics2.drawString("FOOD: " + food, 100, 750);
		graphics2.drawString("WOOD: " + wood, 100, 765);
		graphics2.drawString("STONE: " + stone, 100, 780);
		graphics2.drawString("WARRIORS: " + warriors, 100, 795);
		graphics2.drawString("WORKERS: " + workers, 100, 810);
		
	}
	
	public void reset() {
		
		
	}
	
	


}







