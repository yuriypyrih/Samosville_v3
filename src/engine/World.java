package engine;


import javax.swing.*;

import entities.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class World extends Canvas  {
	
	private PlayerInput player;
	private Handler handler;
	public static char[][] cworld ;
	private int startTimer;
   
    private Image  img_grass = new ImageIcon("res/Grass50.png").getImage();
    private Image  img_landscape = new ImageIcon("res/mountain_landscape.png").getImage();
    private Image  cow_img = new ImageIcon("res/cow50.png").getImage();

    private Image img_wall = new ImageIcon("res/Wall50.png").getImage();
    private Image enemy_base_img = new ImageIcon("res/enemy_base150.png").getImage();
    private Image base_img = new ImageIcon("res/base150.png").getImage();
    private Image selected_filter_img = new ImageIcon("res/selected_filter.png").getImage();
    private Image on_select_filter_img = new ImageIcon("res/on_select_filter.png").getImage();
    private Image off_select_filter_img = new ImageIcon("res/off_select_filter.png").getImage();

    
    
 
   
   

    public World(PlayerInput player , Handler handler) {
    	
    	this.player = player;
    	this.handler = handler;
    	startTimer = HUD.secondsPassed;
    	
    	cworld = new char[][]{
    		{'R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R'},
    		{'R','G','G','G','G','S','S','S','G','G','G','G','G','G','S','S','G','S','S','S','S','S','S','R'},
    		{'R','G','G','G','G','G','S','G','G','G','T','T','T','G','T','S','G','G','T','G','S','S','G','R'},
    		{'R','G','G','P','P','S','G','G','T','T','T','G','G','T','T','G','T','T','T','T','T','S','S','R'},
    		{'R','G','G','G','P','G','S','G','G','T','T','T','G','G','T','T','G','T','S','G','T','T','S','R'},
    		{'R','T','T','G','P','G','G','G','G','S','G','T','C','G','G','G','G','T','T','C','C','T','S','R'},
    		{'R','S','G','G','P','P','P','P','P','P','G','T','G','G','G','G','T','G','G','G','G','T','C','R'},
    		{'R','S','S','T','G','G','G','G','S','P','G','G','G','G','T','G','C','G','S','G','C','T','T','R'},    	
    		{'R','S','S','G','T','G','G','G','G','P','P','P','P','G','G','C','G','G','G','C','G','G','T','R'},
    		{'R','G','C','G','T','T','T','G','G','G','T','T','P','P','P','P','P','P','P','G','G','T','G','R'},
    		{'R','G','C','G','G','T','G','G','S','C','G','G','T','G','T','G','G','G','P','G','G','G','G','R'},
    		{'R','T','T','C','G','G','C','G','G','G','S','G','G','T','T','G','G','G','P','G','G','G','G','R'},
    		{'R','G','G','T','T','T','G','C','G','S','S','S','G','G','S','S','G','G','P','P','P','P','G','R'},
    		{'R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R'},
    		};
        
    }
    
    public static void changeTile(int x, int y, char Type) {
    	cworld[y][x] = Type;
    }
    public void tick() {
    	
    	if(HUD.secondsPassed - startTimer >= 15)
		{
    		handler.addObject( new Enemy_Warrior( 3, 3, ID.Warrior, handler, 20, 12));
    		startTimer = HUD.secondsPassed;
		}
    	
    	
   	
    	
    }//end of tick()
    

    public void render(Graphics g) {
    	
    	
    	
       	for (int x = 0; x < 24; x++) {
       		for (int y = 0; y < 14; y++) {
                switch (cworld[y][x]) {

                    case 'G':
                    	//Grass
                    	g.drawImage(img_landscape,
                    			x * 50, y * 50, x * 50 + 50, y * 50 + 50,
                    			448, 128, 512, 192,
                    			null);  
                        break;
                    case 'T':
                    	//Grass
                    	g.drawImage(img_landscape,
                    			x * 50, y * 50, x * 50 + 50, y * 50 + 50,
                    			448, 128, 512, 192,
                    			null); 
                    	//Tree
                    	g.drawImage(img_landscape,
                    			x * 50, y * 50, x * 50 + 50, y * 50 + 50,
                    			288, 400, 352, 512,
                    			null);  
                        break;
                    case 'S':
                    	//Grass
                    	g.drawImage(img_landscape,
                    			x * 50, y * 50, x * 50 + 50, y * 50 + 50,
                    			448, 128, 512, 192,
                    			null); 
                    	//Stone
                    	g.drawImage(img_landscape,
                    			x * 50, y * 50, x * 50 + 50, y * 50 + 50,
                    			352, 448, 384, 512,
                    			null);  
                        break;
                    case 'C':
                    	//Grass
                    	g.drawImage(img_landscape,
                    			x * 50, y * 50, x * 50 + 50, y * 50 + 50,
                    			448, 128, 512, 192,
                    			null); 
                    	//Cow
                    	g.drawImage(cow_img,x * 50, y * 50, null);  
                        break;
                    case 'P':
                    	//Path
                    	g.drawImage(img_landscape,
                    			x * 50, y * 50, x * 50 + 50, y * 50 + 50,
                    			448, 192, 512, 256,
                    			null); 
                    	break;
                    case 'R':
                    	//Rock
                    	g.drawImage(img_landscape,
                    			x * 50, y * 50, x * 50 + 50, y * 50 + 50,
                    			448, 0, 512, 64,
                    			null);   
                    	break;

                }//end of switch
                
                /*TESTING INDIVIDUAL CELL*/
                if(player.getMX() >=  x * 50 && player.getMX() < x * 50 + 50 && Game.gameState == STATE.Game)
                {
                	if(player.getMY() >=  y * 50 && player.getMY() < y * 50 + 50)
                	{
                		if(HUD.SELECT_RESOURCE == true) {
                			if(cworld[y][x] == 'S' ||cworld[y][x] == 'T'|| cworld[y][x] == 'C')
                			{
                				g.drawImage(on_select_filter_img,x * 50, y * 50, null); 
                			}else {
                				g.drawImage(off_select_filter_img,x * 50, y * 50, null); 
                			}
                			
                		}
                		else {
                			g.drawImage(selected_filter_img,x * 50, y * 50, null);   
                			
                		}
                		
                	}
                }
         
            }//end of inner for()
        }//end of outer for()
       	g.drawImage(enemy_base_img, 0, 50, null); 
       	g.drawImage(base_img, 1050, 500, null); 
       	
    }//end of render()

    

    
}