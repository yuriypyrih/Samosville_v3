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
	private boolean left = true;
	private boolean active = false;
	private boolean job_is_done = false;
	private int startTimer;
	private int animation_tick = 0;
	private int sentX,sentY;
	
	private Image worker_left_img1 = new ImageIcon("res/run_right_1.png").getImage();
	private Image worker_left_img2 = new ImageIcon("res/run_right_2.png").getImage();
	private Image worker_left_img3 = new ImageIcon("res/run_right_3.png").getImage();
	private Image worker_left_img4 = new ImageIcon("res/run_right_4.png").getImage();
	private Image worker_left_img5 = new ImageIcon("res/run_right_5.png").getImage();
	private Image worker_left_img6 = new ImageIcon("res/run_right_6.png").getImage();
	private Image worker_left_img7 = new ImageIcon("res/run_right_7.png").getImage();
	private Image worker_left_img8 = new ImageIcon("res/run_right_8.png").getImage();
	
	private Image worker_right_img1 = new ImageIcon("res/run_left_1.png").getImage();
	private Image worker_right_img2 = new ImageIcon("res/run_left_2.png").getImage();
	private Image worker_right_img3 = new ImageIcon("res/run_left_3.png").getImage();
	private Image worker_right_img4 = new ImageIcon("res/run_left_4.png").getImage();
	private Image worker_right_img5 = new ImageIcon("res/run_left_5.png").getImage();
	private Image worker_right_img6 = new ImageIcon("res/run_left_6.png").getImage();
	private Image worker_right_img7 = new ImageIcon("res/run_left_7.png").getImage();
	private Image worker_right_img8 = new ImageIcon("res/run_left_8.png").getImage();

	public Worker(int x, int y, ID id, Handler handler, int sentX, int sentY) {
		super(x, y, id);
		startTimer = HUD.secondsPassed;
		
		this.handler = handler;
		
		for(int x_ = 0 ; x_ <= 24 ; x_++) {
			if(sentX >= x_  * 50 && sentX < x_ * 50 + 50) {
				sentX = x_;
				
			}
			
		}
		for(int y_ = 0 ; y_ <= 12 ; y_++) {
			if(sentY >= y_ * 50 && sentY < y_ * 50 + 50) {
				sentY = y_;
			}
		}
		
		this.sentX = sentX;
		this.sentY = sentY;
		
		HUD.workers--;
		
	}
	
	
	
	
	public  void tick(){
		if(HUD.secondsPassed - startTimer >= 1)
		{
			if(x < sentX) {
				x++;
				left = false;
			}
			else if(x > sentX)
			{
				x--;
				left = true;
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
					HUD.workers++;
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
		animation_tick++;
	}//end of tick()
	
	
	public  void render(Graphics g) {
		if(left) {
			if(animation_tick < 3) {
				g.drawImage(worker_left_img1, x * 50, y * 50, null);
			}
			else if(animation_tick < 6) {
				g.drawImage(worker_left_img2, x * 50, y * 50, null);
			}
			else if(animation_tick < 9) {
				g.drawImage(worker_left_img3, x * 50, y * 50, null);
			}
			else if(animation_tick < 12) {
				g.drawImage(worker_left_img4, x * 50, y * 50, null);
			}
			else if(animation_tick < 15) {
				g.drawImage(worker_left_img5, x * 50, y * 50, null);
			}
			else if(animation_tick < 18) {
				g.drawImage(worker_left_img6, x * 50, y * 50, null);
			}
			else if(animation_tick < 21) {
				g.drawImage(worker_left_img7, x * 50, y * 50, null);
			}
			else if(animation_tick < 23) {
				g.drawImage(worker_left_img8, x * 50, y * 50, null);
			}
			else {
				animation_tick = 0;
			}
		}else {
			if(animation_tick < 3) {
				g.drawImage(worker_right_img1, x * 50, y * 50, null);
			}
			else if(animation_tick < 6) {
				g.drawImage(worker_right_img2, x * 50, y * 50, null);
			}
			else if(animation_tick < 9) {
				g.drawImage(worker_right_img3, x * 50, y * 50, null);
			}
			else if(animation_tick < 12) {
				g.drawImage(worker_right_img4, x * 50, y * 50, null);
			}
			else if(animation_tick < 15) {
				g.drawImage(worker_right_img5, x * 50, y * 50, null);
			}
			else if(animation_tick < 18) {
				g.drawImage(worker_right_img6, x * 50, y * 50, null);
			}
			else if(animation_tick < 21) {
				g.drawImage(worker_right_img7, x * 50, y * 50, null);
			}
			else if(animation_tick < 23) {
				g.drawImage(worker_right_img8, x * 50, y * 50, null);
			}
			else {
				animation_tick = 0;
			}
		}
		
	}

}//end of Worker class
