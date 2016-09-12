package game;

import static org.lwjgl.opengl.GL11.*;

public abstract class Unit {

	// Constants and variables
	
	// Position
	protected Vector position;
	
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
	
	public abstract void render();

}
