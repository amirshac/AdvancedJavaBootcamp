package Singleton;


public class Runner {


	public static void main(String[] args) {
		Game game = new Game();
		game.populatePlayers();
		game.playGame();
	}

}
