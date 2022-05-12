package patterns.singleton;

import java.util.ArrayList;
import java.util.Random;

// card deck lazy singleton

public class CardDeck {

	private static final int SIZE = 60;
	
	private static CardDeck instance;
	private static Random random;
	
	protected ArrayList<Integer> cards;
	
	static {
		instance = null;
		random = new Random();
	}
	
	private CardDeck() {
		populateCards();
	}
	
	public static CardDeck getInstance() {
		if (instance == null) {
			instance = new CardDeck();
		}
		
		return instance;
	}
	
	protected void populateCards() {
		cards = new ArrayList<Integer>();
		
		for (int i = 1; i<=SIZE; i++) { 
			cards.add(i);
		}
	}
	
	public int takeCard() {
		int index = random.nextInt(0, cards.size());
		int card = cards.remove(index);
		return card;
	}
	
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	public int getSize() {
		return cards.size();
	}
	
}
