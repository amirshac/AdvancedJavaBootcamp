package patterns.decorator;

import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {		
		BasicDress basic = new BasicDress("Blue", "M");
		basic.produce();
		
		CasualDressDecorator casual = new CasualDressDecorator(basic);
		casual.produce();
		
		FancyDressDecorator fancy = new FancyDressDecorator(basic);
		fancy.produce();
		
		SportyDressDecorator sporty = new SportyDressDecorator(casual);
		sporty.produce();
		
		FancyDressDecorator fancySporty = new FancyDressDecorator(new SportyDressDecorator(new BasicDress("Orange", "L")));
		fancySporty.produce();
		
		FancyDressDecorator fancyCasual = new FancyDressDecorator(new CasualDressDecorator(new BasicDress("Purple", "S")));
		fancyCasual.produce();
		
		SportyDressDecorator sportyCasualFancy = new SportyDressDecorator(new CasualDressDecorator(new FancyDressDecorator(new BasicDress("Black", "XL"))));
		sportyCasualFancy.produce();
	}	

}
