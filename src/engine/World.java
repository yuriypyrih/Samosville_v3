package engine;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class World extends Canvas  {
	
	private PlayerInput player;
	private char[][] cworld ;
   
    private Image  img_grass = new ImageIcon("res/Grass50.png").getImage();
    private Image  img_landscape = new ImageIcon("res/mountain_landscape.png").getImage();
    private Image  cow_img = new ImageIcon("res/cow50.png").getImage();

    private Image img_wall = new ImageIcon("res/Wall50.png").getImage();
    private Image enemy_base_img = new ImageIcon("res/enemy_base150.png").getImage();
    private Image base_img = new ImageIcon("res/base150.png").getImage();
    private Image selected_filter_img = new ImageIcon("res/selected_filter.png").getImage();
    
    
 
   
   

    public World(PlayerInput player) {
    	
    	this.player = player;

    	cworld = new char[][]{
    		{'R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','S','S','S','S','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','S','G','G','R'},
    		{'R','G','G','P','P','G','G','G','G','T','T','G','G','G','G','G','G','G','T','G','G','S','G','R'},
    		{'R','G','G','G','P','G','G','G','G','T','T','T','G','G','G','G','G','T','T','G','G','G','G','R'},
    		{'R','G','G','G','P','G','G','G','G','G','G','T','G','G','G','G','G','T','T','G','G','G','G','R'},
    		{'R','G','G','G','P','P','P','P','P','P','G','T','G','G','G','G','T','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','P','G','G','G','G','T','G','G','G','G','G','C','G','G','R'},    	
    		{'R','G','G','G','G','G','G','G','G','P','P','P','P','G','G','G','G','G','G','C','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','T','T','P','P','P','P','P','P','P','G','G','G','G','R'},
    		{'R','G','C','G','G','G','G','G','G','G','G','G','T','G','T','G','G','G','P','G','G','G','G','R'},
    		{'R','G','G','C','G','G','G','G','G','G','S','G','G','T','T','G','G','G','P','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','S','S','S','G','G','G','G','G','G','P','P','P','P','G','R'},
    		{'R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R'},
    		};
        
    }
      


  

    

   


    

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
                
                if(player.getMX() >=  x * 50 && player.getMX() < x * 50 + 50 && Game.gameState == STATE.Game)
                {
                	if(player.getMY() >=  y * 50 && player.getMY() < y * 50 + 50)
                	{
                		g.drawImage(selected_filter_img,x * 50, y * 50, null);   
                	}
                }
         
            }//end of inner for()
        }//end of outer for()
       	g.drawImage(enemy_base_img, 0, 50, null); 
       	g.drawImage(base_img, 1050, 500, null); 
       	
    }//end of render()

    

    
}