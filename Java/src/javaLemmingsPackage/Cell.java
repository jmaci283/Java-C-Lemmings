package javaLemmingsPackage;

// cell in the world
class Cell {
		private int type;
		private Lemming lemming[];
		
		Cell(int cellType){
			this.type = cellType;
			this.lemming = new Lemming[50];
		}
		
		public boolean hasLemming(){
			for (int i = 0; i < lemming.length; i++) {
				if(lemming[i] != null)
					return true;	
			}
			return false;
		}
		
		public boolean hasBasher(){
			for (int i = 0; i < lemming.length; i++) {
				if(lemming[i] != null){
					if(lemming[i].getAbility() == 1)
						return true;
				}
			}
			return false;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}
		
		public Lemming[] getLemming() {
			return lemming;
		}

		public void setLemming(int i, Lemming lem) {
			this.lemming[i] = lem;
		}

		public boolean addLemming(Lemming l){
			int counter = 0;
			while(lemming[counter] != null && counter < 50){
				counter++;
			}
			if(counter == 50)
				return false;
			lemming[counter] = l;
			return true;
		}
}