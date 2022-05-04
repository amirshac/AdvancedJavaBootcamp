package ScoreBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Utils.Utils;

public class Game {
	ArrayList<Player> playerList;
	ScoreBoard scoreBoard;
	
	ArrayList<Player> listByRank;
	ArrayList<Player> listByCountry;
	ArrayList<Player> listByName;
	
	public Game() {
		playerList = new ArrayList<Player>();
		scoreBoard = new ScoreBoard(this);
	}
	
	protected ArrayList<Player> getPlayerList(){
		return this.playerList;
	}
	
	public void populatePlayers() {
		Player player;
		
		player = new Player("Amir Amano", "Albania", 100, 100);
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Benny Boots", "Bahamas", 100, 300);
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Catty Crops", "Canada", 351, 200);
		player.randomizeStats();
		playerList.add(player);
		
		player = new Player("Doron Donatelo", "Denmark", 0, 341);
		player.randomizeStats();
		playerList.add(player);
		
	}
	
	public void populateRandomPlayers(int number) {
		Player player;
		
		for (int i=0; i<number; i++) {
			player = new Player();
			player.RandomizeAll();
			playerList.add(player);
		}
	}
	
	public void test() {
		
		populateRandomPlayers(40);

		//updateScoreBoard();
		//System.out.println("Scoreboard");
		//scoreBoard.printTop(10);
		//scoreBoard.printAll();
		
//		System.out.println("list by name:");
//		generatePlayerListByName();
//		Utils.printElements(listByName);
		
//		System.out.println("List by country:");
//		generatePlayerListByCountry();
//		Utils.printElements(listByCountry);
		
		System.out.println("List by rank:");
		generatePlayerListByRank();
		Utils.printElements(listByRank);
	}
	

	
	public void printPlayers() {
		for (Player entry : playerList) {
			System.out.println(entry);	
		}
	}
	
	public void updateScoreBoard() {
		scoreBoard.update();
	}
	
	public ArrayList<Player> generatePlayerListByName() {
		
		Comparator<Player> playerNameComparator = new Comparator<Player>(){
			@Override
			public int compare(Player p1, Player p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};
		
		ArrayList<Player> listByName = new ArrayList<Player>(this.playerList);
		Collections.sort(listByName, playerNameComparator);
		
		this.listByName = new ArrayList<Player>(listByName);
		return listByName;
	}
	
	public ArrayList<Player> generatePlayerListByCountry() {
		Comparator<Player> playerCountryComparator = new Comparator<Player>(){
			@Override
			public int compare(Player p1, Player p2) {
				return p1.getCountry().compareTo(p2.getCountry());
			}
		};
		
		ArrayList<Player> listByCountry = new ArrayList<Player>(this.playerList);
		Collections.sort(listByCountry, playerCountryComparator);
		
		this.listByCountry = new ArrayList<Player>(listByCountry);
		return listByCountry;
	}
	
	public ArrayList<Player> generatePlayerListByRank() {	
		Comparator<Player> playerRankComparator = new Comparator<Player>(){
			@Override
			public int compare(Player p1, Player p2) {
				return p2.getRank() - p1.getRank();
			}
		};
		
		ArrayList<Player> listByRank = new ArrayList<Player>(this.playerList);
		Collections.sort(listByRank, playerRankComparator);
		
		this.listByRank = new ArrayList<Player>(listByRank);
		return listByRank;	
	}
	
}
