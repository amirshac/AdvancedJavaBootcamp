package multithreading.exe.alice;

import java.util.ArrayList;
import java.util.List;

public class WordParser {
	
	public static List<String> parse(String line){
		List<String> resultList = new ArrayList<String>();
		
	//	System.out.println("<parser>" + line);
		line = line.replaceAll("[.,-]:-", " ").replace('\'', ' ').replace('"', ' ');
	//	System.out.println(line);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] words = line.split(" ");
		
		for (String word : words) {
			if (word!="") 
				resultList.add(word);
		}
		
		return resultList;
	}
	
}
