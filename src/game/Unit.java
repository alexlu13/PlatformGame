package game;

public abstract class Unit {

	// Constants and variables
	
	// Position
	protected Vector position;
	
	// Size of the unit in pixels
	protected float sizeX;
	protected float sizeY;
	// Default speed for the unit to move
	protected float maxSpeed;
	
	// Constructors
	public Unit(float x, float y, float maxSpeed, float sizeX, float sizeY){
		position = new Vector(x, y);
		this.maxSpeed = maxSpeed;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public Unit(Vector vector, float xSpeed, float sizeX, float sizeY){
		this.position = new Vector(vector.getX(), vector.getY());
		this.maxSpeed = xSpeed;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
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
	
	public float getSizeX(){
		return sizeX;
	}
	
	public float getSizeY(){
		return sizeY;
	}
}
