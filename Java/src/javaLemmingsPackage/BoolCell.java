package javaLemmingsPackage;

public class BoolCell {
	private BoolSet cellSet[];
	
	BoolCell(){
		this.cellSet = new BoolSet[50];
	}
	
	public BoolSet[] getCellSet(){
		return this.cellSet;
	}
	
	public void addBoolSet(BoolSet b){
		int count = 0;
		while(cellSet[count] != null && count < cellSet.length){
			count++;
		}
		if(count < cellSet.length)
			cellSet[count] = b;
	}
}
