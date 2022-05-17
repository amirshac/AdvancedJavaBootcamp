package patterns.state;

import java.util.Scanner;

public class DispenserHandler {
	public void simulate() {
		Scanner scanner = new Scanner(System.in);
		
		Dispenser dispenser = new Dispenser();
		int input = 0;
		boolean running = true;
		
		while (running) {
			System.out.println("\n" + dispenser);
			System.out.println("1.<5> 2.<10> 3.<Get gum> 4.<Quit>");
			input = Integer.parseInt(scanner.nextLine());
			
			switch(input) {
			case 1:
				dispenser.getState().onFive();
				break;
			case 2:
				dispenser.getState().onTen();
				break;
			case 3:
				dispenser.getState().onGet();
				break;
			case 4:
				running = false;
				break;
			default:
				break;
			}
		}
		scanner.close();
	}
}
