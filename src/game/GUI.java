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
	
	private final int MARGIN = 100;
	
	// Variables for scrolling the screen
	private float curMinXDisplay;
	private float curMinYDisplay;
	
	public GUI(){
		xResolution = 800;
		yResolution = 600;
		maxFPS = 60;
		curMinXDisplay = 0;
		curMinYDisplay = 0;
	}
	
	public void init(){
		
		// Create Display
		try{
			Display.setDisplayMode(new DisplayMode(xResolution, yResolution));
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
			System.exit(0);
		}
		
		// initialize OpenGL
		glMatrixMode(GL_PROJECTION);
	    glLoadIdentity();
	    glOrtho(0, curMinXDisplay + xResolution, 0, curMinYDisplay + yResolution, 1, -1);
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
			
			// Scroll screen if necessary
			scrollScreen();
			handler.handleGame();
		}
		
	}
	
	public void scrollScreen(){
		Player player = handler.getPlayer();
		float playerX = player.getPosition().getX();
		float playerY = player.getPosition().getY();
		
		// Scroll right
		if(playerX > curMinXDisplay + xResolution - MARGIN){

			curMinXDisplay += player.getCurXSpeed();
			
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(curMinXDisplay, curMinXDisplay + xResolution, curMinYDisplay, curMinYDisplay + yResolution, 1, -1);
			
		// Scroll left
		}else if(playerX < curMinXDisplay + MARGIN && playerX >= MARGIN){

			curMinXDisplay += player.getCurXSpeed();
			
			if(curMinXDisplay < 0){
				curMinXDisplay = 0;
			}
			
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(curMinXDisplay, curMinXDisplay + xResolution, curMinYDisplay, curMinYDisplay + yResolution, 1, -1);

		}
		
		if(playerY > curMinYDisplay + yResolution - MARGIN){
			curMinYDisplay += player.getCurYSpeed();
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(curMinXDisplay, curMinXDisplay + xResolution, curMinYDisplay, curMinYDisplay + yResolution, 1, -1);

		}
		
		if(playerY < curMinYDisplay + MARGIN){
			curMinYDisplay += player.getCurYSpeed();
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(curMinXDisplay, curMinXDisplay + xResolution, curMinYDisplay, curMinYDisplay + yResolution, 1, -1);

		}
	}
	
}
