package ScoreBoard;

import java.util.HashMap;

public class Game {
	HashMap<Double, Player> players;
	
	public Game() {
		players = new HashMap<Double, Player>();
	}
	
	public void populatePlayers() {
		Player player;
		
		player = new Player("Amir Amano", "Albania", 100, 100);
		players.put(player.id, player);
		
		player = new Player("Benny Boots", "Bahamas", 51, 300);
		players.put(player.id, player);
		
		player = new Player("Catty Crops", "Canada", 351, 200);
		players.put(player.id, player);
		
		player = new Player("Doron Donatelo", "Denmark", 0, 341);
		players.put(player.id, player);
	}
}
