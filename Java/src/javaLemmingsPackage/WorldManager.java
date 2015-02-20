//*************************
//NAME: James MacIsaac
//EMAIL: jmaci283@mtroyal.ca
//CLASS: COMP 3649
//FILE: WorldManager.java
//*************************



package javaLemmingsPackage;

import java.util.Stack;

public class WorldManager {
	
	WorldManager(){
		
	}

	public  void run(String fileName) {
		World world = new World();
		IOHandler io = new IOHandler();
		
		Stack<DecisionFrame> decisionStack = new Stack<DecisionFrame>();
		
		world = io.readFile(fileName);
		io.displayWorldInfo(world);
		io.printWorld(world);
		Stack<DecisionFrame> levelStack = new Stack<DecisionFrame>();
		DecisionFrame d = new DecisionFrame(world);
		
		levelStack.push(d);
		//TODO initialize components
		
	
		if(generateSolution(levelStack)){
			System.out.println("Solution found");
		}else{
			System.out.println("Solution not found");
		}
	}

	private boolean generateSolution(Stack<DecisionFrame> decisionStack){
		
		IOHandler io = new IOHandler();
		World aWorld = decisionStack.peek().getFrame();
		
		boolean solved = false;
		World world = aWorld;
						// push frame onto stack
		solved = world.incWorldTime();					// advance time - allow environment to run 1 step
		
		if(solved){ // concluded a simulation attempt
			io.displayWorldInfo(world);
			// need to add case for unsolvable level
			if(world.getSaved() >= world.getNeedSaving()){
			// done - solution made
				return true;
			}else{ // not solved, need to backtrack and change paths
				
				DecisionFrame tempF = decisionStack.pop();	// remove dead end element
				BoolCell workingAP[][] = tempF.getAttemptedPaths();
				AbilityCard workingAC[] = tempF.getAbilitiesGranted();
				world = tempF.getFrame();
				
				// this part handles blacking out the things that have been tried already
				for (int i = 0; i < world.getWorldSize().getY(); i++) { // iterate through y array
					for (int j = 0; j < world.getWorldSize().getX(); j++) { // iterate through x array
						if(workingAP[j][i] != null)
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
								if(world.getWorld()[countX][countY+1].getType() == 2 && !workingAP[countX][countY].getCellSet()[lemC].isHasTryDigger() && world.getSkillsAvailable().getD() >=1){
									found = true;
									workingAC[lemC]= new AbilityCard(world.getWorldTime(),world.getWorld()[countX][countY].getLemming()[lemC].getID(), new OPair(countX,countY), 3);
									world.getWorld()[countX][countY].getLemming()[lemC].setAbility(3); // set to a digger
									world.getSkillsAvailable().decD();
									DecisionFrame dFrame = new DecisionFrame(world); // push world state on the frame
									dFrame.setAbilitiesGranted(workingAC); // make abilities granted = what we just gave the lemmings
									decisionStack.push(dFrame);		
									return generateSolution(decisionStack);
								}else if(world.getWorld()[countX-1][countY].getType() == 2 && !workingAP[countX][countY].getCellSet()[lemC].isHasTryBasher() && !world.getWorld()[countX][countY].getLemming()[lemC].isOrientation() && world.getSkillsAvailable().getS() >=1){
									found = true;
									workingAC[lemC]= new AbilityCard(world.getWorldTime(),world.getWorld()[countX][countY].getLemming()[lemC].getID(), new OPair(countX,countY), 2);
									world.getWorld()[countX][countY].getLemming()[lemC].setAbility(2); // set to a basher
									world.getSkillsAvailable().decS();
									DecisionFrame dFrame = new DecisionFrame(world); // push world state on the frame
									dFrame.setAbilitiesGranted(workingAC); // make abilities granted = what we just gave the lemmings
									decisionStack.push(dFrame);		
									return generateSolution(decisionStack);
								}else if(world.getWorld()[countX+1][countY].getType() == 2 && !workingAP[countX][countY].getCellSet()[lemC].isHasTryBasher() && world.getWorld()[countX][countY].getLemming()[lemC].isOrientation() && world.getSkillsAvailable().getS() >=1){
									found = true;
									workingAC[lemC]= new AbilityCard(world.getWorldTime(),world.getWorld()[countX][countY].getLemming()[lemC].getID(), new OPair(countX,countY), 2);
									world.getWorld()[countX][countY].getLemming()[lemC].setAbility(2); // set to a basher
									world.getSkillsAvailable().decS();
									DecisionFrame dFrame = new DecisionFrame(world); // push world state on the frame
									dFrame.setAbilitiesGranted(workingAC); // make abilities granted = what we just gave the lemmings
									decisionStack.push(dFrame);		
									return generateSolution(decisionStack);
								}else if(world.getWorld()[countX][countY+1].getType() == 2 && !workingAP[countX][countY].getCellSet()[lemC].isHasTryBlocker() && world.getSkillsAvailable().getK() >=1){
									found = true;
									workingAC[lemC]= new AbilityCard(world.getWorldTime(),world.getWorld()[countX][countY].getLemming()[lemC].getID(), new OPair(countX,countY), 1);
									world.getWorld()[countX][countY].getLemming()[lemC].setAbility(1);// set to a blocker
									world.getSkillsAvailable().decK();
									DecisionFrame dFrame = new DecisionFrame(world); // push world state on the frame
									dFrame.setAbilitiesGranted(workingAC); // make abilities granted = what we just gave the lemmings
									decisionStack.push(dFrame);		
									return generateSolution(decisionStack);
								}
								
							}
						}
					}
				}
			}
		}else{ // simulation not done, go again
			return generateSolution(decisionStack); // recursive call to continue sim until timeout or success
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
