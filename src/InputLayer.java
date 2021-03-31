
public class InputLayer {


	inputNode[] input = new inputNode[784];

	
	{	
		for(int i =0 ; i < input.length; i++){
			input[i] = new inputNode();
		}		
	}
		

	
	public void setInput(int[] input){
		
		for(int i = 0 ; i< 784 ; i++){
			this.input[i].setInput(input[i]);
			this.input[i].setPosition(i+1);
		}
		
	}

	public int[] getInput(){
		
		int[] returnAry = new int[784];
		for(int i = 0; i<784 ; i++){
			returnAry[i] = this.input[i].getInput();
		}
	
		return returnAry;
	}
	
	
	class inputNode{
		
		int input;
		int position;
		
		public inputNode(){
			
		}
		
		public inputNode(int input, int position){
			this.input = input;
			this.position = position;
		}
		
		public void setInput(int input){
			this.input = input;
		}
		
		public void setPosition(int position){
			this.position = position;
		}
		
		public int getInput(){
			return this.input;
		}

	}
}

