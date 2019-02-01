package entities;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import engine.GameObject;
import engine.HUD;
import engine.Handler;
import engine.ID;
import engine.World;


public class Enemy_Warrior extends GameObject{
	
	private Handler handler;
	
	private int  animation_tick = 0;
	
	private int startTimer;
	private int sentX,sentY;
	
	//private Image empty_spot_img = new ImageIcon("res/empty_spot.png").getImage();
	private Image warrior_img0 = new ImageIcon("res/_RUN_000.png").getImage();
	private Image warrior_img1 = new ImageIcon("res/_RUN_001.png").getImage();
	private Image warrior_img2 = new ImageIcon("res/_RUN_002.png").getImage();
	private Image warrior_img3 = new ImageIcon("res/_RUN_003.png").getImage();
	private Image warrior_img4 = new ImageIcon("res/_RUN_004.png").getImage();
	private Image warrior_img5 = new ImageIcon("res/_RUN_005.png").getImage();
	private Image warrior_img6 = new ImageIcon("res/_RUN_006.png").getImage();
	
	

	public Enemy_Warrior(int x, int y, ID id, Handler handler, int sentX, int sentY) {
		super(x, y, id);
		startTimer = HUD.secondsPassed;
		
		this.handler = handler;
		this.sentX = sentX;
		this.sentY = sentY;
		
	
		
	}
	
	
	
	
	public  void tick(){
		if(HUD.secondsPassed - startTimer >= 1)
		{
			
			/*HIT YOUR BASE*/
			if ( x == sentX && y == sentY) {
				
				HUD.your_BASE -= 5;
				handler.removeObject(this);
			}
			else if(World.cworld[y][x+1] == 'P') {
				x++;
			}
			else if(World.cworld[y+1][x] == 'P')
			{
				y++;
			}
			
			
			
			startTimer = HUD.secondsPassed;
		}//end of if
		
		animation_tick++;
	}//end of tick()
	
	
	public  void render(Graphics g) {
		if(animation_tick < 3) {
			g.drawImage(warrior_img0, x * 50, y * 50, null);
		}
		else if(animation_tick < 6) {
			g.drawImage(warrior_img1, x * 50, y * 50, null);
		}
		else if(animation_tick < 9) {
			g.drawImage(warrior_img2, x * 50, y * 50, null);
		}
		else if(animation_tick < 12) {
			g.drawImage(warrior_img3, x * 50, y * 50, null);
		}
		else if(animation_tick < 15) {
			g.drawImage(warrior_img4, x * 50, y * 50, null);
		}
		else if(animation_tick < 18) {
			g.drawImage(warrior_img5, x * 50, y * 50, null);
		}
		else if(animation_tick < 20) {
			g.drawImage(warrior_img6, x * 50, y * 50, null);
		}
		else {
			animation_tick = 0;
		}
		
	}

}//end of Worker class
