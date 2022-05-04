package ScoreBoard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
		
		player = new Player("Amir Amano", "Denmark", 100, 100);
		playerList.add(player);
		
		player = new Player("Benny Boots", "Canada", 200, 200);
		playerList.add(player);
		
		player = new Player("Catty Crops", "Bahamas", 300, 300);
		playerList.add(player);
		
		player = new Player("Doron Donatelo", "Albania", 400, 400);
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
		
		Player player = null;
		
		//populateRandomPlayers(40);
		populatePlayers();

		updateScoreBoard();
		System.out.println("Scoreboard");
		scoreBoard.printTop(10);
		System.out.println("-----------");
		
		player = playerList.get(0);
		player.setScore(500);
		updateScoreBoard();
		scoreBoard.printAll();

//
//		System.out.println("list by name:");
//		generateListByName();
//		Utils.printElements(listByName);
//		System.out.println("-----------");
//		
//		System.out.println("List by country:");
//		generateListByCountry();
//		Utils.printElements(listByCountry);
//		System.out.println("-----------");
//		
//		System.out.println("List by rank:");
//		generateListByRank();
//		Utils.printElements(listByRank);
//		System.out.println("-----------");
	}
	
	public void printPlayers() {
		for (Player entry : playerList) {
			System.out.println(entry);	
		}
	}
	
	public void updateScoreBoard() {
		scoreBoard.update();
	}
	
	public void generateListByName() {
		
		Comparator<Player> playerNameComparator = new Comparator<Player>(){
			@Override
			public int compare(Player p1, Player p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};
		
		listByName = new ArrayList<Player>(this.playerList);
		Collections.sort(listByName, playerNameComparator);
		
		this.listByName = new ArrayList<Player>(listByName);
	}
	
	public void generateListByCountry() {
		Comparator<Player> playerCountryComparator = new Comparator<Player>(){
			@Override
			public int compare(Player p1, Player p2) {
				return p1.getCountry().compareTo(p2.getCountry());
			}
		};
		
		listByCountry = new ArrayList<Player>(this.playerList);
		Collections.sort(listByCountry, playerCountryComparator);
	}
	
	public void generateListByRank() {	
		Comparator<Player> playerRankComparator = new Comparator<Player>(){
			@Override
			public int compare(Player p1, Player p2) {
				return p2.getRank() - p1.getRank();
			}
		};
		
		listByRank = new ArrayList<Player>(this.playerList);
		Collections.sort(listByRank, playerRankComparator);
	}
	
}
