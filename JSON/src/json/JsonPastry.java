package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JsonPastry {
	
	private static final String FILENAME;
	private static final String MAPFILENAME;
	List<Pastry> pastries;
	Map<PastryLabel, List<Pastry>> pastryMap;
	
	static{
		FILENAME = "myFiles/pastries.json";
		MAPFILENAME = "myFiles/pastryMap.json";
	}
	
	public JsonPastry() {
		pastries = new ArrayList<Pastry>();	
		pastryMap = new HashMap<PastryLabel, List<Pastry>>();
	}
	
	public void populatePastryList() {
		Pastry pastry;
		
		pastry = new Pastry("Cinnamon Swirl", 500, PastryLabel.PARVE);
		pastry.addIngridient(new Ingridient("flour", 10.5));
		pastry.addIngridient(new Ingridient("sugar", 2));
		pastry.addIngridient(new Ingridient("buttermilk", 3.5));
		pastry.addIngridient(new Ingridient("egg", 2));
		
		pastries.add(pastry);
		
		pastry = new Pastry("Chocolate Banana Bundles", 900, PastryLabel.DAIRY);
		pastry.addIngridient(new Ingridient("butter", 3));
		pastry.addIngridient(new Ingridient("sugar", 4));
		pastry.addIngridient(new Ingridient("banana", 5.5));
		pastry.addIngridient(new Ingridient("egg", 3.5));
		
		pastries.add(pastry);
	}
	
	public void populatePastryMap() {
		PastryLabel.values(); 
	}
	
	public void printPastries() {
		this.pastries.forEach(p->System.out.println(p));
	}
	
	public void savePastryListToJson() {
		savePastryListToJson(this.pastries, FILENAME);
	}
	
	public void savePastryListToJson(List<Pastry> pastries, String fileName) {
		Gson gson = new Gson();
		String pastryListJson = gson.toJson(pastries);
		
		File file = new File(fileName);
		try (FileWriter fileWriter = new FileWriter(file)){
			fileWriter.write(pastryListJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadPastriesFromJson() {
		this.pastries = loadPastryListFromJson(FILENAME);
	}
	
	public List<Pastry> loadPastryListFromJson(String fileName) {
		List<Pastry> pastryList = null;
		
		File file = new File(fileName);
		try (FileReader fileReader = new FileReader(file);){
			
			JsonReader jsonReader = new JsonReader(fileReader);
			Gson gson = new Gson();
			
			//Typetoken for pastry array list
			Type pastryListType = new TypeToken<ArrayList<Pastry>>(){}.getType();
			pastryList = gson.fromJson(jsonReader, pastryListType);
				                                              		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pastryList;
	}
	
}
