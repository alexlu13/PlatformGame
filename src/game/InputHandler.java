package game;

import org.lwjgl.input.*;

public class InputHandler {

	public static Direction pollKeyboard(){
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			return Direction.LEFT;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			return Direction.RIGHT;
		}
		
		return Direction.NULL;
	}
	
}
