package javaLemmingsPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IOHandler {

	private Scanner io = new Scanner(System.in); // Keyboard input

	private File inputFile;

	private class InvalidInputException extends Exception {
		public InvalidInputException() {
			super();
		}

		public InvalidInputException(String message) {
			super(message);
		}

		public InvalidInputException(String message, Throwable cause) {
			super(message, cause);
		}

		public InvalidInputException(Throwable cause) {
			super(cause);
		}
	}

	// TODO add IO Methods
	public World readFile() {
		// TODO ReadFile method still needs to place contents somewhere
		inputFile = new File("test_level_01.txt");
		Scanner inputScanner;
		try {
			inputScanner = new Scanner(inputFile);
			
			// world placeholder
			World world = new World();

			// fall distance
			String temp = inputScanner.nextLine();
			world.setFallDistance(Integer.parseInt(temp));

			// time limit
			temp = inputScanner.nextLine();
			world.setTimeLimit(Integer.parseInt(temp));

			// need saving
			temp = inputScanner.nextLine();
			world.setNeedSaving(Integer.parseInt(temp));

			// to be released
			temp = inputScanner.nextLine();
			world.setReleased(Integer.parseInt(temp));

			// start locations
			OGroup[] tempArr = new OGroup[world.getReleased()];
			int counter = 0;
			int tempCounter = 0;
			String tempVals[] = inputScanner.nextLine().split(" ");
			while (counter < tempVals.length) {
				int xVal = Integer.parseInt(tempVals[counter]);
				counter++;
				int yVal = Integer.parseInt(tempVals[counter]);
				counter++;
				int time = Integer.parseInt(tempVals[counter]);
				counter++;
				tempArr[tempCounter] = new OGroup(xVal, yVal, time);
				tempCounter++;
			}
			world.setStartLocations(tempArr);

			// world size
			tempVals = inputScanner.nextLine().split(" ");
			int x = Integer.parseInt(tempVals[0]);
			int y = Integer.parseInt(tempVals[1]);
			world.setWorldSize(new OPair(x, y));

			// world cells
			Cell tempCellArr[][] = new Cell[x][y];
			tempCounter = 0;
			while (tempCounter < y) {
				temp = inputScanner.nextLine();
				char tempC[] = temp.toCharArray();
				counter = 0;
				while (counter < x) {
					if (tempC[counter] == 'a') { // air
						tempCellArr[counter][tempCounter] = new Cell(1);
					} else if (tempC[counter] == 'd') { // dirt
						tempCellArr[counter][tempCounter] = new Cell(2);
					} else if (tempC[counter] == 'r') { // rock
						tempCellArr[counter][tempCounter] = new Cell(3);
					} else {
						throw new InvalidInputException();
					}
					counter++;
				}
				tempCounter++;
			}
			world.setWorld(tempCellArr);

			// exit location
			tempVals = inputScanner.nextLine().split(" ");
			x = Integer.parseInt(tempVals[0]);
			y = Integer.parseInt(tempVals[1]);
			world.setExitLocation(new OPair(x, y));

			// skill set
			tempVals = inputScanner.nextLine().split(" ");
			int tempInts[] = new int[8];
			counter = 0;
			while (counter < tempInts.length) {
				tempInts[counter] = Integer.parseInt(tempVals[counter]);
				counter++;
			}
			SkillSet ss = new SkillSet(tempInts);
			world.setSkillsAvailable(ss);

			// return the placeholder
			inputScanner.close();
			return world;
		} catch (FileNotFoundException f) {
			System.err.println("File not found.");
			f.printStackTrace();
			return null;
		} catch (NullPointerException n) {
			System.err.println("Null Pointer.");
			n.printStackTrace();
			return null;
		} catch (InvalidInputException i) {
			System.err.println("Invalid Input");
			return null;
		}
	}

	public void displayWorldInfo(World world) {
		System.out.println("World Information:");
		System.out.println("******************");
		System.out.println("Maximum Fall Distance: \t["
				+ world.getFallDistance() + "]");
		System.out.println("Time Limit \t\t\t[" + world.getTimeLimit() + "]");
		System.out.println("Lemmings that need to be saved:\t["
				+ world.getNeedSaving() + "]");
		System.out.println("Lemming to be released:\t[" + world.getReleased()
				+ "]");
		int pCounter = 1;
		int counter = 0;
		System.out.println("Lemming starting locations:");
		while (counter < world.getReleased()) {
			System.out.println("Lemming [" + pCounter
					+ "] appears at position ("
					+ world.getStartLocations()[counter].getPair().getX() + ","
					+ world.getStartLocations()[counter].getPair().getY()
					+ ") at time ["
					+ world.getStartLocations()[counter].getTime() + "]");
			counter++;
			pCounter++;
		}
		
		System.err.println("Other shit goes here");
		System.out.println("******************");
	}

}
