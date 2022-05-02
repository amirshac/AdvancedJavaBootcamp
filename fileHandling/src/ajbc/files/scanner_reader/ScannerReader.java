package ajbc.files.scanner_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ScannerReader {


	public static void readerDemo() {
		
		File file= new File ("myFiles/output3.txt");
		
		try (Scanner sc = new Scanner(file)){ 
			while (sc.hasNextLine()) {
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}