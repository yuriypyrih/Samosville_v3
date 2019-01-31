package entities;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import engine.GameObject;
import engine.HUD;
import engine.Handler;
import engine.ID;


public class Worker extends GameObject{
	
	private Handler handler;
	private char holdingMaterial;
	private boolean active = false;
	private boolean job_is_done = false;
	private int startTimer;
	private int sentX,sentY;
	
	private Image empty_spot_img = new ImageIcon("res/empty_spot.png").getImage();

	public Worker(int x, int y, ID id, Handler handler, int sentX, int sentY) {
		super(x, y, id);
		startTimer = HUD.secondsPassed;
		
		this.handler = handler;
		
		for(int x_ = 0 ; x_ < 24 ; x_++) {
			if(sentX >= x_  * 50 && sentX < x_ * 50 + 50) {
				sentX = x_;
				
			}
			
		}
		for(int y_ = 0 ; y_ < 12 ; y_++) {
			if(sentY >= y_ * 50 && sentY < y_ * 50 + 50) {
				sentY = y_;
			}
		}
		
		this.sentX = sentX;
		this.sentY = sentY;
		
	}
	
	
	
	
	public  void tick(){
		if(HUD.secondsPassed - startTimer >= 1)
		{
			if(x < sentX) {
				x++;
			}
			else if(x > sentX)
			{
				x--;
			}
			else if(y < sentY)
			{
				y++;
			}
			else if(y >sentY)
			{
				y--;
			}
			else if ( x == sentX && y == sentY) {
				if(job_is_done) {
					
					HUD.updateMaterial(holdingMaterial);
					handler.removeObject(this);
				}
				holdingMaterial = HUD.consumeMaterial(this);
				System.out.println("Taked Material:"+ holdingMaterial);
				sentY = 12;
				sentX = 20;
				
				job_is_done = true;
				
			}
			
			startTimer = HUD.secondsPassed;
		}//end of if
	}//end of tick()
	
	
	public  void render(Graphics g) {
		g.drawImage(empty_spot_img, x * 50, y * 50, null);
	}

}//end of Worker class
