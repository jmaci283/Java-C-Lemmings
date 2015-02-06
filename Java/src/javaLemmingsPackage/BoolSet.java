package javaLemmingsPackage;

public class BoolSet {
	
	private int lemmingID;
	
	private boolean hasTryBasher;
	private boolean hasTryDigger;
	private boolean hasTryBlocker;
	
	BoolSet(Lemming lem){
		this.lemmingID = lem.getID();
		this.hasTryBasher = false;
		this.hasTryBlocker = false;
		this.hasTryDigger = false;
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
