package game;

import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

public class GameHandler {
	
	private static long timer = 0;
	
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
		timer++;
		additionalPlayerHandling();
		playerHandler.handlePlayer();

		levelHandler.handleLevel();
		enemyHandler.handleEnemies();
	}

	// Handling the parts that need information from other handlers
	private void additionalPlayerHandling(){
		playerTileInteraction();
	}
	
	// Player tile interaction
	private void playerTileInteraction(){
		Player player = playerHandler.getPlayer();
		Vector playerPosition = player.getPosition();
		Vector tempPosition = new Vector(playerPosition.getX(), playerPosition.getY() - player.getSize() / 2);
		Tile tile = levelHandler.getCurTile(tempPosition);
		
		if(playerPosition.getX() - player.getSize() / 2 < 0){
			player.getPosition().setX(player.getSize() / 2);
		}
		
		if(playerPosition.getX() + player.getSize() / 2 > 1600){
			player.getPosition().setX(1600 - player.getSize() / 2);
		}
		
		if(tile != null){
			TileType type = tile.getTileType();
			Vector tilePosition = tile.getPosition();
			
			switch(type){
			
			case FLOOR:
				
				if(player.getCurYSpeed() <= 0 && playerPosition.getY() <= tilePosition.getY() + tile.getSize() / 2 + player.getSize() / 2){
					player.setYSpeed(0);
					System.out.println(tilePosition.getY() + tile.getSize() / 2);
					playerPosition.setY(tilePosition.getY() + (tile.getSize() / 2) + (player.getSize() / 2));
					player.setInAir(false);
				}
				
				break;
				
			default:
				break;
			
			}
			
		}else{
			System.out.println("something");
			player.setInAir(true);
		}
		
		
		// TEMPORARY BANDAGE TO SOLVE ISSUE OF PLAYER% FALLING THROUGH LEVEL
		// MORE BANDAGE
		/*
			
		if(playerPosition.getY() - (player.getSize() / 2) < tilePosition.getY() + (tile.getSize() / 2)){
			System.out.println(playerPosition.getY() - (player.getSize() / 2) + " " + tilePosition.getY() + (tile.getSize()));
			player.setInAir(false);
			player.getPosition().setY(tilePosition.getY() + tile.getSize() / 2 + player.getSize() / 2);
		}
		
		*/
		
		// END OF BANDAGE
	}
	
	public Player getPlayer(){
		return playerHandler.getPlayer();
	}
	
	public Vector getLevelEndBounds(){
		
		return levelHandler.getMaxCoordinate();
	}
	
	// Return number of frames that have passed since opening the game
	public static long getTime(){
		return timer;
	}
}
