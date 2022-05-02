package ajbc.files.object_reader_writer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;

public class ObjectReaderWriter {

	public static void writeSimpleDemo() {
		int num = 10;
		double dNum = 123.45;
		String str = "Hi there";
		
		try(FileOutputStream file = new FileOutputStream("myFiles/objFile1.dat");
				ObjectOutputStream output = new ObjectOutputStream(file)){
			
			output.writeInt(num);
			output.writeDouble(dNum);
			output.writeObject(str);
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void readSimpleDemo() {
		try (FileInputStream file = new FileInputStream("myFiles/objFile1.dat");
				ObjectInputStream input = new ObjectInputStream(file)){
			
			System.out.println("int data: " + input.readInt());
			System.out.println("double data: " + input.readDouble());
			
			System.out.println("object data: " + input.readObject());
			
		}
	} catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();
	}
}