package SelfStudy.Hashmap;
import java.util.HashMap;

public class Maps {
	
	public static void main(String[] args) {
		// map of strings to integers
		HashMap<String, Integer> empIds = new HashMap<>();
		empIds.put("John", 1234);
		empIds.put("Carl", 55455);
		empIds.put("Amir", 999);
		
		System.out.println(empIds);
		
		empIds.get("Amir");
	}
}
