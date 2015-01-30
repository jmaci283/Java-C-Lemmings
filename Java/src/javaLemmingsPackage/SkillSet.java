package javaLemmingsPackage;

// Lemming Skill Set Count
class SkillSet{
	
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