package javaLemmingsPackage;

public class DecisionFrame {
	private AbilityCard abilitiesGranted[];
	private World frame;
	private BoolCell attemptedPaths[][];
	
	DecisionFrame(World frame){
		this.abilitiesGranted = new AbilityCard[50];	// room to grant every lemming an ability
		this.frame = frame; 
		this.attemptedPaths = new BoolCell[frame.getWorldSize().getX()][frame.getWorldSize().getY()];
	}

	public AbilityCard[] getAbilitiesGranted() {
		return abilitiesGranted;
	}

	public void setAbilitiesGranted(AbilityCard[] abilitiesGranted) {
		this.abilitiesGranted = abilitiesGranted;
	}

	public World getFrame() {
		return frame;
	}

	public void setFrame(World frame) {
		this.frame = frame;
	}

	public BoolCell[][] getAttemptedPaths() {
		return attemptedPaths;
	}

	public void addAttemptedPath(Lemming lem, int condition) {
		boolean exists = false;
		for (int i = 0; i < this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet().length; i++) {
			if(this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet()[i].getLemmingID() == lem.getID()){
				exists = true;
				if(condition == 1){
					this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet()[i].setHasTryBasher(true);
				}else if(condition == 2){
					this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet()[i].setHasTryDigger(true);
				}else{	// condition = 3
					this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet()[i].setHasTryBlocker(true);
				}
			}
		}
		if(!exists){
		int count = 0;
			while(this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet()[count] != null){
				count++;
			}
			this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet()[count] = new BoolSet(lem);
			if(condition == 1){
				this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet()[count].setHasTryBasher(true);
			}else if(condition == 2){
				this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet()[count].setHasTryDigger(true);	
			}else{	// condition == 3
				this.attemptedPaths[lem.getxLocation()][lem.getyLocation()].getCellSet()[count].setHasTryBlocker(true);
			}
		}
	}
	
	
	
}
