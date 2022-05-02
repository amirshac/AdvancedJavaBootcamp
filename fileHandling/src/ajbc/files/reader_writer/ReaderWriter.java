package ajbc.files.reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriter {

	public static void writerDemo() {
		String data = "This is the data I want to write.\n";
		String data1 = "Adding data";
		
		try {
			Writer output = new FileWriter("myFiles/output.txt");
			output.write(data);
			output.append(data1);
			
			output.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readerDemo() {
		char[] array = new char[100];
		
		try {
			Reader input = new FileReader("myFiles/input.txt");
			
			System.out.println("Is the data available in the stream? " + input.ready());
			
			input.read(array);
			
			input.close();
			
			System.out.println(array);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}