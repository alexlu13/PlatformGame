package game;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Player extends Unit{

	private static int imageID = 0;
	private static boolean loadedTexture = false;
	
	private static final String TEXTURE_FILE = "src\\game\\GameFiles\\Images\\PlayerImages\\Player.png";
	
	private static float curSpeed;
	
	public Player(float x, float y, float maxSpeed, float acceleration, float size){
		super(x, y, maxSpeed, acceleration, size);
		
		if(!loadedTexture){
			imageID = TextureLoader.loadTexture(TEXTURE_FILE);
			loadedTexture = true;
		}
	}

	@Override
	public void moveUp() {
		
	}

	@Override
	public void moveDown() {
		
	}

	@Override
	public void moveLeft() {
		if(!(curSpeed == -maxSpeed)){
			if(curSpeed > -maxSpeed){
				curSpeed -= acceleration;
			}
			
			if(curSpeed < -maxSpeed){
				curSpeed = -maxSpeed;
			}
		}
		position.addX(curSpeed);
	}

	@Override
	public void moveRight() {
		
		if(!(curSpeed == maxSpeed)){
			if(curSpeed < maxSpeed){
				curSpeed += acceleration;
			}
			
			if(curSpeed > maxSpeed){
				curSpeed = maxSpeed;
			}
		}
		position.addX(curSpeed);
	}
	
	public void slowToRest(){
		if(curSpeed < 0){
			curSpeed += acceleration;
			
			if(curSpeed > 0){
				curSpeed = 0;
			}
		}else if (curSpeed > 0){
			curSpeed -= acceleration;
			
			if(curSpeed < 0){
				curSpeed = 0;
			}
		}
		
		position.addX(curSpeed);
	}
	
	// Method to render the unit
	public void render(){
		glBindTexture(GL_TEXTURE_2D, imageID);
		
		glBegin(GL_QUADS);{
			
			glTexCoord2f(0, 1);
			glVertex2f(position.getX() - (size / 2), position.getY() - (size / 2));
			
			glTexCoord2f(1, 1);
			glVertex2f(position.getX() + (size / 2), position.getY() - (size / 2));
			
			glTexCoord2f(1, 0);
			glVertex2f(position.getX() + (size / 2), position.getY() + (size / 2));
			
			glTexCoord2f(0, 0);
			glVertex2f(position.getX() - (size / 2), position.getY() + (size / 2));
			
			
		}glEnd();
	}
}
