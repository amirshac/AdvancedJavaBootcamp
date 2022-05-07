package Runner;

import GeneratorUtil.GeneratorUtil;
import files.buffered_reader_writer.Buffered;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Buffered.readTest();
		
		GeneratorUtil.init();
		System.out.println(GeneratorUtil.randomName());
		System.out.println(GeneratorUtil.randomFullName());
		System.out.println(GeneratorUtil.randomStreet());
		System.out.println(GeneratorUtil.randomCountry());
		System.out.println(GeneratorUtil.randomDateString());
	}

}
