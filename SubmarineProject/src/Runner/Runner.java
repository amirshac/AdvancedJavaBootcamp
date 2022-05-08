package Runner;

import java.util.Scanner;

import Board.*;
import SubGame.SubGame;
import submarines.*;
import Input.*;

public class Runner {

	public static void main(String[] args) {
		SubGame game = new SubGame();
		game.start();		
		Input.scanner.close();	
	}

}
