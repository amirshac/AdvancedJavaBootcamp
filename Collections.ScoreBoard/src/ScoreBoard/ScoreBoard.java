package ScoreBoard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ScoreBoard {
	protected PriorityQueue<Player> scoreBoardPlayers;
	protected Game game;
	
	public ScoreBoard() {
		scoreBoardPlayers = new PriorityQueue<Player>();
		game = null;
	}
	
	public ScoreBoard(Game game) {
		this.game = game;
		update();
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void print() {
		Player player;
		while(!scoreBoardPlayers.isEmpty()) {
			player = scoreBoardPlayers.remove();
			System.out.println(player);
		}
	}
	
	public void printTop(int num) {
		Player player = null;
		for (int i=0; i<num; i++) {
			
			if (scoreBoardPlayers.isEmpty()) {
				break;
			}
			
			player = scoreBoardPlayers.remove();
			System.out.println(player);
		}
	}
	
	public void update() {
		if (game == null) {
			System.out.println("no game exception");
			return;
		}
		
		Comparator<Player> playerScoreComparator = new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return (int)(p2.score - p1.score);
			}
		};
		
		scoreBoardPlayers = new PriorityQueue<Player>(playerScoreComparator);
		scoreBoardPlayers.addAll(game.getPlayerList());
	}
	
}
