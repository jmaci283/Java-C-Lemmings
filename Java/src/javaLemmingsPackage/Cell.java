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
			if(lemming[0] != null)
				return true;
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

		public void setLemming(Lemming[] lemming) {
			this.lemming = lemming;
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