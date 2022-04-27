package SelfStudy.Dates;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Dates {

	public static void main(String[] args) {
		LocalDate date1;
		LocalDate date2;
		LocalDate date3;
		
		long diff;
		
		date1 = LocalDate.of(2020, 1, 1);
		date2 = LocalDate.of(2021, 2, 1);
		diff = ChronoUnit.MONTHS.between(date1, date2);
		
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(diff);
	}

}
