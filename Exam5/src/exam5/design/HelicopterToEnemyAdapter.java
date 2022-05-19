package exam5.design;

public class HelicopterToEnemyAdapter implements Enemy {

	BadHelicopter helicopter;
	
	public HelicopterToEnemyAdapter(BadHelicopter helicopter) {
		super();
		this.helicopter = helicopter;
	}

	@Override
	public void turnLeft() {
		System.out.println("<Adapter> Turning left");
		helicopter.yawLeft();
		System.out.println();
	}

	@Override
	public void turnRight() {
		System.out.println("<Adapter> Turning right");
		helicopter.yawRight();
		System.out.println();
	}

	@Override
	public void driveForward() {
		System.out.println("<Adapter> Driving forward");
		helicopter.flyUp();
		System.out.println();
	}

	@Override
	public void driveBackward() {
		System.out.println("<Adapter> Driving backwards");
		helicopter.flyDown();	
		System.out.println();
	}

	@Override
	public void fireWeapon() {
		System.out.println("<Adapter> Firing weapon pewpew");
		helicopter.launchMissle();
		System.out.println();
	}

}
