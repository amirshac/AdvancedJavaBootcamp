package ajbc.files.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class FileExercise {
	private static String inputFileName = "myFiles/alice_in_wonderland.txt";
	private static String outputFileName = "myFiles/alice_report.txt";
	private static String linesFileName = "myFiles/alice_lines.txt";
	private static String wordsFileName = "myFiles/alice_words.txt";
	private static int words=0, lines=0;
	private static int WORD_NUMBER_TO_RETURN = 578;
	private static int LINE_NUMBER_TO_RETURN = 18;
	private static String line;
	private static String wordToReturn;
	private static String lineToReturn;
	
	private static PrintWriter printWriterLines;
	private static PrintWriter printWriterWords;
	
	protected static void countWords() {
		String[] wordArray = line.split(" ");
		for (String word : wordArray) {
			
			// ignore empty strings (lines)
			if (word.equals("")) continue;
			
			words++;
			
			if (words == WORD_NUMBER_TO_RETURN)
				wordToReturn = word;
		}
	}
	
	protected static void countLines() {
		lines ++;
		if (lines == LINE_NUMBER_TO_RETURN)
			lineToReturn = line;
	}
	
	protected static void produceReportFile() {
		String msg1 = "Number of words: %d\n";
		String msg2 = "Number of lines: %d\n";
		String msg3 = "Text from line 18: %s\n";
		String msg4 = "Word number 578: %s\n";
		
		try (PrintWriter writer = new PrintWriter(outputFileName)){
			
			writer.printf(msg1, words);
			writer.printf(msg2, lines);
			writer.printf(msg3, lineToReturn);
			writer.printf(msg4, wordToReturn);
			
		}catch (Exception e){
			System.out.println(e);
		}
		
	}
	
	public static void run() {
		File file = new File(inputFileName);
		
		try (
				Scanner sc = new Scanner(file);
			//	printWriterLines = new PrintWriter(linesFileName);
				//printWriterWords = new PrintWriter(wordsFileName);
				
				){
			
			while (sc.hasNextLine()) {
				line = sc.nextLine();
			
				countLines();
				countWords();
		
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		produceReportFile();
	}
}