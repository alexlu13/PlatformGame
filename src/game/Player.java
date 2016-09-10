package game;

public class Player extends Unit{

	public Player(float x, float y, float xSpeed, float size){
		super(x, y, xSpeed, size);
	}

	@Override
	public void moveUp() {
		
	}

	@Override
	public void moveDown() {
		
	}

	@Override
	public void moveLeft() {
		position.addX(-xSpeed);
	}

	@Override
	public void moveRight() {
		position.addX(xSpeed);
	}
	
	
}
