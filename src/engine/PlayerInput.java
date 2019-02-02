package engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import org.newdawn.slick.Sound;

import entities.*;

public  class PlayerInput {
	
	private Handler handler;
	private int mx = -100;
	private int my = -100;

	public PlayerInput(Handler handler) {
		
		this.handler = handler;
	
	}
	
	public int getMX()
	{
		return mx;
	}
	
	public int getMY()
	{
		return my;
	}
	
	public class Move implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			mx = e.getX();
			my = e.getY();
			
			//System.out.println("X Cell: " + getX_CELL() + " Y Cell: " + getY_CELL());

		}
		
	}//end of class Move
	
	public class Click implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {	
			

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			if(Game.gameState == STATE.Game) {
				
				/*CREATE WORKERS BUTTON*/
				if(mouseOver(mx,my,795, 705, 390, 41) && HUD.stone >= 1 && HUD.food >=2) {
					AudioPlayer.getSound("create_worker").play(1f,0.6f);
					HUD.food -= 2;
					HUD.stone -= 1;
					HUD.available_workers += 1;
					HUD.created_workers += 1;
				}
				/*SENT WORKER BUTTON*/
				else if(mouseOver(mx,my,795, 754, 390, 41) && HUD.available_workers > 0) {
					/*Workers have internal structure*/
					HUD.SELECT_RESOURCE = true;
				}
				/*DEPLOY WARRIOR BUTTON*/
				else if(mouseOver(mx,my,795, 802, 390, 41) && HUD.food >= 1 && HUD.wood >= 1 && HUD.stone >= 3) {
					HUD.food -= 1;
					HUD.wood -= 1;
					HUD.stone -= 3;
					
					handler.addObject( new Ally_Warrior( 20, 12, ID.Warrior, handler, 3, 3));
					
				}
				/*REPAIR CASTLE BUTTON*/
				else if(mouseOver(mx,my,677, 708, 107, 138) && HUD.wood >= 2 && HUD.stone >= 5) {
					
					AudioPlayer.getSound("repear_castle").play(1f,0.6f);
					handler.addObject(new PopUpEffect(1000, 550, 1, handler));
					HUD.wood -= 2;
					HUD.stone -= 5;
					HUD.your_BASE += 20;
				}
				
				if(HUD.SELECT_RESOURCE == true && availableMaterial()) {
					handler.addObject(new Worker(20, 12, ID.Worker, handler, mx, my));
					HUD.SELECT_RESOURCE = false;
				}
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}//end of class Click
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		
		if(mx > x && mx < x + width) {
			if (my > y && my<y + height) {
				return true;
			}else {
				return false;
			}
		}else return false;
	}//end of mouseOver()
	
	
	
	public int getX_CELL() {
		
		for(int x_cell = 0 ; x_cell <= 22 ; x_cell++)
		{
			if(mx >= x_cell * 50 && mx < x_cell * 50 + 50)
			{
				return x_cell;
			}
			
		}
		return -1;
	}
	
	public int getY_CELL() {
		
		for(int y_cell = 0 ; y_cell <= 12 ; y_cell++)
		{
			if(my >= y_cell * 50 && my < y_cell * 50 + 50 )
			{
				return y_cell;
			}
			
		}
		return -1;
	}
	
	public boolean availableMaterial() {
		if(!mouseInsideMap()) {
			return false;
		}
		char tempChar = World.cworld[getY_CELL()][getX_CELL()];
		System.out.println("tempChar " + tempChar);
		if(tempChar == 'T' ||tempChar == 'S' || tempChar == 'C' ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean mouseInsideMap()
	{
		return mouseOver(mx,my, 1 * 50, 1 *50 , 22 * 50 , 12 *50);
	}
	
	
	
}//end of class PlayerInput
