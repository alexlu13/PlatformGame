package game;

import static org.lwjgl.opengl.GL11.*;

public class TestEnemy extends Enemy{

	private static final String TEXTURE_FILE = "src\\game\\GameFiles\\Images\\EnemyImages\\TestEnemy\\player.png";
	
	private static int imageID;
	private static boolean loadedTexture = false;
	
	public TestEnemy(float x, float y, float maxSpeed, float size) {
		super(x, y, maxSpeed, size);
		
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
	}

	@Override
	public void moveRight() {
		position.addX(maxSpeed);
		
	}

	@Override
	public void render() {
		
		glBindTexture(GL_TEXTURE_2D, imageID);
		
		glBegin(GL_QUADS);{
			
			glTexCoord2f(0, 1);
			glVertex2f(position.getX() - (size / 2), position.getY() - (size / 2));
			
			glTexCoord2f(1, 1);
			glVertex2f(position.getX() + (size / 2), position.getY() - (size / 2));
			
			glTexCoord2f(1, 0);
			glVertex2f(position.getX() + (size / 2), position.getY() + (size / 2));
			
			glTexCoord2f(0, 0);
			glVertex2f(position.getX() - (size / 2), position.getY() + (size / 2));
			
		}
		
		glEnd();
	}

	
	
}
