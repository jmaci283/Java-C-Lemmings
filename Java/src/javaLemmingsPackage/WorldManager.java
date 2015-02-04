package javaLemmingsPackage;

public class WorldManager {

	public static void main(String[] args) {
		World world = new World();
		IOHandler io = new IOHandler();
		world = io.readFile();
		io.displayWorldInfo(world);
		io.printWorld(world);
		while(world.incWorldTime() == false){
			io.printWorld(world);
		}
		System.out.println(world.getLemmingQueue().size());
	}

	private boolean generateSolution(World world , String solution){
		
		
		return false;
	}
	
}
