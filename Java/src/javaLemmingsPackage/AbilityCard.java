//*************************
//NAME: James MacIsaac
//EMAIL: jmaci283@mtroyal.ca
//CLASS: COMP 3649
//FILE: AblilityCard.java
//*************************

package javaLemmingsPackage;

public class AbilityCard {
	private int time;
	private int lemming;
	private OPair coordinates;
	private int ability;
	
	AbilityCard(int time, int lemming, OPair coordinates, int ability){
		this.time = time;
		this.lemming = lemming;
		this.coordinates = coordinates;
		this.ability = ability;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getLemming() {
		return lemming;
	}

	public void setLemming(int lemming) {
		this.lemming = lemming;
	}

	public OPair getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(OPair coordinates) {
		this.coordinates = coordinates;
	}

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}
	
	
}
