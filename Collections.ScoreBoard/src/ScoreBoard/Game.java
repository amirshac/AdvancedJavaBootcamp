package ScoreBoard;

import java.util.HashMap;
import java.util.Set;

public class Game {
	HashMap<Double, Player> players;
	ScoreBoard scoreBoard;
	
	public Game() {
		players = new HashMap<Double, Player>();
		scoreBoard = new ScoreBoard();
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
	
	public void printPlayers() {
		for (HashMap.Entry<Double,Player> entry : players.entrySet()) {
			System.out.println(entry.getValue());	
		}
	}
	
}
