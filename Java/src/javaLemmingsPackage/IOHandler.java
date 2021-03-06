//*************************
//NAME: James MacIsaac
//EMAIL: jmaci283@mtroyal.ca
//CLASS: COMP 3649
//FILE: IOHandler.java
//*************************

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
	
	public World readFile(String fileName) {
		inputFile = new File(fileName);
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
						inputScanner.close();
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

			reformatInput(world);
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
		System.out.println("Current Time \t\t[" + world.getWorldTime() + "]" );
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
		System.out.println("World Size: \t\t\t[" + world.getWorldSize().getX()
				+ "] by [" + world.getWorldSize().getY() + "]");
		System.out.println("World Diagram:");
		counter = 0;
		int sndCount = 0;
		while (counter < world.getWorldSize().getY()) {
			while (sndCount < world.getWorldSize().getX()) {
				if (world.getWorld()[sndCount][counter].getType() == 1) {
					System.out.print('a');
				} else if (world.getWorld()[sndCount][counter].getType() == 2) {
					System.out.print('d');
				} else {
					System.out.print('r');
				}
				sndCount++;
			}
			System.out.print("\n");
			sndCount = 0;
			counter++;
		}
		System.out.println("Exit Location:\t\t\t("
				+ world.getExitLocation().getX() + ","
				+ world.getExitLocation().getY() + ")");
		System.out.println("Skillset:");
		System.out.println("Climbers available: \t\t[" + world.getSkillsAvailable().getC() + "]");
		System.out.println("Floaters available: \t\t[" + world.getSkillsAvailable().getF() + "]");
		System.out.println("Exploders available: \t\t[" + world.getSkillsAvailable().getE() + "]");
		System.out.println("Blockers available: \t\t[" + world.getSkillsAvailable().getK() + "]");
		System.out.println("Builders available: \t\t[" + world.getSkillsAvailable().getB() + "]");
		System.out.println("Bashers available: \t\t[" + world.getSkillsAvailable().getS() + "]");
		System.out.println("Diggers available: \t\t[" + world.getSkillsAvailable().getD() + "]");
		System.out.println("Miners available: \t\t[" + world.getSkillsAvailable().getM() + "]");
		System.out.println("******************");
		
		System.out.println(world.getQueueSize()); //TODO get rid of this
	}
	
	public void printWorld(World world){
		System.out.println("World Diagram:");
		int counter = 0;
		int sndCounter = 0;
		while(counter < world.getWorldSize().getY()){
			while (sndCounter < world.getWorldSize().getX()){
				if (world.getWorld()[sndCounter][counter].getType() == 1) {
					if(world.getWorld()[sndCounter][counter].hasLemming())
						System.out.print('X');
					else
						System.out.print('a');
				} else if (world.getWorld()[sndCounter][counter].getType() == 2) {
					if(world.getWorld()[sndCounter][counter].hasLemming())
						System.out.print('X');
					else
						System.out.print('d');
				} else {
					if(world.getWorld()[sndCounter][counter].hasLemming())
						System.out.print('X');
					else
						System.out.print('r');
				}
				sndCounter++;
			}
			System.out.println();
			sndCounter = 0;
			counter++;
		}
	}
	
	public void displayAbilityCard(AbilityCard a){
		System.out.println("Time = ["+a.getTime()+ "]" );
		System.out.println("Lemming = [" + a.getLemming() +"]");
		System.out.println("Coordinates = (" +a.getCoordinates().getX() + "," + a.getCoordinates().getY() + ")");
		String ability = null;
		if(a.getAbility() == 1)
			ability = "Blocker";
		else if(a.getAbility() == 2)
			ability = "Basher";
		else
			ability = "Digger";
		System.out.println("Ability Granted = [" + ability + "]");
	}
	
	private void reformatInput(World temp){
		for (int i = 0; i < temp.getStartLocations().length; i++) {
			int num = (temp.getWorldSize().getY()-1) - temp.getStartLocations()[i].getPair().getY();
			temp.getStartLocations()[i].getPair().setY(num);
		}
		
		int num = (temp.getWorldSize().getY()-1) - temp.getExitLocation().getY();
		temp.getExitLocation().setY(num);
	}

}
