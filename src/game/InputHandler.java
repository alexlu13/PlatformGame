package game;

import org.lwjgl.input.*;

public class InputHandler {

	public static Direction pollKeyboardLeftRightKeys(){
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			return Direction.LEFT;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			return Direction.RIGHT;
		}
		
		return Direction.NULL;
	}
	
	public static Direction pollKeyboardUpDownKeys(){
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			return Direction.UP;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			return Direction.DOWN;
		}
		
		return Direction.NULL;
	}
}
