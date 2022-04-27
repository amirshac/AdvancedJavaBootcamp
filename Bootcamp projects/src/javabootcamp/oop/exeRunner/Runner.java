package javabootcamp.oop.exeRunner;

import java.time.LocalTime;

import javabootcamp.oop.exercise.HomeAppliance;
import javabootcamp.oop.exercise.Television;


public class Runner {

	public static void main(String[] args) {

		//HomeAppliance homeApp1 = new HomeAppliance("TUSHIBA", 2001);
	
		//HomeAppliance homeApp2 = new HomeAppliance("Tushiba", 222);

		//System.out.println(homeApp1);
		//System.out.println(homeApp2);
		
		Television tv1 = new Television("RUSHIBA", 2001, 6.7f, 100, "IR");
		tv1.setModel("G45");

		Television tv2 = new Television("Panasonic", 111, 1f, 200, "RF");
		tv2.setModel("3333");
		
		System.out.println(tv1);
		System.out.println(tv2);
	
		int result = tv1.isBigger(tv2);
		
		String resText = "Same";
		
		if (result==1)
			resText = "Bigger";
		else if (result==-1)
			resText = "Smaller";
		
		resText = "TV1 is "+resText+" TV2";
		System.out.println(resText);
		
		result = tv1.getConsumption(3);
		System.out.println("TV worked for 3 hours, consumption: " + result);
		
		LocalTime time = LocalTime.now();
		
		long result2 = 0;
		tv1.turnOn();
		
		result2 = tv1.turnOffSec(time);
		System.out.println(result2);
		
	}
}
