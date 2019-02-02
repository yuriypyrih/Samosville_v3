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
	
	
	

	private final static int YOUR_BASE = 5;
	private final static int ENEMY_BASE = 100;
	private final static int CREATED_WORKERS = 1;
	private final static int AVAILABLE_WORKERS = 1;
	private final static int FOOD = 1;
	private final static int WOOD = 1;
	private final static int STONE = 2;
	private final static int WARRIOR_SPAWN_RATE = 20;
	
	
	
	public static int your_BASE = YOUR_BASE;
	public static int enemy_BASE = ENEMY_BASE;
	public static int available_workers = AVAILABLE_WORKERS;
	public static int created_workers = CREATED_WORKERS;
	public static int food = FOOD;
	public static int wood = WOOD;
	public static int stone = STONE;
	public static int warrior_spawn_rate = WARRIOR_SPAWN_RATE;
	
	private Handler handler;
	private boolean[] messages = new boolean[20];
	private boolean game_finished = false; // To check if the game is funished when displaying Victory or Defeat
	
	
	public static boolean SELECT_RESOURCE = false;
	
	
	private Image img_tab =  new ImageIcon("res\\tab.png").getImage();
	
	public HUD(Handler handler) {
		this.start();
		this.handler = handler;
		
		for(int i = 0 ; i < messages.length ; i++) {
			messages[i] = true;
		}
	}
	
	
	public static int secondsPassed = 0;
	
	Timer timer = new Timer();
	TimerTask task_seconds = new TimerTask() {
		public void run() {
			if(Game.gameState == STATE.Game) {
				secondsPassed++;
			}
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
		
		if(your_BASE <= 0 && !game_finished) {
			AudioPlayer.getSound("defeat").play(1f ,0.6f * AudioPlayer.sound_solume_multiplier);
			game_finished = true;
			Game.gameState = STATE.Defeat;
		}
		else if(enemy_BASE <= 0 && !game_finished) {
			AudioPlayer.getSound("victory").play(1f ,0.6f * AudioPlayer.sound_solume_multiplier);
			game_finished = true;
			Game.gameState = STATE.Victory;
			}
		
		
	}
	
	public void render(Graphics g) {
		
		
		Graphics2D graphics2 = (Graphics2D) g;
		
		
		
		
		graphics2.drawImage(img_tab,0,700,null);
		
		graphics2.setColor(Color.RED);
		
		//CREATE WORKER BUTTON
		if(wood>=1 && food >=2) {
			graphics2.setColor(Color.GREEN);
		}
		graphics2.drawRect(795, 705, 390, 41);
		graphics2.setColor(Color.RED);
				
		//SENT WORKER BUTTON
		if(SELECT_RESOURCE == true) {
			graphics2.setColor(Color.YELLOW);
		}
		else if(available_workers >0) {
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
		if(stone>=4 && wood >=3) {
			graphics2.setColor(Color.GREEN);
		}
		graphics2.drawRect(677, 708, 107, 138);
		
		
		
		graphics2.setColor(Color.BLACK);
		
		Font f = new Font ("Monospaced", Font.BOLD | Font.ITALIC, 18);
	    g.setFont (f);
		
		graphics2.drawString( secondsPassed + "sec", 280, 755);
		graphics2.drawString("" + food, 115, 747);
		graphics2.drawString("" + wood, 118, 780);
		graphics2.drawString("" + stone,120, 815);
		graphics2.drawString(available_workers + "/" + created_workers, 305, 810);
		
		graphics2.setColor(Color.GREEN);
		graphics2.drawString("" + your_BASE,511, 750);
		graphics2.setColor(Color.RED);
		graphics2.drawString("" + enemy_BASE, 527, 808);
		
		
		if(secondsPassed == 2 && messages[0]) {
			handler.addObject( new PopUpEffect(400,0,"message_1_welcome", handler));
			messages[0] = false;
		}
		else if(secondsPassed == 8 && messages[1]) {
			handler.addObject( new PopUpEffect(400,0,"message_2_sendworkers", handler));
			messages[1] = false;
		}
		else if(created_workers >= 4 && messages[2]) {
			handler.addObject( new PopUpEffect(400,0,"message_3_food", handler));
			messages[2] = false;
		}
		else if(enemy_BASE < 100 && messages[3]) {
			handler.addObject( new PopUpEffect(400,0,"message_4_firsthit", handler));
			messages[3] = false;
			warrior_spawn_rate = 18;
		}
		else if(enemy_BASE <= 50 && messages[4]) {
			handler.addObject( new PopUpEffect(400,0,"message_5_below50", handler));
			messages[4] = false;
			warrior_spawn_rate = 15;
		}
		else if(enemy_BASE <= 10 && messages[5]) {
			handler.addObject( new PopUpEffect(400,0,"message_6_bellow10", handler));
			messages[5] = false;
			warrior_spawn_rate = 8;
		}
		
	}
	
	public void reset() {
		
		secondsPassed = 0;
		
		for(int i = 0 ; i < messages.length ; i++) {
			messages[i] = true;
		}
		
		your_BASE = YOUR_BASE;  
		enemy_BASE = ENEMY_BASE;
		available_workers = AVAILABLE_WORKERS;  
		created_workers = CREATED_WORKERS;      
		food = FOOD;                            
		wood = WOOD;                            
		stone = STONE;                          
		warrior_spawn_rate = WARRIOR_SPAWN_RATE;
		
		game_finished = false;
		
		handler.clearGame();
	}
	
	
	
	


}







