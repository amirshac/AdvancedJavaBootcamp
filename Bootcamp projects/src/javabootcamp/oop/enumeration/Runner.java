package javabootcamp.oop.enumeration;

import javax.net.ssl.SSLEngineResult.Status;

public class Runner {

	public static void main(String[] args) {
		
		Status status = Status.FAIL;
		
		for (Status stat : Status.values()) {
			System.out.println(stat);
			System.out.println(stat.code);
		}
//		
		
//		Level lev = Level.HIGH;
//		System.out.println(lev);
//		System.out.println();
//
//		for (Level level : Level.values()) {
//			System.out.println(level);
//		}
//		System.out.println();
		
	}

	public static int numByLevel(Level lev) {
		switch(lev) {
		case HIGH :
			return 1;
		case MEDIUM :
			return 2;
		case LOW:
			return 3;
		}
		
		return 0;
			
	}
	
	public static Level checkTemprature(double temp) {
		if (temp>100)
			return Level.HIGH;
		else
			return Level.LOW;
	}
	
	enum Level{
		LOW, MEDIUM, HIGH
	}
}
