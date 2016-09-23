package game;

import java.io.*;

// Note: this class is to handle the level, i.e. tiles.

public class LevelHandler {

	private Tile tiles[][];
	private int xTiles;
	private int yTiles;
	
	private final float TILE_SIZE = 100f;
	
	private Vector maxCoordinate;
	
	private final String LEVEL_FILE_LOCATION = "src\\game\\GameFiles\\TextFiles\\LevelFiles\\level";
	private final String LEVEL_FILE_EXTENSION = ".txt";
	
	// Currently a placeholder constructor -> change this later
	public LevelHandler(){
		loadLevel(0);
		maxCoordinate = new Vector (TILE_SIZE * xTiles, TILE_SIZE * yTiles);
	}
	
	public void handleLevel(){
		renderTiles();
	}
	
	private void renderTiles(){
		for(int i = 0; i < xTiles; i++){
			for(int q = 0; q < yTiles; q++){
				if(tiles[i][q] != null){
					tiles[i][q].render();
				}
			}
		}
	}
	
	public Vector getMaxCoordinate(){
		return maxCoordinate;
	}
	
	
	// Note: getCurTile may return null
	public Tile getCurTile(Vector position){
		int x = (int) ((position.getX() - (TILE_SIZE / 2)) / TILE_SIZE);
		int y = (int) ((position.getY() - (TILE_SIZE / 2)) / TILE_SIZE);
		return tiles[x][y];
	}
	
	private void loadLevel(int level){
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(LEVEL_FILE_LOCATION + level + LEVEL_FILE_EXTENSION));
			
			String input;
			
			// Get x and y size
			input = in.readLine();
			xTiles = Integer.parseInt(input);
			input = in.readLine();
			yTiles = Integer.parseInt(input);
			
			tiles = new Tile[xTiles][yTiles];
			
			for(int i = yTiles - 1; i >= 0; i--){
				input = in.readLine();
				for(int q = xTiles - 1; q >= 0; q--){
					
					char curChar = input.charAt(q);
					
					if(curChar == '-'){
						tiles[q][i] = null;
					}else if(curChar == 'F'){
						tiles[q][i] = new FloorTile(q * TILE_SIZE + TILE_SIZE / 2, i * TILE_SIZE + TILE_SIZE / 2, TILE_SIZE);
					}
				}
			}
			in.close();
		}catch(IOException iox){
			
		}
	}
	
	public Tile[][] getLevel(){
		return tiles;
	}
}
