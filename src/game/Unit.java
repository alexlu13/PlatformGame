package game;

import static org.lwjgl.opengl.GL11.*;

public abstract class Unit {

	// Constants and variables
	
	// Position
	protected Vector position;
	
	protected int imageID;
	
	// Size of the unit in pixels
	protected float size;
	
	// Default speed for the unit to move
	protected float xSpeed;
	
	// Constructors
	public Unit(float x, float y, float xSpeed, float size){
		position = new Vector(x, y);
		this.xSpeed = xSpeed;
		this.size = size;
	}
	
	public Unit(Vector vector, float xSpeed, float size){
		this.position = new Vector(vector.getX(), vector.getY());
		this.xSpeed = xSpeed;
		this.size = size;
	}
	
	// Abstract movement methods
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	
	// Load the texture
	public void loadTexture(String fileName){
		imageID = TextureLoader.loadTexture(fileName);
	}
	
	// Method to render the unit
	public void render(){
		
		glEnable(GL_TEXTURE_2D);
		glBindTexture(imageID, GL_TEXTURE_2D);
		
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
