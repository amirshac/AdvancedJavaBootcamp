package DragonDinner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class ObjectReaderWriter {
	private static String FILENAME = "files/dragondinner.dat";
	
	public static void saveObjectToFile(Object obj) {
		try (FileOutputStream file = new FileOutputStream(FILENAME);
				ObjectOutputStream objectWriter = new ObjectOutputStream(file) ) {
					objectWriter.writeObject(obj);		
				}
				catch (Exception e) {
					System.out.println(e);
				}
	}
	
	public static void saveObjectsToFile(Object[] objArr) {
		try (FileOutputStream file = new FileOutputStream(FILENAME);
				ObjectOutputStream objectWriter = new ObjectOutputStream(file) ) {
			
					for (int i=0; i<objArr.length; i++) {
						objectWriter.writeObject(objArr[i]);	
					}		
				}
				catch (Exception e) {
					System.out.println(e);
				}
	}
	
	public static void saveRandomObjectsToFile(Object[] objArr, int numberToSave) {
		Random random = new Random();
		int index = 0;
		
		try (FileOutputStream file = new FileOutputStream(FILENAME);
				ObjectOutputStream objectWriter = new ObjectOutputStream(file) ) {
			
			for (int i=0; i<numberToSave; i++){
				index = random.nextInt(0, objArr.length);
				objectWriter.writeObject(objArr[index]);
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	public static void printObjectsFromFile() {
		try (FileInputStream file = new FileInputStream(FILENAME);
				ObjectInputStream objectReader = new ObjectInputStream(file)) {
			
			do {
				try {
					Object obj = objectReader.readObject();
					System.out.println(obj);
				}catch (Exception e){
					break;
				}
				
			} while (true);
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
