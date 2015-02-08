//*************************
//NAME: James MacIsaac
//EMAIL: jmaci283@mtroyal.ca
//CLASS: COMP 3649
//FILE: SkillSet.java
//*************************

package javaLemmingsPackage;

// Lemming Skill Set Count
class SkillSet{
	
	private int c;		//climber
	private int f;		//floater
	private int e;		//exploder
	private int k;		//blocker
	private int b;		//builder
	private int s;		//basher
	private int d;		//digger
	private int m;		//miner
	
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
		this.c--;
	}
	public void decF(){
		this.f--;
	}
	public void decE() {
		this.e--;
	}
	public void decK() {
		this.k--;
	}
	public void decB() {
		this.b--;
	}
	public void decS() {
		this.s--;
	}
	public void decD() {
		this.d--;
	}
	public void decM() {
		this.m--;
	}
}