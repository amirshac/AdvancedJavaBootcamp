package FileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
	
	protected static FileInputStream fileIn;
	protected static FileOutputStream fileOut;
	public static ObjectInputStream objectReader;
	public static ObjectOutputStream objectWriter;
	
	public static Object loadObjectFromFile(String fname) {
		openFileRead(fname);
		Object obj = null;
		
		try {
			obj = objectReader.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		closeFileRead();
		
		return obj;
	}
	
	public static void openFileWrite(String fname) {
		try{
			fileOut = new FileOutputStream(fname);
			objectWriter = new ObjectOutputStream(fileOut);
		}catch (Exception e) {
		System.out.println(e);
		}
	}
	
	public static void closeFileWrite() {
		try {
			objectWriter.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openFileRead(String fname) {
		try{
			fileIn = new FileInputStream(fname);
			objectReader = new ObjectInputStream(fileIn);
		}catch (Exception e) {
		System.out.println(e);
		}
	}
	
	public static void closeFileRead() {
		try {
			objectReader.close();
			fileIn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveObjectToOpenFile(Object obj) {			
		try{
			objectWriter.writeObject(obj);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static Object loadObjectFromOpenFile() {
		Object obj = null;
		try {
			obj = objectReader.readObject();
		}catch (Exception e) {
			System.out.println(e);
		}
		return obj;
	}
	
}
