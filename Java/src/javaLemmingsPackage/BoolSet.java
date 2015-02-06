//*************************
//NAME: James MacIsaac
//EMAIL: jmaci283@mtroyal.ca
//CLASS: COMP 3649
//FILE: BoolSet.java
//*************************

package javaLemmingsPackage;

public class BoolSet {
	
	private int lemmingID;
	
	private boolean hasTryNothing;
	
	private boolean hasTryBasher;
	private boolean hasTryDigger;
	private boolean hasTryBlocker;
	
	BoolSet(Lemming lem){
		this.lemmingID = lem.getID();
		this.hasTryNothing = false;
		this.hasTryBasher = false;
		this.hasTryBlocker = false;
		this.hasTryDigger = false;
	}

	public boolean isHasTryNothing() {
		return hasTryNothing;
	}

	public void setHasTryNothing(boolean hasTryNothing) {
		this.hasTryNothing = hasTryNothing;
	}

	public int getLemmingID() {
		return lemmingID;
	}

	public void setLemmingID(int lemmingID) {
		this.lemmingID = lemmingID;
	}

	public boolean isHasTryBasher() {
		return hasTryBasher;
	}

	public void setHasTryBasher(boolean hasTryBasher) {
		this.hasTryBasher = hasTryBasher;
	}

	public boolean isHasTryDigger() {
		return hasTryDigger;
	}

	public void setHasTryDigger(boolean hasTryDigger) {
		this.hasTryDigger = hasTryDigger;
	}

	public boolean isHasTryBlocker() {
		return hasTryBlocker;
	}

	public void setHasTryBlocker(boolean hasTryBlocker) {
		this.hasTryBlocker = hasTryBlocker;
	}
	
	
}
