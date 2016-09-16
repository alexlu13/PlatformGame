package game;

public class Vector {

	private float x;
	private float y;
	
	public Vector(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	// Accessors and mutators
	public void setX(float newX){
		x = newX;
	}
	
	public void setY(float newY){
		y = newY;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	// Add values to the vector
	public void addX(float add){
		x += add;
	}
	
	public void addY(float add){
		y += add;
	}
	
	public void print(){
		System.out.println("X: " + x + " Y: " + y);
	}
}
