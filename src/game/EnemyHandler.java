package game;

public class EnemyHandler {
	private Enemy[] enemies;
	private int numEnemies;
	
	public EnemyHandler(){
		numEnemies = 1;
		
		enemies = new Enemy[numEnemies];
		enemies[0] = new TestEnemy(400, 130, 8, 100);
	}
	
	public void handleEnemies(){
		for(int i = 0; i < numEnemies; i++){
			enemies[i].render();
		}
	}
}
