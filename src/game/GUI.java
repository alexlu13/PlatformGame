package game;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.input.Keyboard.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
public class GUI {

	private int xResolution;
	private int yResolution;
	private int maxFPS;
	private GameHandler handler;
	
	public GUI(){
		xResolution = 800;
		yResolution = 600;
		maxFPS = 60;
		init();
	}
	
	private void init(){
		
		// Create Display
		try{
			Display.setDisplayMode(new DisplayMode(xResolution, yResolution));
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
			System.exit(0);
		}
		
		// initialize OpenGL
	    glLoadIdentity();
	    glOrtho(0, 800, 0, 600, 1, -1);
	    
	    glMatrixMode(GL_MODELVIEW);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	    glEnable(GL_TEXTURE_2D);

		handler = new GameHandler();
	    handler.handlerInit();
	    
	    loop();
	}
	
	private void loop(){
		while(!Display.isCloseRequested() && !isKeyDown(KEY_ESCAPE)){
			
			// Update and vertical sync
			Display.update();
			Display.sync(maxFPS);
			
			// Clear screen
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);  
			
			handler.handleGame();
		}
		
	}
	
}
