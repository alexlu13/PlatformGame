package game;

public abstract class Enemy extends Unit{

	public Enemy(float x, float y, float maxSpeed, float sizeX, float sizeY) {
		super(x, y, maxSpeed, sizeX, sizeY);
	}
	
	abstract public void movement();
	
}
