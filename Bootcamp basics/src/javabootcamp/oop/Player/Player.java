package javabootcamp.oop.Player;

public class Player {
	
	// static fields
	public static int totalPoints;
	public static int numPlayers;
	
	static {
		totalPoints = 0;
		numPlayers = 0;
	}
	
	// static methods
	public static void printGameStatus(){
		System.out.printf("Total Points:[%d]: Players:[%d]%n", totalPoints, numPlayers);
	}
	
	// fields
	int points, lives;

	// methods
	public void printStatus() {
		System.out.printf(this + " Points:[%d]: Lives:[%d]%n", points, lives);
	}

	public void eatBonus() {
		
	}
	
	public void hitObstacle() {
		
	}
	
	public void addPoints(int numPoints) {
		
		if (numPoints < 0) {
			return;
		}
		
		this.points += numPoints;
		totalPoints += numPoints;
	}
	
	public void subtractPoints(int numPoints) {
		if (numPoints < 0) {
			return;
		}
		
		this.points -= numPoints;
		totalPoints -= numPoints;

	}
	
	// setters getters
	public void setNumPlayers(int num) {
		if ( num >=0 && (num<=3) ) {
			numPlayers = num;
		}
	}
	
	// constructors
	public Player() {
		this(0, 3);
	}
	
	public Player(int points, int lives) {
		this.points = points;
		this.lives = lives;
		setNumPlayers(numPlayers+1);
	}

}
