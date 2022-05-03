package Tollroad;

public class Game {
	
	TollRoad tollRoad;
	
	public Game() {
		init();
	}
	
	protected void init() {
		tollRoad = new TollRoad();
	}
	
	protected void test() {
		tollRoad.printCheckPoints();
	}

}
