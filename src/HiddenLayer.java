public class HiddenLayer {

	HiddenNode[] hidden = new HiddenNode[35];

	
	{	
		for(int i =0 ; i < hidden.length; i++){
			hidden[i] = new HiddenNode();
		}		
	}
		
	public void calHidden(InputLayer IL, HiddenWeight HW, HiddenLayer HL){
		double result = 0;
		double temp1 = 0;
		double temp2 = 0;
		double temp3 = 0;
		for(int i = 0; i< 35; i++){
			for(int j =0 ; j< 784 ; j++){
				temp1 =IL.input[j].getInput();
				temp2 = HW.HN[i][j].getWeight();
				temp3 = temp1*temp2;
				result =result + temp3;				
			}
			result = MLP.Sigmoid(result);
			HL.hidden[i].setInput(result);
			
		}
		
	}
	
	
	
	
	class HiddenNode{
		
		double input;
		int position;
		
		public HiddenNode(){
			
		}
		
		public HiddenNode(double input, int position){
			this.input = input;
			this.position = position;
		}
		
		public void setInput(double input){
			this.input = input;
		}
		
		public double getInput(){
			return this.input;
		}
	}
	
	
	
}

