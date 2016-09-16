package game;

import static org.lwjgl.opengl.GL11.*;

public abstract class Unit {

	// Constants and variables
	
	// Position
	protected Vector position;
	
	// Size of the unit in pixels
	protected float size;
	
	// Default speed for the unit to move
	protected float maxSpeed;
	
	// Constructors
	public Unit(float x, float y, float maxSpeed, float size){
		position = new Vector(x, y);
		this.maxSpeed = maxSpeed;
		this.size = size;
	}
	
	public Unit(Vector vector, float xSpeed, float size){
		this.position = new Vector(vector.getX(), vector.getY());
		this.maxSpeed = xSpeed;
		this.size = size;
	}
	
	// Abstract movement methods
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	
	public abstract void render();

	public Vector getPosition(){
		return position;
	}
}
