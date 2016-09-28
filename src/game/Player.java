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
	
	private float xAcceleration;
	private float yAcceleration;
	
	private static final String TEXTURE_FILE = "src\\game\\GameFiles\\Images\\PlayerImages\\Player.png";
	
	private float curXSpeed;
	private float curYSpeed;
	
	private static final float GRAVITY = 1.0f;
	
	private boolean isJumping;
	private boolean inAir;
	
	private long startJumpTime;
	private long curJumpTime;
	
	// Number of frames to accelerate when jumping
	private final long ACCELERATE_JUMP_TIME = 10;
	
	public Player(float x, float y, float maxSpeed, float xAcceleration, float yAcceleration, float sizeX, float sizeY){
		super(x, y, maxSpeed, sizeX, sizeY);
		
		if(!loadedTexture){
			imageID = TextureLoader.loadTexture(TEXTURE_FILE);
			loadedTexture = true;
		}
		this.xAcceleration = xAcceleration;
		this.yAcceleration = yAcceleration;
		
		curXSpeed = 0;
		curYSpeed = 0;
		isJumping = false;
	}

	@Override
	public void moveUp() {
		if(!isJumping && !inAir){
			startJumpTime = GameHandler.getTime();
			
			curYSpeed = yAcceleration;
			position.addY(curYSpeed);
			isJumping = true;
			inAir = true;
		}
	}

	// Kinda weird that if the player is supposed to be accelerating up that the
	// code is in the method called "moveDown" but oh well, it's easier this way
	@Override
	public void moveDown() {
		
		curJumpTime = GameHandler.getTime();
		
		if(curJumpTime - startJumpTime >= ACCELERATE_JUMP_TIME){
			isJumping = false;
		}
		
		if(isJumping && curJumpTime - startJumpTime < ACCELERATE_JUMP_TIME){
			curYSpeed += yAcceleration;
		}else{
			curYSpeed -= GRAVITY;
		}
		if(!inAir){
			curYSpeed = 0;
		}
		position.addY(curYSpeed);
	}

	@Override
	public void moveLeft() {
		if(!(curXSpeed == -maxSpeed)){
			if(curXSpeed > -maxSpeed){
				curXSpeed -= xAcceleration;
			}
			
			if(curXSpeed < -maxSpeed){
				curXSpeed = -maxSpeed;
			}
		}
		
		position.addX(curXSpeed);
	}

	@Override
	public void moveRight() {
		
		if(!(curXSpeed == maxSpeed)){
			if(curXSpeed < maxSpeed){
				curXSpeed += xAcceleration;
			}
			
			if(curXSpeed > maxSpeed){
				curXSpeed = maxSpeed;
			}
		}
		position.addX(curXSpeed);
	}
	
	public void slowToRest(){
		
		// Accelerate towards stop when moving left
		if(curXSpeed < 0){
			curXSpeed += xAcceleration;
			
			if(curXSpeed > 0){
				curXSpeed = 0;
			}
		
		// Accelerate towards stop when moving right
		}else if (curXSpeed > 0){
			curXSpeed -= xAcceleration;
			
			if(curXSpeed < 0){
				curXSpeed = 0;
			}
		}
		
		position.addX(curXSpeed);
	}
	
	// Method to render the unit
	public void render(){
		glBindTexture(GL_TEXTURE_2D, imageID);
		
		glBegin(GL_QUADS);{
			
			glTexCoord2f(0, 1);
			glVertex2f(position.getX() - (sizeX / 2), position.getY() - (sizeY / 2));
			
			glTexCoord2f(1, 1);
			glVertex2f(position.getX() + (sizeX / 2), position.getY() - (sizeY / 2));
			
			glTexCoord2f(1, 0);
			glVertex2f(position.getX() + (sizeX / 2), position.getY() + (sizeY / 2));
			
			glTexCoord2f(0, 0);
			glVertex2f(position.getX() - (sizeX / 2), position.getY() + (sizeY / 2));
			
			
		}glEnd();
	}
	
	public float getCurXSpeed(){
		return curXSpeed;
	}
	
	public float getCurYSpeed(){
		return curYSpeed;
	}
	
	public boolean isJumping(){
		return isJumping;
	}
	
	public void setInAir(boolean inAir){
		this.inAir = inAir;
	}
	
	public boolean inAir(){
		return inAir;
	}
	
	public void setYSpeed(float ySpeed){
		curYSpeed = ySpeed;
	}
	
	public void setXSpeed(float xSpeed){
		curXSpeed = xSpeed;
	}
	
	public void setPosition(Vector newPosition){
		position.setX(newPosition.getX());
		position.setY(newPosition.getY());
	}
}
