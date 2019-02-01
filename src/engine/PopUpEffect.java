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
	
	private float life;
	private int whichWarning; // 0 = slashing your base, 1 = slashing enemy base 
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
				effect_img = new ImageIcon("res/game_over_red.png").getImage();
				alpha = 1;
			}
			
		
		this.handler = handler;
		life = 0.05f;
		
		
		
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
			timer++;
			shift_y_position++;
			if(singleWarning > 0) {
				//if(timer == 10) AudioPlayer.getSound("sound_warning").play(0.8f,0.6f);
				if(alpha >= 0.8 || alpha <= 0.01) {
					singleWarning--;
					life *= -1;
				}
				alpha += life ;
				if(alpha >= 1) alpha = 1;
			
			}else handler.removeObject(this);
		}
		/*GAME OVER EFFECT*/
		else if(whichWarning == 1) {
			if(alpha >life) {
				alpha -= (life - 0.045f) ;
			}else handler.removeObject(this);
		}
		/*EXPLOSION FADE OUT EFFECT*/
		else if(whichWarning == 2) {
			
			
				if(singleWarning > 0) {
					if(alpha >= 0.8 || alpha <= 0.01) {
						singleWarning--;
						life *= -1;
					}
					alpha += life ;
					if(alpha >= 1) alpha = 1;
				
				}else handler.removeObject(this);
			
		}
		/*WARNING EFFECT ICON*/
		else if(whichWarning == 3) {
			
			if(tripleWarning > 0) {
				if(alpha >= 0.8 || alpha <= 0.01) {
					tripleWarning--;
					life *= -1;
				}
				alpha += life ;
				if(alpha >= 1) alpha = 1;
			
			}else handler.removeObject(this);

		}
		/*POISONED EFFECT*/
		else if(whichWarning == 4) {
			
			if(tripleWarning > 0) {
				if(alpha >= 0.8 || alpha <= 0.01) {
					tripleWarning--;
					life *= -1;
				}
				alpha += life ;
				if(alpha >= 1) alpha = 1;
			
			}else handler.removeObject(this);

		}
		/*SCARY FACE SWAP EFFECT*/
		else if(whichWarning == 5) {
			timer++;
			
			if(timer>50) {
				
				alpha -= life ;
				if(alpha <= 0)  handler.removeObject(this);
			
			}

		}
		
		/*DEATHTRAP EFFECT*/
		if(whichWarning == 6) {
			timer++;
			
			if(timer<20 && alpha <= 0.9) {
				alpha += life;
			}
			if(timer>20){
				alpha -= life ;
				if(alpha <= 0)  handler.removeObject(this);
			
			}
		}
		
		/*THUNDER EFFECT*/
		else if(whichWarning == 7) {
			timer++;
			
			if(timer>5) {
				
				alpha -= life ;
				if(alpha <= 0)  handler.removeObject(this);
			
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
		else if(whichWarning == 3) {
			g.drawImage(effect_img,(int)object.getX()-32,(int)object.getY()-32, null);
		
		} 
		else if(whichWarning == 6) {
			g.drawImage(effect_img,(int)x-34,(int)y-34, null);
		
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