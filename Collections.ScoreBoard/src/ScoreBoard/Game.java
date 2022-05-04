package ScoreBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Game {
	//HashMap<Integer, Player> players;
	ArrayList<Player> playerList;
	ScoreBoard scoreBoard;
	
	public Game() {
		//players = new HashMap<Integer, Player>();
		playerList = new ArrayList<Player>();
		scoreBoard = new ScoreBoard(this);
	}
	
	protected ArrayList<Player> getPlayerList(){
		return this.playerList;
	}
	
	public void populatePlayers() {
		Player player;
		
		player = new Player("Amir Amano", "Albania", 100, 100);
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Benny Boots", "Bahamas", 100, 300);
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Catty Crops", "Canada", 351, 200);
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Doron Donatelo", "Denmark", 0, 341);
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Eran Ekstein");
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Freddy Fokstein");
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Gerald Ginsburg");
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Harry Houdini");
		player.randomizeStats();
		playerList.add(player);

		player = new Player("Igor Ivgeny");
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Jacky Jackal");
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Katty Kombs");
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Lenny Lenard");
		player.randomizeStats();
		playerList.add(player);
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
