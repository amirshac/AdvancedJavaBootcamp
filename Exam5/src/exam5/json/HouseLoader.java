package exam5.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class HouseLoader {

	private static final String FILENAME = "myfiles/file.json";
	List<House> houseList;

	public HouseLoader() {
	}

	public void load() {
		File file = new File(FILENAME);
		try (FileReader fileReader = new FileReader(file)){
			
			JsonReader jsonReader = new JsonReader(fileReader);
			Gson gson = new Gson();
			
			Type houseListType = new TypeToken<ArrayList<House>>(){}.getType();
			houseList = gson.fromJson(jsonReader, houseListType);
							
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printHouses() {
		houseList.forEach(house->System.out.println(house));
	}

}
