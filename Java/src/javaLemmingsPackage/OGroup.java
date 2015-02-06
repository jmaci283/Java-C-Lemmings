//*************************
//NAME: James MacIsaac
//EMAIL: jmaci283@mtroyal.ca
//CLASS: COMP 3649
//FILE: OGroup.java
//*************************

package javaLemmingsPackage;


// Ordered group type
class OGroup{	
	
	private OPair pair;
	private int time;
	
	OGroup(int xVal, int yVal, int timeVal){
		this.pair = new OPair(xVal,yVal);
		this.time=timeVal;
	}	
	
	public OPair getPair() {
		return pair;
	}
	public void setPair(OPair pair) {
		this.pair = pair;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}