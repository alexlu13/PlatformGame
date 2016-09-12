package game;

public class GameHandler {
	
	private PlayerHandler player;
	private LevelHandler level;
	
	private GameState state;
	
	public GameHandler(){
		state = GameState.GAME;
	}
	
	// Initialize the handlers
	public void handlerInit(){

		level = new LevelHandler();
		player = new PlayerHandler();
	}
	
	// Method to handle the game
	public void handleGame(){
		player.handlePlayer();
		level.handleLevel();
	}
	

}
