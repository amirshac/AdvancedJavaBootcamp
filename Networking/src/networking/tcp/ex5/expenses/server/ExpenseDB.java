package networking.tcp.ex5.expenses.server;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExpenseDB {
	
	protected static Map<Integer, UserRecord> recordMap = new HashMap<Integer, UserRecord>();;
	
	public static UserRecord getRecordByID(int userID) {
		return recordMap.get(userID);
	}
	
	public static void updateRecord(int userID, UserRecord record) {
		recordMap.put(userID, record);
	}
	
	public synchronized static void saveToFile() {
		String fileName = "files/expenseDB.json";
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder = gsonBuilder.setPrettyPrinting();   //Sets pretty formatting
		Gson gson = gsonBuilder.create();                //Create Gson reference
		
		try (FileWriter writer = new FileWriter(fileName)){
			gson.toJson(recordMap, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
