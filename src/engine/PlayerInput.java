package engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
			
			//System.out.println("X: " + mx + " Y: " + my);

		}
		
	}//end of class Move
	
	public class Click implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("The mouse was clicked!");	
			

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
			

			if(mouseOver(mx,my,800, 800, 70, 40)) {
			//	handler.addObject(new Worker(20, 12, ID.Worker));
				
				HUD.SELECT_RESOURCE = true;
			}
			
			if(HUD.SELECT_RESOURCE == true && mouseInsideMap() ) {
				handler.addObject(new Worker(20, 12, ID.Worker, handler, mx, my));
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
	
	private boolean mouseInsideMap()
	{
		return mouseOver(mx,my, 1 * 50, 1 *50 , 21 * 50 , 12 *50);
	}
	
}//end of class PlayerInput
