package game;

// Note: this class is to handle the level, i.e. tiles.

public class LevelHandler {

	private Tile tiles[];
	
	private final int TEST_TILE_NUM = 20;
	
	private final float TILE_SIZE = 80f;
	
	private Vector maxCoordinate;
	
	// Currently a placeholder constructor -> change this later
	public LevelHandler(){
		tiles = new Tile[TEST_TILE_NUM];
		
		for(int i = 0; i < TEST_TILE_NUM; i++){
			tiles[i] = new FloorTile(i * TILE_SIZE + TILE_SIZE / 2, TILE_SIZE / 2, TILE_SIZE);
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
	
	public Tile getCurTile(Vector position){
		return (tiles[(int) (position.getX() / TILE_SIZE)]);
	}
}
