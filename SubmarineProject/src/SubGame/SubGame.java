package SubGame;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import Board.Board;
import Exceptions.InputException;
import Exceptions.InputException.ErrorCode;
import Exceptions.OutOfTargetsException;
import Input.Input;
import Player.Player;
import submarines.Submarine;
import submarines.SubmarineFactory;
import submarines.*;
import FileHandler.*;

public class SubGame {
	protected final int NUM_OF_SUBS = 5;
	protected final int SCORE_LOSS_ON_MISS = 10;
	protected final int SCORE_ON_FIRST_HIT = 200;
	protected final int SCORE_ON_CONSECUTIVE_HIT = 1000;
		
	protected Board logicBoard;
	protected Board playerBoard;
	protected boolean isReplay;
	protected Player player;
	
	protected int inputX, inputY;
	protected boolean isConsecutiveHit;
	
	protected Submarine[] subArr;
	
	public SubGame() {
		logicBoard = new Board();
		playerBoard = new Board();
		subArr = new Submarine[NUM_OF_SUBS]; 
		
		player = new Player("Gabi Kapsarov", "kas@gmail.com", "0525554432");
		
		isReplay = false;
		isConsecutiveHit = false;
	}
	
	private void generateSubmarines() {
		for (int i=0; i<subArr.length; i++)
			subArr[i] = SubmarineFactory.makeRandomSubmarine();		
	}
	
	private void placeSubmarinesOnBoard() {
		Random random = new Random();
		int x;
		int y;
		boolean placedSubmarine = false;
		
		for (Submarine submarine : subArr) {
			placedSubmarine = false;
			while (!placedSubmarine){
				x = random.nextInt(0, logicBoard.WIDTH+1);
				y = random.nextInt(0, logicBoard.HEIGHT+1);
				placedSubmarine = logicBoard.placeSubmarine(submarine, y, x);
			}
		}
	}
	
	public void init(){
		//Submarine testSub = new SubmarineTypeD();
		//logicBoard.placeSubmarine(testSub, 0,19);
		
		generateSubmarines();
		placeSubmarinesOnBoard();
	}
	
	public void start() {
		init();
		play();
		//replayFromFile();
	}
	
	protected void getUserInput() throws InputException{
		String msg = "Coordinates (x,y): ";
		System.out.print(msg);
		inputX = Input.getInt();
		inputY = Input.getInt();
		
		if (inputY >= logicBoard.getWidth() || inputX >= logicBoard.getHeight())
			throw new InputException("Input out of board bounds");
	}
	
	protected void handleUserInput() {
		boolean success = false;
		
		while (!success) { 
			try {
				getUserInput();
			}catch (InputException e) {
				System.out.println(e);
				continue;
			}
			success = true;
		}
	}
	
	protected void autoPlay() {
		inputX = Input.getRandomInt(0, logicBoard.getHeight()-1);
		inputY = Input.getRandomInt(0, logicBoard.getWidth()-1);
	}
	
	protected void updateBoard() {
		char data = logicBoard.getData(inputY,inputX);
		
		switch(data) {
		case 'B' :
			playerBoard.setData('H', inputY, inputX);
			logicBoard.setData('H', inputY, inputX);
			
			if (isConsecutiveHit) {
				System.out.println("Consecutive Hit!" + SCORE_ON_CONSECUTIVE_HIT + " points!");
				player.addScore(SCORE_ON_CONSECUTIVE_HIT);
			} else {
				System.out.println("Hit! " + SCORE_ON_FIRST_HIT + "points!");
				player.addScore(SCORE_ON_FIRST_HIT);	
			}
						
			if (!isReplay) player.addGuess(inputX, inputY);
			
			isConsecutiveHit = true;
			break;
			
		case 'm' :
			System.out.println("you already guessed there");
			break;

		case 'H' :
			System.out.println("You hit that spot already");
			break;
			
		case 0 :
			System.out.println("miss");
			playerBoard.setData('m', inputY, inputX);
			logicBoard.setData('m', inputY, inputX);
			player.subtractScore(SCORE_LOSS_ON_MISS);
			if (!isReplay) {
				player.addGuess(inputX, inputY);
			}
			
			isConsecutiveHit = false;
			break;
			
		default:
			System.out.println("unknown");
			break;
		}	
	}
	
	protected void checkTargetStatus() throws OutOfTargetsException {
		boolean anySubsLeft = logicBoard.getShape().doesDataExist('B');
		if (!anySubsLeft)
			throw new OutOfTargetsException("Eliminated all submarines, out of targets");
	}
	
	public void play() {
		isReplay = false;
		boolean run = true;
		while (run){
			
			if (player.getScore() <= 0) {
				run = false;
				System.out.println("Game over");
				break;
			}
			
			player.printStatus();
			playerBoard.print();
			
			handleUserInput();
			//autoPlay();
			
			if (inputX < 0 || inputY < 0) {
				System.out.println("quitting");
				run = false;
				break;
			}
				
			updateBoard();
			
			player.printLastGuess();
	
			try {
				checkTargetStatus();
				
			}catch (OutOfTargetsException e) {
				System.out.println(e);
				logicBoard.print();
				run = false;
				Input.pressEnter();
				break;
				
			} finally {
				//FileHandler.saveObjectToFile(player, "player.dat");
			}
			
		}// end while
	} // end void
	
	protected void replayFromFile() {
		isReplay = true;
		player = null;
		player = (Player)FileHandler.loadObjectFromFile("player.dat");
		playerBoard.reset();
		logicBoard.resetSubmarines();
		
		player.printGuesses();
		Input.pressEnter();
		
		for (int index = 0; index < player.getGuessSize(); index ++) {
			System.out.println("Replaying from file");
			player.printGuess(index);
			playerBoard.print();
			
			inputX = player.getGuessX(index);
			inputY = player.getGuessY(index);
			updateBoard();
			
			Input.wait(200);
		}
		
		logicBoard.resetSubmarines();
		logicBoard.print();
		Input.pressEnter();
	}
	
	
}
