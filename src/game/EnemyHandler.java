package game;

public class EnemyHandler {
	private Enemy[] enemies;
	private int numEnemies;
	
	public EnemyHandler(){
		numEnemies = 2;
		
		enemies = new Enemy[numEnemies];
		enemies[0] = new TestEnemy(450, 300, 2, 100, 100, 300);
		enemies[1] = new TestEnemy(1000, 600, 2, 100, 100, 300);
	}
	
	public void handleEnemies(){
		for(int i = 0; i < numEnemies; i++){
			enemies[i].render();
			enemies[i].movement();
		}
	}
	
	public Enemy[] getEnemies(){
		return enemies;
	}
}
