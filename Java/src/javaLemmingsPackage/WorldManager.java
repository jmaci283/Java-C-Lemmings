package javaLemmingsPackage;

public class WorldManager {

	public static void main(String[] args) {
		World world = new World();
		IOHandler io = new IOHandler();
		world = io.readFile();
		io.displayWorldInfo(world);
		io.printWorld(world);
	}
	
	private void incWorldTime(World world){
		world.incWorldTime();
	}

}
