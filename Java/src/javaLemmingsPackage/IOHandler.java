package javaLemmingsPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOHandler {
	Scanner io = new Scanner (System.in);							// Keyboard input
	
	File inputFile;
	
	//TODO add IO Methods
	private void readFile(){
		//TODO ReadFile method still needs to place contents somewhere
		inputFile = new File("test_level_01.txt");
		Scanner inputScanner;
		boolean rejectInput= false;
		try{
			inputScanner = new Scanner(inputFile);
			//FIXME needs error detection
			
			
			inputScanner.close();
		}catch (FileNotFoundException f){
			System.err.println("File not found.");
			f.printStackTrace();
		}
	}
	
}
