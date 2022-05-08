package FileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
	
	static FileInputStream fileIn;
	static FileOutputStream fileOut;
	static ObjectOutputStream output;
	static ObjectInputStream input;
	
	public static void saveObjectToFile(Object obj, String fname) {			
		try{
			fileOut = new FileOutputStream(fname);
			output = new ObjectOutputStream(fileOut);
			
			output.writeObject(obj);

			output.close();
			fileOut.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static Object loadObjectFromFile(String fname) {
		Object obj = null;
		try{
			fileIn = new FileInputStream(fname);
			input = new ObjectInputStream(fileIn);
			
			obj = input.readObject();

			input.close();
			fileIn.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return obj;
	}
	
}
