package engine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;

/*Heads Up Display class*/


public class HUD {
	
	public static float HEALTH = 100; 
	private float greenValue = 255; // Health bar changing color
	
	private int score = 0;
	private int innerLevel = 1;
	private int stars = 0;
	private String diff = "NORMAL";
	
	private Image img_tab =  new ImageIcon("res\\tab.png").getImage();
	
	//RoundRectangle2D roundedRectangle, roundedRectangleHP, roundedRectangleBorder;
	
			
	

	
	
	public void tick() {
		
		
		
	}
	
	public void render(Graphics g) {
		
		
		Graphics2D graphics2 = (Graphics2D) g;
		
		
		
		
		graphics2.drawImage(img_tab,0,700,null);
		
		
	}
	
	public void reset() {
		HEALTH = 100;
		score = 0;
		innerLevel = 0;
		stars = 0;
		
	}
	
	public void insertDiff(int diff) {
		if(diff == 0 ) {
			this.diff = "EASY";
		}else if(diff == 1 ) {
			this.diff = "NORMAL";
		}else if(diff == 2 ) {
			this.diff = "HARD";
		}
	}
	
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	
	
	
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setStageTimer(int level) {
		this.innerLevel = level;
	}
	
	public int getStageTimer() {
		return innerLevel;
	}
	


}







