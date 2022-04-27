package javabootcamp.oopexam.Runner;
import java.time.LocalDate;

import javabootcamp.oopexam.DollToy.DollToy;
import javabootcamp.oopexam.ElectricToy.ElectricToy;
import javabootcamp.oopexam.Kid.*;
import javabootcamp.oopexam.Toy.*;


public class Runner {

	public static void main(String[] args) {
		
		Kid kid1 = new Kid("Martin", 5);
		Kid kid2 = new Kid("Hana", 3);
		Kid oldKid = new Kid("Mike", 11);
		Toy[] toyArray = new Toy[5];
		LocalDate date, oldDate;
		
		date = LocalDate.of(2022,1,1);
		oldDate = LocalDate.of(2021, 3, 1);
		
		toyArray[0] = new Toy("Toyo", oldDate);
		toyArray[1] = new DollToy("Dolly", date);
		toyArray[2] = new DollToy("Dolla", date);
		toyArray[3] = new ElectricToy("Electro", date);
		toyArray[4] = new ElectricToy("Electra", date);
		
		
		toyArray[0].setKid(kid1);
		toyArray[1].setKid(oldKid);
		toyArray[2].setKid(kid2);
		toyArray[3].setKid(kid2);
		toyArray[4].setKid(kid2);
		
		for (Toy toy : toyArray) 
			toy.Play();
		
	}
/*RUN
<Toy> [ID=1, name=Toyo, purchaseDate=2021-03-01, isBroken=true, ageGroup=ABC, toyAgeMonths=13]
Can't play, toy broken since its older than a year
<Kid> [name=Mike, age=11]
Can't play, kid is not in the proper age group AB
<Kid> [name=Hana, age=3] is playing with <Toy> [ID=3, name=Dolla, purchaseDate=2022-01-01, isBroken=false, ageGroup=AB, toyAgeMonths=3] <DollToy> [softness=SOFT, dirtyness=0]
<DollToy> Dirtyness increased to 1
<Kid> [name=Hana, age=3] is playing with <Toy> [ID=4, name=Electro, purchaseDate=2022-01-01, isBroken=false, ageGroup=ABC, toyAgeMonths=3] <ElectricToy> [batteries=2, soundLevel=3]
<ElectricToy> decreased sound level to 2
<Kid> [name=Hana, age=3] is playing with <Toy> [ID=5, name=Electra, purchaseDate=2022-01-01, isBroken=false, ageGroup=ABC, toyAgeMonths=3] <ElectricToy> [batteries=2, soundLevel=3]
<ElectricToy> decreased sound level to 2
 */
}
