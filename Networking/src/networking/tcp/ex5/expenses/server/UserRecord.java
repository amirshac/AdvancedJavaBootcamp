package networking.tcp.ex5.expenses.server;

import java.util.HashMap;
import java.util.Map;

public class UserRecord {
	protected int userID;
	protected Map<Category, Double> record;
	
	public UserRecord(int userID) {
		this.userID = userID;
		this.record = new HashMap<Category, Double>();
	}	
	
	public Map<Category, Double> getRecord(){
		return record;
	}

	public void print() {
		record.forEach((k,v) -> System.out.println(k+":"+v));
	}
}
