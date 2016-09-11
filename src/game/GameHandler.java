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
		
		player = new PlayerHandler();
		level = new LevelHandler();
	}
	
	// Method to handle the game
	public void handleGame(){
		player.handlePlayer();
	}
	

}
