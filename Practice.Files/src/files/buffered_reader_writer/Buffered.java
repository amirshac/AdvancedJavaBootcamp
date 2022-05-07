package files.buffered_reader_writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buffered {
	
	public static void readTest() {
		String fileName = "files/names.txt";
		String str = null;
		int i = 0;

		// try with resources
		try (FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file)) {
			
			do {
				str = reader.readLine();
				System.out.println(str);
				i++;
			}while (str!=null);
			
			i--;
			System.out.println(i);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void test() {
		String fileName = "files/textFile.txt";
		try {
			FileWriter file = new FileWriter(fileName);
			BufferedWriter writer = new BufferedWriter(file);
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
