package ScoreBoard;

public class Runner {
	
	public static void main(String[] args) {
		Game game = new Game();
		game.populatePlayers();
		
		game.updateScoreBoard();
		game.scoreBoard.printTop(30);
		
		System.out.println("------------");
		game.scoreBoard.print();
	}

}
