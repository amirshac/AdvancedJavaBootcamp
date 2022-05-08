package submarines;
import java.util.Random;

public class SubmarineFactory {
	public static Submarine makeRandomSubmarine() {
		Submarine newSubmarine;
		int submarineType;
		int submarineSize;
		int rotation;
		
		Random random = new Random();
		rotation = random.nextInt(0,4);
		submarineType = random.nextInt(1,5);
		
		switch (submarineType) {
		case 1:
			submarineSize = random.nextInt(1,5);
			newSubmarine = new SubmarineTypeA(submarineSize);
			break;
		case 2:
			submarineSize = random.nextInt(3,5);
			newSubmarine = new SubmarineTypeB(submarineSize);
			break;
		case 3:
			newSubmarine = new SubmarineTypeC();
			break;
		case 4:
			newSubmarine = new SubmarineTypeD();
			break;
		default:
			newSubmarine = new SubmarineTypeA();
		}
		
		for (int i=0; i<rotation; i++)
			newSubmarine.rotate();
		
		//System.out.println(submarineType);
		return newSubmarine;
	}

}
