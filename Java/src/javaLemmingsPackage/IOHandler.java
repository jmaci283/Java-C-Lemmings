package javaLemmingsPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOHandler {
	private Scanner io = new Scanner (System.in);							// Keyboard input
	
	private File inputFile;
	
	//TODO add IO Methods
	public void readFile(){
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
			world.setFallDistance(Integer.parseInt(temp));
			temp = inputScanner.nextLine();
			world.setNeedSaving(Integer.parseInt(temp));
			temp = inputScanner.nextLine();
			world.setReleased(Integer.parseInt(temp));
			OGroup[] tempArr = new OGroup[world.getReleased()];
			int counter = 0;
			while(inputScanner.hasNext()){
				int xVal = inputScanner.nextInt();
				int yVal = inputScanner.nextInt();
				int time = inputScanner.nextInt();
				tempArr[counter] = new OGroup(xVal,yVal,time);
				counter++;
			}
			
			inputScanner.close();
		}catch (FileNotFoundException f){
			System.err.println("File not found.");
			f.printStackTrace();
		}catch (NullPointerException n){
			System.err.println("Null Pointer.");
			n.printStackTrace();
		}
	}
	
}
