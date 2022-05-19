package exam5.design;

public class TestAdapter {
	public static void go() {
		EnemyTank tank = new EnemyTank();
		BadHelicopter helicopter = new BadHelicopter();
		HelicopterToEnemyAdapter helicopterEnemyAdapter = new HelicopterToEnemyAdapter(helicopter);

		System.out.println("<Tank enemy:>");
		tank.turnLeft();
		tank.turnRight();
		tank.driveForward();
		tank.driveBackward();
		tank.fireWeapon();
		System.out.println("===================\n");
		
		System.out.println("<Bad Helicopter enemy:>");
		helicopter.yawRight();
		helicopter.yawLeft();
		helicopter.flyUp();
		helicopter.flyDown();
		helicopter.launchMissle();
		System.out.println("===================\n");
		
		
		System.out.println("<HelicopterToEnemyAdapter using enemy methods:>");
		helicopterEnemyAdapter.turnLeft();
		helicopterEnemyAdapter.turnRight();
		helicopterEnemyAdapter.driveForward();
		helicopterEnemyAdapter.driveBackward();
		helicopterEnemyAdapter.fireWeapon();		
	}
}
