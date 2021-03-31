public class HiddenWeight {

	HiddenWeightNode[][] HN = new HiddenWeightNode[200][784];
	
	public HiddenWeight(){
		for(int i = 0; i < 35;i++){
			for(int j = 0 ; j < 784 ;j++){
				HN[i][j] = new HiddenWeightNode();
			}
		}
	}
	
	public void setHiddenWeight(){

		
		
		for(int i = 0; i < 35; i++){
			for(int j = 0; j < 784; j++)
			{
				double random = Math.random()*2 -1;
				HN[i][j].setWeight(random);
			}
		}
		
	}
	
	
	
	
	class HiddenWeightNode{
		double weight;
		int posIn;
		int posHid;
		
		public HiddenWeightNode(){
			this.weight = 0;
			this.posIn = 0;
			this.posHid = 0;
					
		}
		
		public double getWeight(){
			return weight;
		}
		
		public void setWeight(double weight){
			this.weight = weight;
		}
		
	}
	
	
	
	
}
