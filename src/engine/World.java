package engine;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class World extends Canvas  {
    Thread thread;
    int i, j;
    boolean running;
    Image dbImage;
    Image  img_grass, img_wall;
    
    char[][] cworld ;
   
   

    public World() {

    	cworld = new char[][]{
    		{'R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},    	
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','R'},
    		{'R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R','R'},
    		};
        
    		    loadRes();
    }
      


  

    public void loadRes() {
        img_grass = new ImageIcon("res\\Grass50.png").getImage();
        img_wall = new ImageIcon("res\\Wall50.png").getImage();
    }

   


    

    public void render(Graphics g) {
    	
    	
    	
       	for (int x = 0; x < 24; x++) {
       		for (int y = 0; y < 14; y++) {
                switch (cworld[y][x]) {

                    case 'G':

                    	g.drawImage(img_grass, x * 50, y * 50, null);  
                        break;
                    case 'R':
                    	g.drawImage(img_wall, x * 50, y * 50, null);    
                    	break;

                }
            }
        }
    }//end of render()

    

    
}