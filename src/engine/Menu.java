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
	private Image menu_victory_img = new ImageIcon("res/menu_victory.png").getImage();
	private Image menu_victory_filter_img = new ImageIcon("res/menu_victory_filter.png").getImage();
	private Image defeat_filter_img = new ImageIcon("res/defeat_filter.png").getImage();
	
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
				AudioPlayer.getSound("click_menu").play(1f,0.6f  * AudioPlayer.sound_solume_multiplier);
				game.gameState = STATE.Game;
				hud.reset();
				//background_img = dodge_menu_img;
				
			}
			
			/*STATS button*/
			else if(mouseOver(mx,my,440,305,320,85)) {
				AudioPlayer.getSound("click_menu").play(1f ,0.6f * AudioPlayer.sound_solume_multiplier);
				game.gameState = STATE.Stats;	
			}
			
			/*OPTIONS button*/
			else if(mouseOver(mx,my,440,408,320,85)) {
				AudioPlayer.getSound("click_menu").play(1f  ,0.6f * AudioPlayer.sound_solume_multiplier);
				game.gameState = STATE.Options;
			}
			
			/*EXIT button*/
			else if(mouseOver(mx,my,440,508,320,85)) {
				System.exit(1);
			}
		}
		else if(game.gameState == STATE.Stats) {
			
			/*Back button*/
			 if(mouseOver(mx,my,828,764,322,84)) {
				AudioPlayer.getSound("click_menu").play(1f ,0.6f * AudioPlayer.sound_solume_multiplier);
				Game.gameState = STATE.Menu;
			}
			
		}
		else if(game.gameState == STATE.Options) {
			/*Music Volume button*/
			if(mouseOver(mx,my,265,305,653,85)) {
				AudioPlayer.getSound("click_menu").play(1f ,0.6f * AudioPlayer.sound_solume_multiplier);
				AudioPlayer.changeMusicVolume();
			}
			/*Sound Volume button*/
			else if(mouseOver(mx,my,265,450,654,85)) {
				AudioPlayer.getSound("click_menu").play(1f,0.6f* AudioPlayer.sound_solume_multiplier);
				AudioPlayer.changeSoundVolume();
			}
			/*Back button*/
			else if(mouseOver(mx,my,828,764,322,84)) {
				AudioPlayer.getSound("click_menu").play(1f ,0.6f * AudioPlayer.sound_solume_multiplier);
				Game.gameState = STATE.Menu;
			}
			
		}	
		else if(game.gameState==STATE.Pause) {
				
				/*RESUME button*/
				if(mouseOver(mx,my,448,255,320,85)) {
					AudioPlayer.getSound("click_menu").play(1f,0.6f * AudioPlayer.sound_solume_multiplier);
					Game.gameState = STATE.Game;
				
				}
				/*RESET button*/
				else if(mouseOver(mx,my,448,345,320,85)) {
					AudioPlayer.getSound("click_menu").play(1f ,0.6f * AudioPlayer.sound_solume_multiplier);
					hud.reset();
					Game.gameState = STATE.Game;

				}
				/*QUIT button*/
				else if(mouseOver(mx,my,448,435,320,85)) {
					AudioPlayer.getSound("click_menu").play(1f,0.6f * AudioPlayer.sound_solume_multiplier);
					Game.gameState = STATE.Menu;

				}		
			
		}//end of if(Pause)
		
		else if(game.gameState==STATE.Victory) {
			
			
			/*EXIT button*/
			if(mouseOver(mx,my,448,415,320,85)) {
				AudioPlayer.getSound("click_menu").play(1f,0.6f * AudioPlayer.sound_solume_multiplier);
				Game.gameState = STATE.Menu;

			}		
		
		}
		
		else if(game.gameState==STATE.Defeat) {
			
			/*Reset/ Try again button*/
			 if(mouseOver(mx,my,448,300,320,85)) {
				AudioPlayer.getSound("click_menu").play(1f ,0.6f * AudioPlayer.sound_solume_multiplier);
				hud.reset();
				Game.gameState = STATE.Game;

			}
			/*QUIT button*/
			else if(mouseOver(mx,my,448,415,320,85)) {
				AudioPlayer.getSound("click_menu").play(1f,0.6f * AudioPlayer.sound_solume_multiplier);
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
		
		else if(game.gameState==STATE.Stats) {
			
			//BACK BUTTON
			 if(mouseOver(mx,my,828,764,322,84)) {
				hover_button = 1;
			}
			else {
				hover_button = -1;
			}
	}


	
		else if(game.gameState==STATE.Options) {
	
				/*Music Volume button*/
				if(mouseOver(mx,my,265,305,653,85)) {
					hover_button = 1;
				}
				/*Sound Volume button*/
				else if(mouseOver(mx,my,265,450,654,85)) {
					hover_button = 2;
				}
				/*Back button*/
				else if(mouseOver(mx,my,828,764,322,84)) {
					hover_button = 3;
				}
				else {
					hover_button = -1;
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
		}//end of if(Pause)
		else if(game.gameState==STATE.Victory) {
			
			
			/*EXIT button*/
			if(mouseOver(mx,my,448,415,320,85)) {
				hover_button = 1;

			}		
			else {
				hover_button = -1;
			}
		
		}//end of if(Victory)
		
		else if(game.gameState==STATE.Defeat) {
			
			/*Reset/ Try again button*/
			 if(mouseOver(mx,my,448,300,320,85)) {
				 hover_button = 1;
			}
			/*QUIT button*/
			else if(mouseOver(mx,my,448,435,320,85)) {
				hover_button = 2;
			}	
			else {
				hover_button = -1;
			}
		
		}//end of if(Defeat)
	

		
		
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
	
	public void clear_hover_button() {
		hover_button = -1;
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
			
			g.setColor(Color.BLACK);
			Font f = new Font ("Monospaced", Font.BOLD | Font.ITALIC, 48);
		    g.setFont (f);
			
			g.drawString(hud.username, 280, 240);
			
			g.drawString(hud.Best_Time + " sec", 340, 340);
			
			g.setColor(Color.WHITE);
			
			 if(hover_button == 1) {
				//BACK BUTTON
				 g.drawRect(828,764,322,84);
			}
			// hover_button == -1
			else {
				//Do Nothing, do not highlight anything
			}
			
		}
		else if(game.gameState==STATE.Options) {
			
			g.drawImage(menu_options_img,0,0,null);
			
			g.setColor(Color.BLACK);
			Font f = new Font ("Monospaced", Font.BOLD | Font.ITALIC, 48);
		    g.setFont (f);
		    
		    //Music Volume Button
			g.drawString(AudioPlayer.MusicVolumetoString(),690,375);
			
			//Sound Volume Button
			g.drawString(AudioPlayer.SoundVolumetoString(),690,520);
			
			
			
			g.setColor(Color.WHITE);
			if(hover_button == 1) {
				//Music Volume  BUTTON
				g.drawRect(265,305,653,85);
			}
			else if(hover_button == 2) {
				//Sound Volume BUTTON
				g.drawRect(265,450,654,85);
			}
			else if(hover_button == 3) {
				//Back BUTTON
				g.drawRect(828,764,322,84);
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
		
		else if(game.gameState==STATE.Victory) {
			g.drawImage(menu_victory_img,0,0,null);
			
			if(hud.New_best_time == true) {
				g.drawImage(menu_victory_filter_img,0,0,null);

			}
			
			g.setColor(Color.BLACK);
			Font f = new Font ("Monospaced", Font.BOLD | Font.ITALIC, 48);
		    g.setFont (f);
			
			g.drawString(hud.Best_Time + " sec ", 620, 360);
			
			g.setColor(Color.WHITE);
			//Exit button
			if(hover_button == 1) {
				g.drawRect(448,415,320,85);
			}
			
			
		}
		else if(game.gameState==STATE.Defeat) {
			g.drawImage(defeat_filter_img,0,0,null);
			
			//Try again Button
			if(hover_button == 1) {
				g.drawRect(448,300,320,85);
			}
			//Quit Button
			else if(hover_button == 2) {
				g.drawRect(448,415,320,85);
			}
		}
		
	}
	
}
