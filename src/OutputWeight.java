
public class OutputWeight {

	OutputWeightNode[][] ON = new OutputWeightNode[10][200];
	
	public OutputWeight(){
		for(int i = 0; i < 10;i++){
			for(int j = 0 ; j < 35 ;j++){
				ON[i][j] = new OutputWeightNode();
			}
		}
	}
	
	public void setOutputWeight(){

		
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 35; j++)
			{
				double random = Math.random()*2 -1;
				ON[i][j].setWeight(random);
			}
		}
		
	}
	
	
	
	
	class OutputWeightNode{
		double weight;
		int posIn;
		int posHid;
		
		public OutputWeightNode(){
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
