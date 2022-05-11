package Singleton;

public class Player {
	protected String name;
	protected int card;
	protected int score;
	CardDeck deck;
	
	public Player(String name) {
		this.name = name;
		this.deck = CardDeck.getInstance();
		card = 0;
		score = 0;
	}
	
	public void addScore() {
		score ++;
	}
	
	public void setCard(int value) {
		card = value;
	}
	
	public void takeCard() {
		card = deck.takeCard();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", card=" + card + ", score=" + score + "]";
	}
	
	
}
