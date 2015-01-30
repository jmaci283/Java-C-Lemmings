package javaLemmingsPackage;

// cell in the world
class Cell {
		private int type;
		private Lemming lemming;
		
		Cell(int cellType){
			this.type = cellType;
			this.lemming = null;
		}
		
		public boolean hasLemming(){
			if(lemming != null)
				return true;
			return false;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public Lemming getLemming() {
			return lemming;
		}

		public void setLemming(Lemming lemming) {
			this.lemming = lemming;
		}
}