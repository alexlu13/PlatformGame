package game;

public class PlayerHandler {

	private Player player; 
	
	public PlayerHandler(){
		player = new Player(190, 130, 8, 0.75f, 1.0f, 100);
	}
	
	public void handlePlayer(){
		
		player.render();
		handleGameInput();
		
	}
	
	// Method to handle input while in game
	private void handleGameInput(){
		Direction leftRightDir = InputHandler.pollKeyboardLeftRightKeys();
		switch(leftRightDir){
		
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
		
		Direction upDownDir = InputHandler.pollKeyboardUpDownKeys();
		switch(upDownDir){
		
		case UP :
			
			if(!player.isJumping()){
				player.moveUp();
			}

		default :
			if(player.inAir()){
				
				player.moveDown();
			}
			break;
		
		}
	}
	
	public Player getPlayer(){
		return player;
	}
}
