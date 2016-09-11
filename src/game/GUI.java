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
		handler = new GameHandler();
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
	    glMatrixMode(GL_PROJECTION);
	    glLoadIdentity();
	    glOrtho(0, 800, 0, 600, 1, -1);
	    glMatrixMode(GL_MODELVIEW);
	    
	    handler.handlerInit();
	    
	    glEnable(GL_TEXTURE_2D);
	    loop();
	}
	
	private void loop(){
		int numSquares = 10;
		int height = 80;
		while(!Display.isCloseRequested() && !isKeyDown(KEY_ESCAPE)){
			

			// Update and vertical sync
			Display.update();
			Display.sync(maxFPS);
			
			// Clear screen
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);  
			
			handler.handleGame();
			
			// TESTING DELETE LATER
			
			for (int i = 0; i < numSquares; i++){

				glDisable(GL_TEXTURE_2D);
				glColor3f(0, 1, 0);
				glBegin(GL_QUADS);{
					glVertex2f(i * (xResolution / numSquares), 0);
					glVertex2f((i + 1) * (xResolution / numSquares), 0);
					glVertex2f((i + 1) * (xResolution / numSquares), height);
					glVertex2f(i * (xResolution / numSquares), height);
				}glEnd();
				glColor3f(1, 0, 0);
				glBegin(GL_LINE_STRIP);{
					glVertex2f((i+1) * (xResolution / numSquares), 0);
					glVertex2f((i+1) * (xResolution / numSquares), height);
				}glEnd();
			}
			glColor3f(1, 1, 1);
			
			// END OF TEST
		}
		
	}
	
}
