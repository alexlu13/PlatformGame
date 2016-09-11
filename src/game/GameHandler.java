package game;

public class GameHandler {
	
	private Player player;
	
	public GameHandler(){
	}
	
	public void handlerInit(){
		player = new Player(100, 150, 3, 100);
		player.loadTexture("src\\game\\GameFiles\\Player\\Player.png");
	}
	
	public void handleGame(){
		player.render();
		
		Direction direction = InputHandler.pollKeyboard();
	}
}
