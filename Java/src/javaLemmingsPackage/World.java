//*************************
//NAME: James MacIsaac
//EMAIL: jmaci283@mtroyal.ca
//CLASS: COMP 3649
//FILE: World.java
//*************************

package javaLemmingsPackage;

import java.util.LinkedList;
import java.util.Queue;

public class World {

	// FIELDS
	private int fallDistance;
	private int timeLimit;
	private int needSaving;
	private int saved;
	private int released;
	private OGroup startLocations[];
	private OPair worldSize;
	private Cell world[][];
	private OPair exitLocation;
	private SkillSet skillsAvailable;

	private int worldTime;
	private Queue<Lemming> lemmingQueue;

	// Constructor
	World() {
		this.fallDistance = 0;
		this.timeLimit = 0;
		this.needSaving = 0;
		this.saved = 0;
		this.released = 0;
		this.startLocations = null;
		this.worldSize = null;
		this.world = null;
		this.exitLocation = null;
		this.skillsAvailable = null;

		this.worldTime = 0;
		this.lemmingQueue = new LinkedList<Lemming>();
	}

	public int getWorldTime() {
		return worldTime;
	}

	public boolean incWorldTime() {
		boolean simDone = false;
		this.worldTime++;
		if (worldTime == timeLimit || saved == released) { // check for game over
			if (saved >= needSaving){
				System.out.println("Solved");
				simDone = true;
			}
			// game is won
			else{
				System.out.println("Not solved");
				simDone = true;
			}
			// end the sim
		} else {
			System.out.println(lemmingQueue.size());
			// lemming movement
			for (int i = 0; i < worldSize.getY(); i++) { // this is y var
				for (int j = 0; j < worldSize.getX(); j++) { //this is x var
					if(world[j][i].hasLemming()){ // lemming present in cell
						if(world[j][i].getType() == 1){ // this cell is air
							for (int lemC = 0; lemC < world[j][i].getLemming().length; lemC++) { // iterates through the cell's lemming array
								if(world[j][i].getLemming()[lemC] != null){
									if(!world[j][i].getLemming()[lemC].isHasMoved()){
										if(i != (worldSize.getY()-1) && world[j][i+1].getType() == 1){ // cell below is air, shift down
											if(world[j][i].getLemming()[lemC].getAbility() == 3)
												world[j][i].getLemming()[lemC].setAbility(0); // end digging, air is below
											if(world[j][i].getLemming()[lemC] != null){// found lemming in cell's array
												world[j][i].getLemming()[lemC].setyLocation(i+1);
												world[j][i].getLemming()[lemC].setHasMoved(true);
												world[j][i+1].addLemming(world[j][i].getLemming()[lemC]);
												world[j][i].setLemming(lemC,null);
											}
										}else{ // below is not air, don't need to fall
											if(world[j][i].getLemming()[lemC].getAbility() == 3 && world[j][i+1].getType() == 2){ // can dig dirt below
												world[j][i+1].setType(1);
												world[j][i].getLemming()[lemC].setyLocation(i+1);
												world[j][i].getLemming()[lemC].setHasMoved(true);
												world[j][i+1].addLemming(world[j][i].getLemming()[lemC]);
												world[j][i].setLemming(lemC,null);
												
											}else{ // move horizontally
												if(!world[j][i].getLemming()[lemC].isOrientation()){// orientation = left
													if(j == 0){ // left is out of bounds, change orientation
														if(world[j][i].getLemming()[lemC].getAbility() == 2) 
															world[j][i].getLemming()[lemC].setAbility(0); // hit a dead end, lose bashing ability
														world[j][i].getLemming()[lemC].changeOrientation();
													}else{ // in bounds
														if(!(world[j-1][i].getType() == 3 || world[j-1][i].getType() == 2)){ // left is air, go
															if(!world[j-1][i].hasBlocker()){
																world[j][i].getLemming()[lemC].setxLocation(j-1);
																world[j][i].getLemming()[lemC].setHasMoved(true);
																world[j-1][i].addLemming(world[j][i].getLemming()[lemC]);
																world[j][i].setLemming(lemC,null);
															}else{
																world[j][i].getLemming()[lemC].changeOrientation();
															}
														}else if(world[j][i].getLemming()[lemC].getAbility() == 2){ // lemming is a basher
															// bash it
															world[j-1][i].setType(1);
															// now go there
															world[j][i].getLemming()[lemC].setxLocation(j-1);
															world[j][i].getLemming()[lemC].setHasMoved(true);
															world[j-1][i].addLemming(world[j][i].getLemming()[lemC]);
															world[j][i].setLemming(lemC,null);
														}
													}
												}else{// orientation = right
													if(j+1 == worldSize.getX()){ // right is out of bounds, change orientation
														if(world[j][i].getLemming()[lemC].getAbility() == 2)
															world[j][i].getLemming()[lemC].setAbility(0); // hit a dead end, lose bashing ability
														world[j][i].getLemming()[lemC].changeOrientation();
													}else{ // in bounds
														if(!(world[j+1][i].getType() == 3 || world[j+1][i].getType() == 2)){ // right is air, go
															if(!world[j+1][i].hasBlocker()){
																world[j][i].getLemming()[lemC].setxLocation(j+1);
																world[j][i].getLemming()[lemC].setHasMoved(true);
																world[j+1][i].addLemming(world[j][i].getLemming()[lemC]);
																world[j][i].setLemming(lemC,null);
															}else{
																world[j][i].getLemming()[lemC].changeOrientation();
															}
														}else if(world[j][i].getLemming()[lemC].getAbility() == 2){ // lemming is a basher
															// bash it
															world[j+1][i].setType(1);
															// now go there
															world[j][i].getLemming()[lemC].setxLocation(j+1);
															world[j][i].getLemming()[lemC].setHasMoved(true);
															world[j+1][i].addLemming(world[j][i].getLemming()[lemC]);
															world[j][i].setLemming(lemC,null);
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		// lemming exiting
		if (world[exitLocation.getX()][exitLocation.getY()].hasLemming()) {
			for (int i = 0; i < world[exitLocation.getX()][exitLocation.getY()].getLemming().length; i++) {
				if (world[exitLocation.getX()][exitLocation.getY()].getLemming()[i] != null) {
					lemmingQueue.remove(world[exitLocation.getX()][exitLocation.getY()].getLemming()[i]);
					world[exitLocation.getX()][exitLocation.getY()].getLemming()[i] = null;
					saved++;
				}
			}
		}
		// addition of new lemmings
		int counter = 0;
		while (counter < startLocations.length) {
			if (worldTime == startLocations[counter].getTime()) {
				int xPos = startLocations[counter].getPair().getX();
				int yPos = startLocations[counter].getPair().getY();
				int lemNum = getLemmingQueue().size() + 1;
				Lemming lem = new Lemming(lemNum, xPos, yPos);
				enqueueLemming(lem);
				if (world[xPos][yPos].addLemming(lem))
					System.out.println("Lemming added to cell");
				else
					System.out.println("Cell full");
			}
			counter++;
		}
		
		for (int k = 0; k < worldSize.getY(); k++) {
			for (int l = 0; l < worldSize.getX(); l++) {
				if(world[l][k].hasLemming()){
					for (int m = 0; m < world[l][k].getLemming().length; m++) {
						if(world[l][k].getLemming()[m] != null){
							if(world[l][k].getLemming()[m].isHasMoved()){
								world[l][k].getLemming()[m].setHasMoved(false);
							}
						}
					}
				}
			}
		}
	return simDone;
	}

	public int getQueueSize() {
		return lemmingQueue.size();
	}

	public Queue<Lemming> getLemmingQueue() {
		return lemmingQueue;
	}

	public void enqueueLemming(Lemming l) {
		lemmingQueue.add(l);
	}

	public Lemming dequeueLemming() {
		Lemming temp = lemmingQueue.remove();
		return temp;
	}

	public int getFallDistance() {
		return fallDistance;
	}

	public void setFallDistance(int fallDistance) {
		this.fallDistance = fallDistance;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getNeedSaving() {
		return needSaving;
	}

	public void setNeedSaving(int needSaving) {
		this.needSaving = needSaving;
	}

	public int getSaved() {
		return saved;
	}

	public void setSaved(int saved) {
		this.saved = saved;
	}

	public int getReleased() {
		return released;
	}

	public void setReleased(int released) {
		this.released = released;
	}

	public OGroup[] getStartLocations() {
		return startLocations;
	}

	public void setStartLocations(OGroup[] startLocations) {
		this.startLocations = startLocations;
	}

	public OPair getWorldSize() {
		return worldSize;
	}

	public void setWorldSize(OPair worldSize) {
		this.worldSize = worldSize;
	}

	public Cell[][] getWorld() {
		return world;
	}

	public void setWorld(Cell[][] world) {
		this.world = world;
	}

	public OPair getExitLocation() {
		return exitLocation;
	}

	public void setExitLocation(OPair exitLocation) {
		this.exitLocation = exitLocation;
	}

	public SkillSet getSkillsAvailable() {
		return skillsAvailable;
	}

	public void setSkillsAvailable(SkillSet skillsAvailable) {
		this.skillsAvailable = skillsAvailable;
	}

}
