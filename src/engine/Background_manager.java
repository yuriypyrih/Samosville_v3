package engine;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.BufferCapabilities.FlipContents;
import java.util.Random;

import javax.swing.ImageIcon;


public class Background_manager  {
	
	private Game game;
	private STATE gameState = null;
	private boolean LetsChangeBackground = true ;
	
	
	private Image background_lvl_1= new ImageIcon("res/background_lvl_1.jpg").getImage();
	private Image background_lvl_2= new ImageIcon("res/background_lvl_2.jpg").getImage();
	private Image background_lvl_3= new ImageIcon("res/background_lvl_3.png").getImage();
	private Image background_lvl_4= new ImageIcon("res/background_lvl_4.png").getImage();
	private Image background_lvl_5= new ImageIcon("res/background_lvl_5.jpg").getImage();
	private Image background_lvl_6= new ImageIcon("res/background_lvl_6.jpg").getImage();
	private Image background_lvl_7= new ImageIcon("res/background_lvl_7.jpg").getImage();
	private Image background_lvl_8= new ImageIcon("res/background_lvl_8.jpg").getImage();
	private Image background_lvl_9= new ImageIcon("res/background_lvl_9.jpg").getImage();
	private Image background_lvl_10= new ImageIcon("res/background_lvl_10.jpg").getImage();
	
	private Image background_lvl_11_0= new ImageIcon("res/background_lvl_11_0.jpg").getImage();
	//private Image background_lvl_11_1= new ImageIcon("res/background_lvl_11_1.jpg").getImage();
	

	

	public Background_manager(Game game) {
		
		this.game = game;
		
		
		
	}

	
	
	

	
	public void render(Graphics g) {
		
		
		
		
	}
	
}
