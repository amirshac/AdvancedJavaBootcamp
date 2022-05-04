package ScoreBoard;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Game {
	//HashMap<Integer, Player> players;
	PriorityQueue<Player> playerList;
	ScoreBoard scoreBoard;
	
	public Game() {
		//players = new HashMap<Integer, Player>();
		playerList = new PriorityQueue<Player>();
		scoreBoard = new ScoreBoard(this);
	}
	
	protected PriorityQueue<Player> getPlayerList(){
		return this.playerList;
	}
	
	public void populatePlayers() {
		Player player;
		
		player = new Player("Amir Amano", "Albania", 100, 100);
		playerList.add(player);
		//players.put(player.id, player);
		
		player = new Player("Benny Boots", "Bahamas", 51, 300);
		playerList.add(player);
		//players.put(player.id, player);
		
		player = new Player("Catty Crops", "Canada", 351, 200);
		playerList.add(player);
		//players.put(player.id, player);
		
		player = new Player("Doron Donatelo", "Denmark", 0, 341);
		playerList.add(player);
		//players.put(player.id, player);
	}
	
	public void printPlayers() {
		for (Player entry : playerList) {
			System.out.println(entry);	
		}
	}
	
	public void updateScoreBoard() {
		scoreBoard.update();
	}
	
}
