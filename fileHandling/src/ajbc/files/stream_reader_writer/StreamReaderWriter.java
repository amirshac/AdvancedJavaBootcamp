package ajbc.files.stream_reader_writer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class StreamReaderWriter {

	public static void readerDemo() {
		char[] array = new char[100];
		String data = "This is the data I want to write.\n";
		String data1 = "Adding data";
		
		try {
			FileInputStream file = new FileInputStream("myFiles/input.txt");
			InputStreamReader input = new InputStreamReader(file, Charset.forName("UTF8"));
			
			System.out.println("Is the data available in the stream? " + input.ready());
			
			input.read(array);
			
			System.out.println(array);
			
			input.close();
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writerDemo() {
		String data = "Data to stream writer";
		
		try {
			FileOutputStream file = new FileOutputStream("myFiles/output1.txt");
			OutputStreamWriter output = new OutputStreamWriter(file);
			
			output.write(data);
			
			System.out.println("Success");
			
			output.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}