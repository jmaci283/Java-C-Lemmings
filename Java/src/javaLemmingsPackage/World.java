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


	// Lemming Skill Set Count
	private static class SkillSet{
		
		private int c;
		private int f;
		private int e;
		private int k;
		private int b;
		private int s;
		private int d;
		private int m;
		
		SkillSet(int[] skills){
			this.c = skills[0];
			this.f = skills[1];
			this.e = skills[2];
			this.k = skills[3];
			this.b = skills[4];
			this.s = skills[5];
			this.d = skills[6];
			this.m = skills[7];
		}
		
		// Getters
		public int getC() {
			return c;
		}
		public int getF() {
			return f;
		}
		public int getE() {
			return e;
		}
		public int getK() {
			return k;
		}
		public int getB() {
			return b;
		}
		public int getS() {
			return s;
		}
		public int getD() {
			return d;
		}
		public int getM() {
			return m;
		}
		
		//Decrementers
		public void decC() {
			this.c = c-1;
		}
		public void decF(){
			this.f = f-1;
		}
		public void decE() {
			this.e = e-1;
		}
		public void decK() {
			this.k = k-1;
		}
		public void decB() {
			this.b = b-1;
		}
		public void decS() {
			this.s = s-1;
		}
		public void decD() {
			this.d = d-1;
		}
		public void decM() {
			this.m = m-1;
		}
	}
	
	// cell in the world
	private class Cell {
			private int type;
			private Lemming lemming;
			
			Cell(int cellType){
				this.type = cellType;
				this.lemming = null;
			}
			
			public boolean hasLemming(){
				if(lemming != null)
					return true;
				return false;
			}

			public int getType() {
				return type;
			}

			public void setType(int type) {
				this.type = type;
			}

			public Lemming getLemming() {
				return lemming;
			}

			public void setLemming(Lemming lemming) {
				this.lemming = lemming;
			}
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
