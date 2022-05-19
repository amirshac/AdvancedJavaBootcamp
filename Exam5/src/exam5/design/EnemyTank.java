package exam5.design;

public class EnemyTank implements Enemy{

	@Override
	public void turnLeft() {
		System.out.println("Tank turning left");
	}

	@Override
	public void turnRight() {
		System.out.println("Tank turning right");
		
	}

	@Override
	public void driveForward() {
		System.out.println("Tank driving forward");
		
	}

	@Override
	public void driveBackward() {
		System.out.println("Tank driving backwards");
		
	}

	@Override
	public void fireWeapon() {
		System.out.println("Tank firing weapon pewpew");
		
	}

}
