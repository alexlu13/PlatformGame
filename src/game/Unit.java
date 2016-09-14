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
	protected float acceleration;
	
	// Constructors
	public Unit(float x, float y, float maxSpeed, float acceleration, float size){
		position = new Vector(x, y);
		this.maxSpeed = maxSpeed;
		this.acceleration = acceleration;
		this.size = size;
	}
	
	public Unit(Vector vector, float xSpeed, float acceleration, float size){
		this.position = new Vector(vector.getX(), vector.getY());
		this.maxSpeed = xSpeed;
		this.acceleration = acceleration;
		this.size = size;
	}
	
	// Abstract movement methods
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	
	public abstract void render();

}
