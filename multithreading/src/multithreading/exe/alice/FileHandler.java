package multithreading.exe.alice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
	private static final String FILENAME = "/myFiles/alice.txt";
	
	private File file;
	private FileReader fileReader;
	private BufferedReader reader;
	
	public void openFile(String fileName) {
		file = new File(fileName);
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		reader = new BufferedReader(fileReader);
	}
	
	public String readLine() {
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return line;
	}
	
	public void closeFile() {
		try {
			reader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
