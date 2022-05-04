package ScoreBoard;

public class Runner {
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.populateRandomPlayers(20);
		
		game.updateScoreBoard();
		
		System.out.println("Scoreboard");
		game.scoreBoard.printTop(10);
		
	}

}
