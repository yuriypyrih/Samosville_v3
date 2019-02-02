package engine;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;


import javax.swing.ImageIcon;

public class PopUpEffect extends GameObject{
	
	private float alpha = 0.06f;
	private int tripleWarning = 6; // 2 rounds per warning
	private int singleWarning = 2; // 2 rounds per warning
	
	private Handler handler;
	
	private float life, appear_life;
	private int whichWarning; // 0 = slashing , 1 = repearing your base  , 3 = pop up message
	private int shift_y_position;
	
	private Image effect_img, secondary_effect_img;
	private int timer = 0;
	private boolean fade_out = false;
	
	private GameObject object;
	
	
	//life = 0.001 BIG to 0.1 SMALL
	
	
	public PopUpEffect(int x, int y,int whichWarning, Handler handler) {
		super(x, y, ID.PopUpEffect);
		
		this.x = x;
		this.y = y;
		this.whichWarning = whichWarning;
		
			if(whichWarning == 0) {
				effect_img = new ImageIcon("res/slash.png").getImage();
				secondary_effect_img = new ImageIcon("res/minus5.png").getImage();
				shift_y_position = y;
				
				alpha = 0.06f;
			}else if(whichWarning == 1) {
				effect_img = new ImageIcon("res/plus20.png").getImage();
				shift_y_position = y;
				
				alpha = 0.06f;
			}
			
		
		this.handler = handler;
		life = 0.05f;
		
		
		
	}
	
	//PopUp Message
	public PopUpEffect(int x, int y,String str_img, Handler handler) {
		super(x, y, ID.PopUpEffect);
		
		this.x = x;
		this.y = y;
		this.whichWarning = 3;
		
		AudioPlayer.getSound("pop").play(1f,0.6f);
		
		alpha = 0.06f;
		effect_img = new ImageIcon("res/" + str_img + ".png").getImage();
			
			
			
		
		this.handler = handler;
		life = 0.01f;
		appear_life = 0.04f;
		
		
		
	}
	
	public PopUpEffect(GameObject object,int whichWarning, Handler handler) {
		super(object.getX(), object.getY(), ID.PopUpEffect);
		
		this.object = object;
		this.whichWarning = whichWarning;
		
		
		
		if(whichWarning == 3) {
			effect_img = new ImageIcon("res/scope_icon.png").getImage();
			alpha = 0.06f;
		}
		
		
		this.handler = handler;
		life = 0.05f;
	}
	
	public void tick() {
		
		
		/*SLASHs WARNING*/
		if(whichWarning == 0) {
			
			shift_y_position++;
			if(singleWarning > 0) {
				
				if(alpha >= 0.8 || alpha <= 0.01) {
					singleWarning--;
					life *= -1;
				}
				alpha += life ;
				if(alpha >= 1) alpha = 1;
			
			}else handler.removeObject(this);
		}
		/*REPEAR CASTLE EFFECT*/
		else if(whichWarning == 1) {
			
			shift_y_position--;
			if(singleWarning > 0) {
				
				if(alpha >= 0.8 || alpha <= 0.01) {
					singleWarning--;
					life *= -1;
				}
				alpha += life ;
				if(alpha >= 1) alpha = 1;
			
			}else handler.removeObject(this);
		}
		/*POP UP MESSAGE EFFECT*/
		else if(whichWarning == 3) {
			
			
			timer++;
			
			if(!fade_out) {

				alpha += appear_life ;
				if(alpha >= 1) {
					alpha = 1;
					fade_out = true;
				}
			}
			else {
				if(timer>260) {
					
					alpha -= life ;
					if(alpha <= 0)  handler.removeObject(this);
				
				}
			}
			
			
		}
}
		
	
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		if(whichWarning == 0) {
			g.drawImage(effect_img, x, y, null);
			g.drawImage(secondary_effect_img, x,shift_y_position, null);
		
		} 
		else if(whichWarning == 1) {
			g.drawImage(effect_img, x, shift_y_position, null);
			
		
		} 
		else if(whichWarning == 3) {
			g.drawImage(effect_img,x,y, null);
		
		} 
		else if(whichWarning == 6) {
			//g.drawImage(effect_img,(int)x-34,(int)y-34, null);
		
		} 
		else {
			g.drawImage(effect_img,(int) x,(int) y, null);
	 
		}
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1));
		
		
	}
	
	private AlphaComposite makeTransparent(float alhpa) { // the method that renders out the transparency 
		int type =  AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type,alpha));
	}
	
	public Rectangle getBounds() {
		return null;
	}
	
}