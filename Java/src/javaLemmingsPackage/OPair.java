//*************************
//NAME: James MacIsaac
//EMAIL: jmaci283@mtroyal.ca
//CLASS: COMP 3649
//FILE: OPair.java
//*************************

package javaLemmingsPackage;

//Ordered pair type
class OPair{
	private int x;
	private int y;
	
	OPair(int xVal, int yVal){
		this.x = xVal;
		this.y = yVal;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}