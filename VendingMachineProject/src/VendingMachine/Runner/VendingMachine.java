package VendingMachine.Runner;

import java.util.Scanner;

import VendingMachine.VendingMachine.*;

public class VendingMachine {
	public static int milkQtt;
	public static int waterQtt;
	public static boolean inService = true;

	static {
		milkQtt = 1000;
		waterQtt = 2000;
	}

	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  while(inService) {
	    showMenu();
	    int opt = Integer.parseInt(sc.next());
	    if(opt == 0) {
	    	inService = false;
	    	break;
	    }
	    
	    Produceable drink = createDrink(opt);
	    drink.produce();
	    
	  }
	  sc.close();
	  
	  System.out.println("Shutting down machine...");
	}

	//factory
	private static Produceable createDrink(int opt) {
		switch (opt) {
		case 0: inService = false;
				break;
		case 1: return new HotChocolate();
		case 2: return new HotEspresso();
		case 3: return new HotCappuccino();
		case 4: return new HotLatte();
		case 5: return new SodaWater();
		case 6: return new Cola();
		case 7: return new Sprite();
		case 8: return new OrangeJuice();
		case 9: return new AppleJuice();
		}
		
		return null;
	}

	public static void showMenu() {
		VendingMachine.printStatus();
			
		System.out.println("Please select a drink or enter 0 to exit:");
		System.out.println("[1. Hot Chocolate] " + "[2. Hot Espresso] " + "[3. Hot Cappuccino] " + "[4. Hot Latte]\n"
				+ "[5. Sodawater] " +"[6. Cola] " + "[7. Sprite] " + "[8. Orange Juice] " + "[9. Apple Juice]");
	}
	
	public static void printStatus() {
		String msg = new String();
		msg += "---------------------------------------------------\n";
		msg += String.format("Vending machine status: water %d, milk %d%n", waterQtt, milkQtt);
		msg += "---------------------------------------------------\n";
		System.out.println(msg);
	}
}

/* RUN:
 
---------------------------------------------------
Vending machine status: water 2000, milk 1000
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
1

<Producing> 
<DrinkClass> Name:Hot Chocolate, Price:5.0, Volume:0, Temprature:70
<HotDrinkClass> Type: CHOCOLATE, Base: MILK, Sugar: 1, Milk: 200
Using milk: 200

---------------------------------------------------
Vending machine status: water 2000, milk 800
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
2

<Producing> 
<DrinkClass> Name:Hot Espresso, Price:5.0, Volume:50, Temprature:70
<HotDrinkClass> Type: COFFEE, Base: WATER, Sugar: 1, Milk: 0
Using water: 50

---------------------------------------------------
Vending machine status: water 1950, milk 800
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
3

<Producing> 
<DrinkClass> Name:Hot Cappucinno, Price:5.0, Volume:100, Temprature:70
<HotDrinkClass> Type: COFFEE, Base: WATER, Sugar: 1, Milk: 100
Using water: 100

Using milk: 100

---------------------------------------------------
Vending machine status: water 1850, milk 700
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
4

<Producing> 
<DrinkClass> Name:Hot Latte, Price:5.0, Volume:50, Temprature:70
<HotDrinkClass> Type: COFFEE, Base: WATER, Sugar: 1, Milk: 150
Using water: 50

Using milk: 150

---------------------------------------------------
Vending machine status: water 1800, milk 550
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
5

<Producing> 
<DrinkClass> Name:SodaWater, Price:3.5, Volume:100, Temprature:0
<ColdDrinkClass> ingridient: WATER 
<SodaClass> container: CAN
Using water: 100

---------------------------------------------------
Vending machine status: water 1700, milk 550
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
6

<Producing> 
<DrinkClass> Name:Cola, Price:9.0, Volume:200, Temprature:0
<ColdDrinkClass> ingridient: COLA_SYRUP 
<SodaClass> container: BOTTLE
Using water: 200

---------------------------------------------------
Vending machine status: water 1500, milk 550
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
7

<Producing> 
<DrinkClass> Name:Sprite, Price:9.0, Volume:100, Temprature:0
<ColdDrinkClass> ingridient: LIME_SYRUP 
<SodaClass> container: CAN
Using water: 100

---------------------------------------------------
Vending machine status: water 1400, milk 550
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
8

<Producing> 
<DrinkClass> Name:Orange Juice, Price:5.0, Volume:150, Temprature:0
<ColdDrinkClass> ingridient: ORANGE 
<SoftDrinkClass> type: SQUEEZED
Using water: 150

---------------------------------------------------
Vending machine status: water 1250, milk 550
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
9

<Producing> 
<DrinkClass> Name:Apple Juice, Price:5.0, Volume:150, Temprature:0
<ColdDrinkClass> ingridient: APPLE 
<SoftDrinkClass> type: PASTURIZED
Using water: 150

---------------------------------------------------
Vending machine status: water 1100, milk 550
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
4

<Producing> 
<DrinkClass> Name:Hot Latte, Price:5.0, Volume:50, Temprature:70
<HotDrinkClass> Type: COFFEE, Base: WATER, Sugar: 1, Milk: 150
Using water: 50

Using milk: 150

---------------------------------------------------
Vending machine status: water 1050, milk 400
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
4

<Producing> 
<DrinkClass> Name:Hot Latte, Price:5.0, Volume:50, Temprature:70
<HotDrinkClass> Type: COFFEE, Base: WATER, Sugar: 1, Milk: 150
Using water: 50

Using milk: 150

---------------------------------------------------
Vending machine status: water 1000, milk 250
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
4

<Producing> 
<DrinkClass> Name:Hot Latte, Price:5.0, Volume:50, Temprature:70
<HotDrinkClass> Type: COFFEE, Base: WATER, Sugar: 1, Milk: 150
Using water: 50

Using milk: 150

---------------------------------------------------
Vending machine status: water 950, milk 100
---------------------------------------------------

Please select a drink or enter 0 to exit:
[1. Hot Chocolate] [2. Hot Espresso] [3. Hot Cappuccino] [4. Hot Latte]
[5. Sodawater] [6. Cola] [7. Sprite] [8. Orange Juice] [9. Apple Juice]
4

<Producing> 
<DrinkClass> Name:Hot Latte, Price:5.0, Volume:50, Temprature:70
<HotDrinkClass> Type: COFFEE, Base: WATER, Sugar: 1, Milk: 150
Using water: 50

Using milk: 150

Not enough Milk
Shutting down machine...

*/