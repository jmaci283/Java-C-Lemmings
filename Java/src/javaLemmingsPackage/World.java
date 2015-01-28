package javaLemmingsPackage;

public class World {
	//TODO add world fields and methods that interact with cell
	//FIELDS
	int fallDistance;
	int timeLimit;
	int needSaving;
	int released;
	OGroup startLocations[];  
	OPair worldSize;
	Cell world[][];
	OPair exitLocation;
	SkillSet skillsAvailable;
	
	
	//Ordered pair type
	private class OPair{
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
	// Ordered group type
	private class OGroup{

		
		
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
	// Lemming Skill Set Count
	private static class SkillSet{
		
		private int c;
		private int f;
		private int e;
		private int k;
		private int b;
		private int s;
		private int d;
		private int m;
		
		SkillSet(int[] skills){
			this.c = skills[0];
			this.f = skills[1];
			this.e = skills[2];
			this.k = skills[3];
			this.b = skills[4];
			this.s = skills[5];
			this.d = skills[6];
			this.m = skills[7];
		}
		
		// Getters
		public int getC() {
			return c;
		}
		public int getF() {
			return f;
		}
		public int getE() {
			return e;
		}
		public int getK() {
			return k;
		}
		public int getB() {
			return b;
		}
		public int getS() {
			return s;
		}
		public int getD() {
			return d;
		}
		public int getM() {
			return m;
		}
		
		//Decrementers
		public void decC() {
			this.c = c-1;
		}
		public void decF(){
			this.f = f-1;
		}
		public void decE() {
			this.e = e-1;
		}
		public void decK() {
			this.k = k-1;
		}
		public void decB() {
			this.b = b-1;
		}
		public void decS() {
			this.s = s-1;
		}
		public void decD() {
			this.d = d-1;
		}
		public void decM() {
			this.m = m-1;
		}
	}
	
	private class Cell {
			//TODO add fields to cells
			
	}

}
