package javaLemmingsPackage;

import java.util.LinkedList;
import java.util.Queue;

public class World {
	//TODO add world methods that interact with cell
	
	//FIELDS
	private int fallDistance;
	private int timeLimit;
	private int needSaving;
	private int released;
	private OGroup startLocations[];  
	private OPair worldSize;
	private Cell world[][];
	private OPair exitLocation;
	private SkillSet skillsAvailable;
	
	private int worldTime;
	private Queue<Lemming> lemmingQueue;
	
	//Constructor
	World(){
		this.fallDistance=0;
		this.timeLimit=0;
		this.needSaving=0;
		this.released=0;
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
	public void incWorldTime() {
		this.worldTime++;
		//FIXME current lemmings should move before any new lemmings are added to the mix
		int counter = 0;
		while(counter < startLocations.length){
			if(worldTime == startLocations[counter].getTime()){
				int xPos = startLocations[counter].getPair().getX();
				int yPos = startLocations[counter].getPair().getY();
				int lemNum = getLemmingQueue().size();
				Lemming lem = new Lemming(lemNum,xPos,yPos);
				enqueueLemming(lem);
				//while()
				world[xPos][yPos].setLemming(lem);
				//TODO add the lemming to the start location cell
			}
			counter ++;
		}
		//FIXME need to add lemming addition and movement.
		
	}	
	
	public int getQueueSize(){
		return lemmingQueue.size();
	}
	public Queue<Lemming> getLemmingQueue() {
		return lemmingQueue;
	}
	public void enqueueLemming(Lemming l){
		lemmingQueue.add(l);
	}
	public Lemming dequeueLemming(){
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
