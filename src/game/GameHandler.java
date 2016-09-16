package game;

public class GameHandler {
	
	private PlayerHandler playerHandler;
	private LevelHandler levelHandler;
	
	private GameState state;
	
	public GameHandler(){
		state = GameState.GAME;
	}
	
	// Initialize the handlers
	public void handlerInit(){

		levelHandler = new LevelHandler();
		playerHandler = new PlayerHandler();
	}
	
	// Method to handle the game
	public void handleGame(){
		playerHandler.handlePlayer();
		levelHandler.handleLevel();
	}

	public Vector getPlayerPosition(){
		return playerHandler.getPlayer().getPosition();
	}
}
