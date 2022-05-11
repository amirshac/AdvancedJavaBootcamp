package Singleton;

import java.util.ArrayList;

public class Game {
	protected ArrayList<Player> players;
	protected CardDeck deck;
	
	public Game() {
		deck = CardDeck.getInstance();
	}
	
	public void populatePlayers() {
		players = new ArrayList<Player>();
		players.add(new Player("Amir",deck));
		players.add(new Player("Ben",deck));
		players.add(new Player("Cassandra",deck));
		players.add(new Player("David",deck));	
	}
	
	public void playGame() {
		int round = 1;
		Player playerWonRound = null;
		
		while (!deck.isEmpty()) {
			
			System.out.println("----------------------------");
			System.out.println("Round " + round);
			System.out.println("Cards remaining " + deck.getInstance().getSize());
			
			players.forEach((p) -> p.takeCard());
			
			players.sort( (p1,p2) -> p2.card - p1.card );
			players.forEach(p -> System.out.println(p));
			
			playerWonRound = players.get(0);
			playerWonRound.addScore();
			System.out.println("Won this round:" + playerWonRound.name);
			System.out.println();
			
			round ++;
		}
		
		System.out.println("Game over");
		
		players.sort( (p1,p2) -> p2.score - p1.score);
		players.forEach(p -> System.out.println(p));
		
		System.out.println("==========================");
		System.out.println("Winner! " + players.get(0));
	}
	
}
