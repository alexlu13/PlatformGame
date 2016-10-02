package game;

import static org.lwjgl.opengl.GL11.*;

public class TestEnemy extends Enemy{

	private static final String TEXTURE_FILE = "src\\game\\GameFiles\\Images\\EnemyImages\\TestEnemy\\player.png";
	
	private static int imageID;
	private static boolean loadedTexture = false;
	private float range;
	
	private float dist = 0;
	private boolean goingLeft = true;
	
	public TestEnemy(float x, float y, float maxSpeed, float sizeX, float sizeY, float range) {
		super(x, y, maxSpeed, sizeX, sizeY);
		this.range = range;
		if(!loadedTexture){
			imageID = TextureLoader.loadTexture(TEXTURE_FILE);
		}
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		position.addX(-maxSpeed);
		dist -= maxSpeed;
	}

	@Override
	public void moveRight() {
		position.addX(maxSpeed);
		dist += maxSpeed;
	}

	public void movement(){
		
		if(goingLeft){
			moveLeft();
			
			if(dist <= -range){
				goingLeft = false;
			}
			
		}else{
			moveRight();
			
			if(dist >= range){
				goingLeft = true;
			}
		}
		
	}
	
	@Override
	public void render() {
		
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
			
		}
		
		glEnd();
	}

	
	
}
