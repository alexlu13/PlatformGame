package game;

public class PlayerHandler {

	private Player player; 
	
	public PlayerHandler(){
		player = new Player(100, 130, 8, 0.75f, 100);
	}
	
	public void handlePlayer(){
		
		player.render();
		handleGameInput();
		
	}
	
	// Method to handle input while in game
	private void handleGameInput(){
		Direction direction = InputHandler.pollKeyboardArrowKeys();
		switch(direction){
		
		case LEFT :
			player.moveLeft();
			break;
			
		case RIGHT :
			player.moveRight();
			break;
		
		case NULL:
			player.slowToRest();
			break;
			
		default :
			break;
		}
	}
	
	public Player getPlayer(){
		return player;
	}
}
