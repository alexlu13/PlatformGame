package game;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

public abstract class Tile {

	protected int imageID;
	
	protected Vector position;
	
	protected float size;
	
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
	public void render(){
		
		glEnable(GL_TEXTURE_2D);
		glBindTexture(imageID, GL_TEXTURE_2D);
		
		glBegin(GL_QUADS);{
			
			glTexCoord2f(0, 1);
			glVertex2f(position.getX() - (size / 2), position.getY() - (size / 2));
			
			glTexCoord2f(1, 1);
			glVertex2f(position.getX() + (size / 2), position.getY() - (size / 2));
			
			glTexCoord2f(1, 0);
			glVertex2f(position.getX() + (size / 2), position.getY() + (size / 2));
			
			glTexCoord2f(0, 0);
			glVertex2f(position.getX() - (size / 2), position.getY() + (size / 2));
			
			
		}glEnd();
	}
	
}
