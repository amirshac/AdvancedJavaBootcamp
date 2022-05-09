package Player;

import java.io.Serializable;

import Guess.Guess;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1477822252627199309L;

	private final int GUESS_ARRAY_SIZE = 2000;
	private final int MAX_GUESSES = 100;
	private final int SCORE_START = 1000;
	
	//TODO: player score
	protected String name;
	protected String email;
	protected String phoneNumber;
	
	protected Guess[] guessArr;
	protected int guessIndex;
	protected int currIndex;
	
	protected int guessLeft;
	protected int score;
	
	public Player(String name, String email, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.currIndex = 0;
	
		guessArr = new Guess[GUESS_ARRAY_SIZE];
		guessLeft = MAX_GUESSES;
		score = SCORE_START;
	}
	
	public void addGuess(int x, int y) {
		if (guessIndex >= GUESS_ARRAY_SIZE) {
			System.out.println("cant add guess, max size reached");
			return;
		}
		
		Guess newGuess = new Guess(x, y);
		guessArr[guessIndex] = newGuess;
		guessIndex ++;
		guessLeft--;
	}
	
	public Guess getGuess(int index) {
		Guess returnGuess = null;
		
		if (index < guessIndex) returnGuess = guessArr[index];
		
		return returnGuess;
	}
	
	public int getGuessX(int index) {
		if (guessArr[index] == null) return -1;
		
		return guessArr[index].getX();
	}
	
	public int getGuessY(int index) {
		if (guessArr[index] == null) return -1;
		
		return (guessArr[index].getY());
	}
	
	public int getGuessSize() {
		return guessIndex;
	}
	
	public void printGuesses() {
		for (int i=0; i<guessIndex; i++) {
			System.out.println(i + " " + guessArr[i]);
		}
	}
	
	public void printLastGuess() {
		System.out.println(guessArr[guessIndex-1]);
	}
	
	public void printGuess(int index) {
		System.out.println(guessArr[index]);
	}
	
	public void setScore(int score) {
		this.score = score;
		if (this.score < 0)
			this.score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int add) {
		this.score += add;
	}
	
	public void subtractScore(int num) {
		this.score -= num;
	}

	public void printStatus() {
		String msg = this.name + " Score:" + this.score + " Guesses Left: " + this.guessLeft;
		System.out.println(msg);
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", score=" + score + "]";
	}

	

}
