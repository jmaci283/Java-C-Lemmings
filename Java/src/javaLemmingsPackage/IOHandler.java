package javaLemmingsPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOHandler {
	private Scanner io = new Scanner (System.in);							// Keyboard input
	
	private File inputFile;
	
	//TODO add IO Methods
	private void readFile(){
		//TODO ReadFile method still needs to place contents somewhere
		inputFile = new File("test_level_01.txt");
		Scanner inputScanner;
		try{
			inputScanner = new Scanner(inputFile);
			//FIXME needs error detection
			
			World world = new World();
			
			String temp = inputScanner.nextLine();
			world.setFallDistance(Integer.parseInt(temp));
			temp = inputScanner.nextLine();
			int time = Integer.parseInt(temp);
			temp = inputScanner.nextLine();
			int nS = Integer.parseInt(temp);
			temp = inputScanner.nextLine();
			int r = Integer.parseInt(temp);
			
			while(inputScanner.hasNext()){
				
			}
			
			inputScanner.close();
		}catch (FileNotFoundException f){
			System.err.println("File not found.");
			f.printStackTrace();
		}
	}
	
}
