

public class OutputLayer {
	
	OutputNode[] output = new OutputNode[10];

	
	{	
		for(int i =0 ; i < output.length; i++){
			output[i] = new OutputNode();
		}		
	}
		
	public void calOutput(HiddenLayer HL, OutputWeight OW, OutputLayer OL){
		double result = 0;
		double temp1 = 0;
		double temp2 = 0;
		double temp3 = 0;
		for(int i = 0; i< 10; i++){
			for(int j =0 ; j< 35 ; j++){
				temp1 =HL.hidden[j].getInput();
				temp2 = OW.ON[i][j].getWeight();
				temp3 = temp1*temp2;
				result =result + temp3;
				
			}
			result = MLP.Sigmoid(result);
			OL.output[i].setInput(result);
			
		}
		
	}
	
	
	
	
	class OutputNode{
		
		double input;
		int position;
		
		public OutputNode(){
			
		}
		
		public OutputNode(double input, int position){
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
