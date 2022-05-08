package files.ObjectRW;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectRW {
	protected static FileInputStream fileIn;
	protected static FileOutputStream fileOut; 
	public static ObjectInputStream objectReader;
	public static ObjectOutputStream objectWriter;
	
	static {
		
	}
	
	public static void openRead(String fileName) {
		try {
			fileIn = new FileInputStream(fileName);
			objectReader = new ObjectInputStream(fileIn);
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void closeRead() {
		
		try {
			objectReader.close();
			fileIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openWrite(String fileName) {
		try {
			fileOut = new FileOutputStream(fileName);
			objectWriter = new ObjectOutputStream(fileOut);
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void closeWrite() {	
		try {
			objectWriter.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
