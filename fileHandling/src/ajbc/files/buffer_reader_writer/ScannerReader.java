package ajbc.files.buffer_reader_writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class ScannerReader {

	public static void readerDemo() {
		
		File file = new File("myFiles/output3.txt");
		
		String data = "This is the data I want to write again.\n";
		int age = 33;
		float money = 1233.45f;
		
		try (PrintWriter printer = new PrintWriter("myFiles/output3.txt")){
			printer.printf("%s age = %d and money = %.2f", data, age, money);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}