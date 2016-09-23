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
		Vector tempYPosition = new Vector(playerPosition.getX(), playerPosition.getY() - player.getSize() / 2);
		Vector tempXLeftPosition = new Vector(playerPosition.getX() - player.getSize(), playerPosition.getY() + player.getSize() / 2);
		Vector tempXRightPosition = new Vector(playerPosition.getX() + player.getSize(), playerPosition.getY() + player.getSize() / 2);
		
		Tile downTile = levelHandler.getCurTile(tempYPosition);
		Tile leftTile = levelHandler.getCurTile(tempXLeftPosition);
		Tile rightTile = levelHandler.getCurTile(tempXRightPosition);
		
		if(playerPosition.getX() - player.getSize() / 2 < 0){
			player.getPosition().setX(player.getSize() / 2);
		}
		
		if(playerPosition.getX() + player.getSize() / 2 > 1600){
			player.getPosition().setX(1600 - player.getSize() / 2);
		}
		
		// Interact with tile below

		
		if(downTile != null){
			TileType downType = downTile.getTileType();
			Vector downTilePosition = downTile.getPosition();
			
			switch(downType){
			
			case FLOOR:
				
				if(player.getCurYSpeed() <= 0 && playerPosition.getY() <= downTilePosition.getY() + downTile.getSize() / 2 + player.getSize() / 2){
					player.setYSpeed(0);
					playerPosition.setY(downTilePosition.getY() + (downTile.getSize() / 2) + (player.getSize() / 2));
					player.setInAir(false);
				}
				
				break;
				
			default:
				break;
			
			}
			
		}else{
			player.setInAir(true);
		}
		
		// Interact with tile to the left
		
		if(leftTile != null){
			Vector leftTilePosition = leftTile.getPosition();
			TileType leftType = leftTile.getTileType();
			
			switch(leftType){
			
			case FLOOR:
				
				if(playerPosition.getX() < leftTilePosition.getX() + leftTile.getSize() / 2 + player.getSize() / 2){
					playerPosition.setX(leftTilePosition.getX() + leftTile.getSize() / 2 + player.getSize() / 2);
				}
				
				break;
				
			default:
				break;
			
			}
		}
		
		// Interact with tile to the right
		
		if(rightTile != null){
			Vector rightTilePosition = rightTile.getPosition();
			TileType rightType = rightTile.getTileType();
			
			switch(rightType){
			
			case FLOOR:
				
				if(playerPosition.getX() > rightTilePosition.getX() - rightTile.getSize() / 2 - player.getSize() / 2){
					
					playerPosition.setX(rightTilePosition.getX() - rightTile.getSize() / 2 - player.getSize() / 2);

				}
				
				break;
				
			default:
				break;
			}
		}
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
