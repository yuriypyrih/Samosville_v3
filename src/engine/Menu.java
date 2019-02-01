package engine;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;


public class Menu extends MouseAdapter implements MouseMotionListener {
	
	private Game game;
	private Handler handler;
	private HUD hud;
	
	
	private Image menu_background_img = new ImageIcon("res/menu_background.png").getImage();
	private Image pause_filter_img = new ImageIcon("res/pause_filter.png").getImage();
	private Image background_img = menu_background_img;
	
	
	

	public Menu(Game game, Handler handler, HUD hud) {
	
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		
		
	}
	

	
	
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState==STATE.Menu) {
			
			/*PLAY button*/
			if(mouseOver(mx,my,200,400,100,40)) {
				
				game.gameState = STATE.Game;
				hud.reset();
				//background_img = dodge_menu_img;
				
			}
			
			/*Difficulty button*/
			else if(mouseOver(mx,my,240,260,165,70)) {
				
				//game.gameState = STATE.Settings;
				//background_img = dodge_menu_img;
			
			}
			
			/*QUITE button*/
			else if(mouseOver(mx,my,200,600,100,40)) {
				System.exit(1);
			}
		}
		else if(mouseOver(mx,my,200,500,100,40)) {
			
			game.gameState = STATE.Menu;
			//background_img = dodge_menu_img;
		
		}
			
			
		else if(game.gameState == STATE.Settings) {
			
			
			
		}
		
		
	}
	
	
	public void mouseReleassed(MouseEvent e) {
		
	}
	
	
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState==STATE.Menu) {
			
			/*PLAY button*/
			if(mouseOver(mx,my,220,130,195,82)) {
			//	background_img = dodge_menu_play_img;
			}
			/*Difficulty button*/
			else if(mouseOver(mx,my,240,260,165,70)) {
				//background_img = dodge_menu_options_img;
			}
			/*QUITE button*/
			else if(mouseOver(mx,my,260,375,130,57)) {
				//background_img = dodge_menu_exit_img;
			}
			/*IF NOT THEN THE DEFAULT BACKGROUND*/
			else {
				//background_img = dodge_menu_img;
			}
		}

			
			




	
		else if(game.gameState==STATE.Settings) {
	
				/*DIFFICULTY button*/
				if(mouseOver(mx,my,225,120,200,55)) {
				//	dodge_settings_img = dodge_settings_diff;
					}
				/*SOUND button*/
				else if(mouseOver(mx,my,280,205,70,70)) {
				//	dodge_settings_img = dodge_settings_sound;
				}
				/*CONTROLS button*/
				else if(mouseOver(mx,my,230,300,190,55)) {
				//	dodge_settings_img = dodge_settings_controls;
				}
				/*EXIT button*/
				else if(mouseOver(mx,my,482,375,130,55)) {
				//	dodge_settings_img = dodge_settings_exit;
				}
				/*IF NOT THEN THE DEFAULT BACKGROUND*/
				else {
				//	dodge_settings_img = dodge_settings_default;
				}
		}
	else if(game.gameState==STATE.Pause) {
	
		/*RESUME BUTTON*/
		if(mouseOver(mx,my,215, 175, 200, 65)) {
			//paused_img = paused_resume_img;
		}
		/*GIVE UP BUTTON*/
		else if(mouseOver(mx,my,240,260,165,70)) {
			//paused_img = paused_giveup_img;
		}
		/*IF NOT THEN THE DEFAULT BACKGROUND*/
		else {
			//paused_img = paused_default_img;		
			}
		}
	
	
	
	else if(game.gameState==STATE.End) {
		
		/*AGAIN BUTTON*/
		if(mouseOver(mx,my,210,177,200,70)) {
			//game_over_img = game_over_again;
		}
		/*EXIT BUTTON*/
		else if(mouseOver(mx,my,210,247,200,70)) {
			//game_over_img = game_over_exit;
		}
		/*IF NOT THEN THE DEFAULT BACKGROUND*/
		else {
			//game_over_img = game_over;		
			}
		}
		
		
	}
	
	
	
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		
		if(mx > x && mx < x + width) {
			if (my > y && my<y + height) {
				return true;
			}else {
				return false;
			}
		}else return false;
	}
	
	public void tick() {
		
		
	}
	
	
	
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		
		if(game.gameState==STATE.Menu) {
				
			g.drawImage(background_img,0,0,null);
			g.drawRect(200,400,100,40);
			g.drawString("Game", 200,400);
			
			g.drawRect(200,500,100,40);
			g.drawString("Options", 200,500);
			
			g.drawRect(200,600,100,40);
			g.drawString("Exit", 200,600);
		}
		else if(game.gameState==STATE.Pause) {
			System.out.println("works");
		g.drawImage(pause_filter_img,0,0,null);
		
		g.drawRect(200,400,100,40);
		g.drawString("Resume", 200,400);
		
		g.drawRect(200,500,100,40);
		g.drawString("Exit", 200,500);
	}
		
	}
	
}
