package engine;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private Game game;
	
	public static boolean WASDkeys = true;
	
	private boolean[] keyDown = new boolean[4];
	
	//Constructor for KeyInput class
	public KeyInput(Handler handler, Game game ) {
		this.handler = handler;
		this.game = game;
		
		
		keyDown[0] = false; //W
		keyDown[1] = false; //S
		keyDown[2] = false; //A
		keyDown[3] = false; //D
		
		
	}
	
	/*It handles every key event on the keyboard*/
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		
		/*for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			
			
		}*/
		
	}//end of keyPressed method
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		/*for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
		}
			
		}*/
		
		if(key == KeyEvent.VK_ESCAPE) {
		AudioPlayer.getSound("click_menu").play(1f,0.6f * AudioPlayer.sound_solume_multiplier);
		 	if(game.gameState == STATE.Options) {
				game.gameState = STATE.Menu;
			}	
		 	else if(game.gameState == STATE.Stats) {
				game.gameState = STATE.Menu;
			}
			else if(game.gameState == STATE.Game) {
				game.gameState = STATE.Pause;
			}
			else if(game.gameState == STATE.Pause) {
				game.gameState = STATE.Game;
			}
			
			else if(game.gameState == STATE.Menu) {
				System.exit(1);
			}
			else if(game.gameState == STATE.Victory || game.gameState == STATE.Defeat) {
				game.gameState = STATE.Menu;
			}
		}
		
	}//end of keyReleased Method

}//end of KeyInput class
