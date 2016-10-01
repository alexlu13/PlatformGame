package game;

public class EnemyHandler {
	private Enemy[] enemies;
	private int numEnemies;
	
	public EnemyHandler(){
		numEnemies = 1;
		
		enemies = new Enemy[numEnemies];
		enemies[0] = new TestEnemy(450, 150, 8, 100, 100);
	}
	
	public void handleEnemies(){
		for(int i = 0; i < numEnemies; i++){
			enemies[i].render();
		}
	}
	
	public Enemy[] getEnemies(){
		return enemies;
	}
}
