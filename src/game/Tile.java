package game;

public abstract class Tile {

	protected Vector position;
	
	protected float size;
	
	protected int imageID;
	
	// Constructors
	public Tile(float x, float y, float size){
		position = new Vector(x, y);
		this.size = size;
	}
	
	public Tile(Vector vector, float xSpeed, float size){
		this.position = new Vector(vector.getX(), vector.getY());
		this.size = size;
	}
	
	// Method to render the unit
	public abstract void render();
	
}
