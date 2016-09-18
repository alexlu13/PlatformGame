package game;

import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

public class GameHandler {
	
	private PlayerHandler playerHandler;
	private LevelHandler levelHandler;
	private EnemyHandler enemyHandler;
	
	private GameState state;
	
	public GameHandler(){
		state = GameState.GAME;
	}
	
	// Initialize the handlers
	public void handlerInit(){

		levelHandler = new LevelHandler();
		playerHandler = new PlayerHandler();
		enemyHandler = new EnemyHandler();
	}
	
	// Method to handle the game
	public void handleGame(){
		playerHandler.handlePlayer();
		levelHandler.handleLevel();
		enemyHandler.handleEnemies();
	}

	public Player getPlayer(){
		return playerHandler.getPlayer();
	}
	
	public Vector getLevelEndBounds(){
		
		return levelHandler.getMaxCoordinate();
	}
}
