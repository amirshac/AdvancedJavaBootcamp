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
		for (int i=0; i<5; i++) {
			tollRoad.run();	
		}
	}

}
