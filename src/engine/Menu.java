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
	private int hover_button = -1;
	
	
	private Image menu_background_img = new ImageIcon("res/menu_background.png").getImage();
	private Image menu_stats_img = new ImageIcon("res/menu_stats.png").getImage();
	private Image menu_options_img = new ImageIcon("res/menu_options.png").getImage();
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
			if(mouseOver(mx,my,440,205,320,85)) {
				AudioPlayer.getSound("click_menu").play(1f,0.6f);
				game.gameState = STATE.Game;
				hud.reset();
				//background_img = dodge_menu_img;
				
			}
			
			/*STATS button*/
			else if(mouseOver(mx,my,440,305,320,85)) {
				AudioPlayer.getSound("click_menu").play(1f,0.6f);
				game.gameState = STATE.Stats;	
			}
			
			/*OPTIONS button*/
			else if(mouseOver(mx,my,440,408,320,85)) {
				AudioPlayer.getSound("click_menu").play(1f,0.6f);
				game.gameState = STATE.Options;
			}
			
			/*EXIT button*/
			else if(mouseOver(mx,my,440,508,320,85)) {
				System.exit(1);
			}
		}
			
		
			
		else if(game.gameState==STATE.Pause) {
				
				/*RESUME button*/
				if(mouseOver(mx,my,448,255,320,85)) {
					AudioPlayer.getSound("click_menu").play(1f,0.6f);
					Game.gameState = STATE.Game;
				
				}
				/*RESET button*/
				else if(mouseOver(mx,my,448,345,320,85)) {
					AudioPlayer.getSound("click_menu").play(1f,0.6f);
					hud.reset();
					Game.gameState = STATE.Game;

				}
				/*QUIT button*/
				else if(mouseOver(mx,my,448,435,320,85)) {
					AudioPlayer.getSound("click_menu").play(1f,0.6f);
					Game.gameState = STATE.Menu;

				}
				
			
				
			
		}
		
		
	}//mousePressed()
	
	
	public void mouseReleassed(MouseEvent e) {
		
	}
	
	
	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState==STATE.Menu) {
			
			/*PLAY button*/
			if(mouseOver(mx,my,440,205,320,85)) {
				hover_button = 1;
			}
			/*STATS button*/
			else if(mouseOver(mx,my,440,305,320,85)) {
				hover_button = 2;
			}
			/*OPTIONS button*/
			else if(mouseOver(mx,my,440,408,320,85)) {
				hover_button = 3;
			}
			/*EXIT button*/
			else if(mouseOver(mx,my,440,508,320,85)) {
				hover_button = 4;
			}
			else {
				hover_button = -1;
			}
		}


	
		else if(game.gameState==STATE.Options) {
	
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
	
			/*RESUME button*/
			if(mouseOver(mx,my,448,255,320,85)) {
				hover_button = 1;
			
			}
			/*RESET button*/
			else if(mouseOver(mx,my,448,345,320,85)) {
				hover_button = 2;
				
			}
			/*QUIT button*/
			else if(mouseOver(mx,my,448,435,320,85)) {
				hover_button = 3;
				
			}
			else {
				hover_button = -1;
			
			}
		}
	

		
		
	}//mouseMoved()
	
	
	
	
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
				
			
			g.drawImage(menu_background_img,0,0,null);
			
			
			if(hover_button == 1) {
				//Player Button
				g.drawRect(440,205,320,85);
			}
			else if(hover_button == 2) {
				//STATS
				g.drawRect(440,305,320,85);
			}
			else if(hover_button == 3) {
				//OPTIONS
				g.drawRect(440,408,320,85);
			}
			else if(hover_button == 4) {
				//EXIT
				g.drawRect(440,508,320,85);
			}
			// hover_button == -1
			else {
				//Do Nothing, do not highlight anything
			}
			
			
		}
		else if(game.gameState==STATE.Stats) {
			
			g.drawImage(menu_stats_img,0,0,null);
			
			 if(hover_button == 3) {
				//QUIT BUTTON
				g.drawRect(448,435,320,85);
			}
			// hover_button == -1
			else {
				//Do Nothing, do not highlight anything
			}
			
		}
		else if(game.gameState==STATE.Options) {
			
			g.drawImage(menu_options_img,0,0,null);
			
			if(hover_button == 1) {
				//RESUME BUTTON
				g.drawRect(448,255,320,85);
			}
			else if(hover_button == 2) {
				//RESET BUTTON
				g.drawRect(448,345,320,85);
			}
			else if(hover_button == 3) {
				//QUIT BUTTON
				g.drawRect(448,435,320,85);
			}
			// hover_button == -1
			else {
				//Do Nothing, do not highlight anything
			}
			
		}//end of if(Options)
		else if(game.gameState==STATE.Pause) {
			
		g.drawImage(pause_filter_img,0,0,null);
		
		if(hover_button == 1) {
			//RESUME BUTTON
			g.drawRect(448,255,320,85);
		}
		else if(hover_button == 2) {
			//RESET BUTTON
			g.drawRect(448,345,320,85);
		}
		else if(hover_button == 3) {
			//QUIT BUTTON
			g.drawRect(448,435,320,85);
		}
		// hover_button == -1
		else {
			//Do Nothing, do not highlight anything
		}
		
	}//end of if(Pause)
		
	}
	
}
