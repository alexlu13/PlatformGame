package game;

// Note: this class is to handle the level, i.e. tiles.

public class LevelHandler {

	private Tile tiles[];
	
	private final int TEST_TILE_NUM = 20;
	
	private Vector maxCoordinate;
	
	// Currently a placeholder constructor -> change this later
	public LevelHandler(){
		tiles = new Tile[TEST_TILE_NUM];
		
		for(int i = 0; i < TEST_TILE_NUM; i++){
			tiles[i] = new FloorTile(i * 80 + 40, 40, 80);
		}
		maxCoordinate = new Vector (80 * TEST_TILE_NUM, 600);
	}
	
	public void handleLevel(){
		renderTiles();
	}
	
	private void renderTiles(){
		for(int i = 0; i < TEST_TILE_NUM; i++){
			tiles[i].render();
		}
	}
	
	public Vector getMaxCoordinate(){
		return maxCoordinate;
	}
}
