package engine;
import java.awt.Graphics;
import java.awt.Rectangle;


/*Everything in our game should be considered a GameObject
 * That's why is an abstract class
 * and therefore it will be inhretited by other types of mobs
 */

public abstract class GameObject {
	
	protected int  x, y;
	protected ID id;

	
	
	/*Contructor for GameObject , x and y are the coordinates of where it should be placed 
	 * and id indicates what type of mob this object is */
	public GameObject(int  x, int  y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	
	/*Some basics methods to be inherited*/
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	
	
	
	
	
	
	
}//end of GameObject class
