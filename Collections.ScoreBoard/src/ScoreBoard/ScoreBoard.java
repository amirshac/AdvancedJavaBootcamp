package ScoreBoard;

import java.util.PriorityQueue;

public class ScoreBoard {
	PriorityQueue<Player> topPlayers;
	
	public ScoreBoard() {
		topPlayers = new PriorityQueue<Player>();
	}
	
	public void print() {
		System.out.println(topPlayers);
	}
}
