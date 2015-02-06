package javaLemmingsPackage;

import java.util.Stack;

public class WorldManager {

	public static void main(String[] args) {
		World world = new World();
		IOHandler io = new IOHandler();
		Stack<DecisionFrame> decisionStack = new Stack<DecisionFrame>();
		
		world = io.readFile();
		io.displayWorldInfo(world);
		io.printWorld(world);
		while(world.incWorldTime() == false){
			io.printWorld(world);
		}
	}

	private boolean generateSolution(World world , String solution, Stack<DecisionFrame> decisionStack){
		boolean solved = false;
		solved = world.incWorldTime();
		DecisionFrame dFrame = new DecisionFrame(world); 
		decisionStack.push(dFrame);
		if(solved){
			if(world.getSaved() >= world.getNeedSaving()){
			// done - solution made
			return true;
			}else{
				//FIXME needs to pop off the stack and backtrack to try other options
			}
		}else{
			
			// TODO backtracking goes here
			// TODO recursive method call to step back and change decision when decision is possible
			// return <recursive call>
		}
		
		return false;
	}
	
}
