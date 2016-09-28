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
	
	private Tile[][] tiles;
	
	public GameHandler(){
		state = GameState.GAME;
	}
	
	// Initialize the handlers
	public void handlerInit(){

		levelHandler = new LevelHandler();
		tiles = levelHandler.getLevel();
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
		
		// Check below for tile
		float yBelow = playerPosition.getY() - player.getSizeY() / 2 - levelHandler.getTileSize() / 2;
		float yAbove = playerPosition.getY() + player.getSizeY() / 2 + levelHandler.getTileSize() / 2;
		float xRangeLower = playerPosition.getX() - player.getSizeX() / 2;
		float xRangeUpper = playerPosition.getX() + player.getSizeX() / 2;
		
		Tile downTileLower = levelHandler.getCurTile(new Vector(xRangeLower, yBelow));
		Tile downTileUpper = levelHandler.getCurTile(new Vector(xRangeUpper, yBelow));
		
		if(downTileLower != null){
			TileType downType = downTileLower.getTileType();
			Vector downTilePosition = downTileLower.getPosition();
			switch(downType){
			
			case FLOOR:
				if(player.getCurYSpeed() <= 0 && playerPosition.getY() <= downTilePosition.getY() + levelHandler.getTileSize() / 2 + player.getSizeY() / 2){
					playerPosition.setY(downTilePosition.getY() + (levelHandler.getTileSize() / 2) + (player.getSizeY() / 2));
					player.setInAir(false);
					player.setYSpeed(0);
				}
				break;
				
			default:
				break;
			
			}
			
		}else if(downTileUpper != null){
			TileType downType = downTileUpper.getTileType();
			Vector downTilePosition = downTileUpper.getPosition();
			switch(downType){
			
			case FLOOR:
				if(player.getCurYSpeed() <= 0 && playerPosition.getY() <= downTilePosition.getY() + levelHandler.getTileSize() / 2 + player.getSizeY() / 2){
					playerPosition.setY(downTilePosition.getY() + (levelHandler.getTileSize() / 2) + (player.getSizeY() / 2));
					player.setInAir(false);
					player.setYSpeed(0);
				}
				
				break;
				
			default:
				break;
			
			}
			
		}else{
			player.setInAir(true);
		}
		
		Tile upTileLower = levelHandler.getCurTile(new Vector(xRangeLower, yAbove));
		Tile upTileUpper = levelHandler.getCurTile(new Vector(xRangeUpper, yAbove));
		
		if(upTileLower != null){
			TileType upType = upTileLower.getTileType();
			Vector upTilePosition = upTileLower.getPosition();
			
			switch(upType){
			
			case FLOOR:
				
				if(player.getCurYSpeed() >= 0 && playerPosition.getY() >= upTilePosition.getY() - levelHandler.getTileSize() / 2 - player.getSizeY() / 2){
					playerPosition.setY(upTilePosition.getY() - (levelHandler.getTileSize() / 2) - player.getSizeY() / 2);
					player.setYSpeed(0);
				}
				
				break;
				
			default:
				break;
			
			}
		}else if(upTileUpper!= null){
			TileType upType = upTileUpper.getTileType();
			Vector upTilePosition = upTileUpper.getPosition();
			
			switch(upType){
			
			case FLOOR:
				
				if(player.getCurYSpeed() >= 0 && playerPosition.getY() >= upTilePosition.getY() - levelHandler.getTileSize() / 2 - player.getSizeY() / 2){
					playerPosition.setY(upTilePosition.getY() - (levelHandler.getTileSize() / 2) - player.getSizeY() / 2);
					player.setYSpeed(0);
				}
				
				break;
				
			default:
				break;
			
			}
		}
		
		Vector tempXLeftPosition = new Vector(playerPosition.getX() - player.getSizeX() / 2, playerPosition.getY());
		Vector tempXRightPosition = new Vector(playerPosition.getX() + player.getSizeX() / 2, playerPosition.getY());

		Tile leftTile = levelHandler.getCurTile(tempXLeftPosition);
		Tile rightTile = levelHandler.getCurTile(tempXRightPosition);
		
		// Interact with tile to the left
		if(leftTile != null){
			Vector leftTilePosition = leftTile.getPosition();
			TileType leftType = leftTile.getTileType();
			
			switch(leftType){
			
			case FLOOR:
				
				if(playerPosition.getX() < leftTilePosition.getX() + leftTile.getSize() / 2 + player.getSizeX() / 2){
					playerPosition.setX(leftTilePosition.getX() + leftTile.getSize() / 2 + player.getSizeX() / 2);
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
				
				if(playerPosition.getX() > rightTilePosition.getX() - rightTile.getSize() / 2 - player.getSizeX() / 2){
					
					playerPosition.setX(rightTilePosition.getX() - rightTile.getSize() / 2 - player.getSizeX() / 2);

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
