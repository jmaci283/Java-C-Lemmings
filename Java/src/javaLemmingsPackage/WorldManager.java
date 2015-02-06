//*************************
//NAME: James MacIsaac
//EMAIL: jmaci283@mtroyal.ca
//CLASS: COMP 3649
//FILE: WorldManager.java
//*************************



package javaLemmingsPackage;

import java.util.Stack;

public class WorldManager {

	public static void main(String[] args) {
		World world = new World();
		IOHandler io = new IOHandler();
		
		Stack<DecisionFrame> decisionStack = new Stack<DecisionFrame>();
		
		world = io.readFile(args[0]);
		io.displayWorldInfo(world);
		io.printWorld(world);
		while(world.incWorldTime() == false){
			io.printWorld(world);
		}
	}

	private boolean generateSolution(World world , String solution, Stack<DecisionFrame> decisionStack){
		boolean solved = false;
		World wTemp = world;
						// push frame onto stack
		solved = world.incWorldTime();					// advance time - allow environment to run 1 step
		
		if(solved){ // concluded a simulation attempt
			if(world.getSaved() >= world.getNeedSaving()){
			// done - solution made
				return true;
			}else{ // not solved, need to backtrack and change paths
				// TODO not sure where the pop should be yet
				
				DecisionFrame tempF = decisionStack.pop();	// remove dead end element
				BoolCell workingAP[][] = tempF.getAttemptedPaths();
				AbilityCard workingAC[] = tempF.getAbilitiesGranted();
				world = tempF.getFrame();
				
				// this part handles blacking out the things that have been tried already
				for (int i = 0; i < world.getWorldSize().getY(); i++) { // iterate through y array
					for (int j = 0; j < world.getWorldSize().getX(); j++) { // iterate through x array
						if(workingAP[j][i].getCellSet() != null){ // are there any paths that have been created
							for (int k = 0; k < workingAP[j][i].getCellSet().length; k++) { // iterate through paths
								if (workingAP[j][i].getCellSet()[k] != null) { // does this set exist?
									for(int m = 0; m < workingAC.length; m++)
										if(workingAC[m].getAbility() == 1){
											workingAP[j][i].getCellSet()[k].setHasTryBlocker(true);
										}else if(workingAC[m].getAbility() == 2){
											workingAP[j][i].getCellSet()[k].setHasTryBasher(true);
										}else if(workingAC[m].getAbility() == 3){
											workingAP[j][i].getCellSet()[k].setHasTryDigger(true);
										}else{
											workingAP[j][i].getCellSet()[k].setHasTryNothing(true); // set it's try nothing to true
										}
								}
							}	
						}
					}
				}
				
				int countY = 0;
				int countX = 0;
				int lemC = 0;
				boolean found = false;
				while(countY < world.getWorldSize().getY() && !found){
					while(countX < world.getWorldSize().getX() && !found){
						if(world.getWorld()[countX][countY].hasLemming()){ // cell has a lemming
							while(lemC < world.getWorld()[countX][countY].getLemming().length && !found){
								if(world.getWorld()[countX][countY+1].getType() == 2 && !workingAP[countX][countY].getCellSet()[lemC].isHasTryDigger()){
									workingAP[countX][countY].getCellSet()[lemC].setHasTryDigger(true);
									workingAC[lemC]= new AbilityCard(world.getWorldTime(),world.getWorld()[countX][countY].getLemming()[lemC].getID(), new OPair(countX,countY), 3);
									world.getWorld()[countX][countY].getLemming()[lemC].setAbility(3); // set to a digger
								}else if(world.getWorld()[countX-1][countY].getType() == 2 && !workingAP[countX][countY].getCellSet()[lemC].isHasTryBasher() && !world.getWorld()[countX][countY].getLemming()[lemC].isOrientation()){
									workingAP[countX][countY].getCellSet()[lemC].setHasTryBasher(true);
									workingAC[lemC]= new AbilityCard(world.getWorldTime(),world.getWorld()[countX][countY].getLemming()[lemC].getID(), new OPair(countX,countY), 2);
									world.getWorld()[countX][countY].getLemming()[lemC].setAbility(2); // set to a basher
								}else if(world.getWorld()[countX+1][countY].getType() == 2 && !workingAP[countX][countY].getCellSet()[lemC].isHasTryBasher() && world.getWorld()[countX][countY].getLemming()[lemC].isOrientation()){
									workingAP[countX][countY].getCellSet()[lemC].setHasTryBasher(true);
									workingAC[lemC]= new AbilityCard(world.getWorldTime(),world.getWorld()[countX][countY].getLemming()[lemC].getID(), new OPair(countX,countY), 2);
									world.getWorld()[countX][countY].getLemming()[lemC].setAbility(2); // set to a basher
								}	
								
							}
						}
					}
				}
				// give lemming an ability in the world
				// add an ability to a given lemming card
				// recurse to see resulting outcome
				
				//FIXME needs to pop off the stack and backtrack to try other options
				DecisionFrame dFrame = new DecisionFrame(wTemp);
				dFrame.setAbilitiesGranted(workingAC);
				for (int i = 0;i < workingAP.length; i++) {
					for (int l = 0; l < workingAP[i].length; l++) {
						// TODO left off here						
					}
				}
				//TODO add to frame
				decisionStack.push(dFrame);		
			}
		}else{ // simulation not done, go again
			return generateSolution(world,solution,decisionStack); // recursive call to continue sim until timeout or success
		}
		
		return false;
	}
	
	private void makeBasher(int lem, World world, OPair coords){
		int count = 0;
		while(world.getWorld()[coords.getX()][coords.getY()].getLemming()[count].getID() != lem)
			count++;
		world.getWorld()[coords.getX()][coords.getY()].getLemming()[count].setAbility(2);
	}
	
	private void makeBlocker(int lem, World world, OPair coords){
		int count = 0;
		while(world.getWorld()[coords.getX()][coords.getY()].getLemming()[count].getID() != lem)
			count++;
		world.getWorld()[coords.getX()][coords.getY()].getLemming()[count].setAbility(1);
	}
	
	private void makeDigger(int lem, World world, OPair coords){
		int count = 0;
		while(world.getWorld()[coords.getX()][coords.getY()].getLemming()[count].getID() != lem)
			count++;
		world.getWorld()[coords.getX()][coords.getY()].getLemming()[count].setAbility(3);
	}
	
}
