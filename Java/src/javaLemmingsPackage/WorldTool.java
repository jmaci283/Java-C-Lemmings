package javaLemmingsPackage;

import java.util.Stack;

public class WorldTool {
	
	private OPair size;
	private int timeLimit;
	
	Stack<LemmingCard> lemmingProcedure = new Stack<LemmingCard>();
	

	WorldTool(OPair size, int timeLimit){
		this.size = size;
		this.timeLimit = timeLimit;
	}
	
	public OPair getSize() {
		return size;
	}

	public void setSize(OPair size) {
		this.size = size;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
}
