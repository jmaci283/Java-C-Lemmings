package javaLemmingsPackage;

public class Lemming {
	
	private int ID;
	private int ability;						// 0 is no ability, 1,2,3 are blocker, basher, digger, respectively
	private boolean orientation;				// False is left, True is right
	private int xLocation;
	private int yLocation;
	
	Lemming(int num, int xVal, int yVal){
		this.ID = num;
		this.ability = 0;
		this.orientation = false;
		this.xLocation = xVal;
		this.yLocation = yVal;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getAbility() {
		return ability;
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	
	public boolean isOrientation() {
		return orientation;
	}
	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}

	
	public int getxLocation() {
		return xLocation;
	}
	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}
	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}
	
	
}
