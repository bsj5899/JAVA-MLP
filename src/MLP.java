
public class MLP {

	static double Err = 0;
	static double learningRate = 0.01;
	public static void main(String[] args){
	

		InputLayer IL = new InputLayer();
		HiddenLayer HL = new HiddenLayer();
		HiddenWeight HW = new HiddenWeight();
		OutputLayer OL = new OutputLayer();
		OutputWeight OW = new OutputWeight();
		Target TG = new Target();
		HW.setHiddenWeight();
		OW.setOutputWeight();
		
		int[][] TD = CSV.GetTrainData();

		int[][] TL = CSV.GetTrainLabel();
		
		normalize(TD);
		TL = labelToVector(TL);
		

		Training(IL, HL, HW, OL, OW, TG, TD, TL);
		
		Test(IL,HL,HW,OL,OW,TG);
		
	}

	public static void Debuggint(InputLayer IL, HiddenLayer HL, HiddenWeight HW, OutputLayer OL, OutputWeight OW,Target TG, int[][] TD, int[][] TL){
		double err = 0;
		IL.setInput(TD[0]);
		TG.setTarget(TL[0]);
		err +=ForwardPropagation(IL,HL,HW,OL,OW,TG);
		BackwardPropagation(IL,HL,HW,OL,OW,TG);			
		
	}
	

	private static void Training(InputLayer IL, HiddenLayer HL, HiddenWeight HW, OutputLayer OL, OutputWeight OW,
			Target TG, int[][] TD, int[][] TL) {
		double err = 0;
		for(int j = 0; j <5;j++){
			System.out.println("Train #" + (j+1));
			err = 0;
			for(int k = 0; k< 60000 ;k++)
			{		
				IL.setInput(TD[k]);
				TG.setTarget(TL[k]);
				err +=ForwardPropagation(IL,HL,HW,OL,OW,TG);
				BackwardPropagation(IL,HL,HW,OL,OW,TG);			
			}
			System.out.println(" Error: " + err);
		}
	}
	
	
	public static double ForwardPropagation(InputLayer IL, HiddenLayer HL, HiddenWeight HW, OutputLayer OL ,OutputWeight OW, Target TG){
		HL.calHidden(IL , HW , HL);
		OL.calOutput(HL, OW, OL);
		
		Err = CalErr(OL,TG);
		return Err;
	}
	
	public static void BackwardPropagation(InputLayer IL, HiddenLayer HL, HiddenWeight HW, OutputLayer OL ,OutputWeight OW, Target TG){
		updateOutputWeight(IL,HW,HL,OW,OL,TG);
		updateHiddenWeight(IL,HW,HL,OW,OL,TG);
	}
	
	public static void Test(InputLayer IL, HiddenLayer HL, HiddenWeight HW, OutputLayer OL ,OutputWeight OW, Target TG){
		int[][] TD = CSV.GetTestData();
		int[][] TL = CSV.GetTestLabel();
		normalize(TD);
		TL = labelToVector(TL);
		int total = 10000;
		int right =0;

		for(int k = 0 ; k <10000;k++){
			IL.setInput(TD[k]);
			TG.setTarget(TL[k]);
			ForwardPropagation(IL,HL,HW,OL,OW,TG);
			double max = -Integer.MAX_VALUE;
			int position = -1;
			int maxPos =-1;
			
			for(int i =0;i<10;i++){
				if(OL.output[i].getInput() > max){
					max = OL.output[i].getInput();
					position = i;
				}
				else;
			}
			
			for(int i = 0; i < 10;i++){
				if(TL[k][i] ==1)
					maxPos = i;
			}
			
			if(maxPos == position)
			{	right++;
				System.out.println((k+1)+"��° ����           ���̺� : " + Integer.toString(maxPos) +"     �ν� : " +position+"  ��� : ����");
			}
			else
				System.out.println((k+1)+"��° ����           ���̺� : " + Integer.toString(maxPos) +"     �ν� : " +position+"  ��� : ����");
			
		}
		
		double rate = (double) right/ (double)total*100;
		System.out.println("�� �׽�Ʈ ���� : 10000 ����ȸ�� : " + right + " ������ : " + rate);
	}
	
	
	public static double Sigmoid(double input){	
		return 1/(1 + Math.exp(-input));
	}
	

	public static void normalize(int[][] TD){
		for(int i =0; i <5000;i++){
			for(int j = 0 ; j < 784 ; j++){
				if(TD[i][j] < 150)
					TD[i][j] = 0;
				else
					TD[i][j] = 1;
			}
		}
	}
	
	public static int[][] labelToVector(int[][] TL){

		int length = TL.length;
		int[][] result = new int[length][10];

		for(int i = 0 ; i < length; i++){
			for(int j = 0 ; j <10 ; j++)
				result[i][j]=0;
		}
		
		int temp = 0;
		
		for(int i =0 ; i <length ; i++){
			temp = TL[i][0];
			
			switch(temp){
				case 0 : 
					result[i][0] = 1;
					break;	
				case 1 : 
					result[i][1] = 1;
					break;
				case 2 : 
					result[i][2] = 1;
					break;
				case 3 : 
					result[i][3] = 1;
					break;
				case 4 : 
					result[i][4] = 1;
					break;
				case 5 : 
					result[i][5] = 1;
					break;
				case 6 : 
					result[i][6] = 1;
					break;
				case 7 : 
					result[i][7] = 1;
					break;
				case 8 : 
					result[i][8] = 1;
					break;
				case 9 : 
					result[i][9] = 1;
					break;
			}
		}
		
		return result;
	}

	public static double CalErr(OutputLayer OL , Target TG){
		double err = 0;
		double temp = 0;
		for(int i =0 ; i< 10; i++){
			temp = (TG.getInputByIndex(i) -OL.output[i].getInput());
			temp = temp*temp/2;
			err = err+temp;
			temp = 0;
		}
		return err;
	}
	
	public static void updateOutputWeight(InputLayer IL, HiddenWeight HW, HiddenLayer HL, OutputWeight OW, OutputLayer OL, Target TG){
		double deltaW = 0;	
		for(int i = 9; i > -1; i--){
			for(int  j =34 ; j > -1  ; j--){
				double output = OL.output[i].getInput();
				double temp1 = learningRate*output*(1-output);
				double temp2 = (TG.getInputByIndex(i)-output);
				double temp3 = HL.hidden[j].getInput();
				deltaW = learningRate*output*(1-output)*(TG.getInputByIndex(i)-output)*HL.hidden[j].getInput();
				OW.ON[i][j].setWeight(OW.ON[i][j].getWeight() +deltaW);
			}
			deltaW = 0;
		}
	}
	
	public static void updateHiddenWeight(InputLayer IL, HiddenWeight HW, HiddenLayer HL, OutputWeight OW, OutputLayer OL, Target TG){
		double deltaW = 0;
		for(int i = 34; i >-1; i--){
			for(int  j=783 ; j >-1 ; j--){
				double output2 = HL.hidden[i].getInput();
				double temp = 0;
				deltaW = learningRate*IL.input[j].getInput()*output2*(1-output2);
				
				for(int k =0; k <10;k++){
					double temp2 = OL.output[k].getInput();
					temp = temp + (temp2*(1-temp2)*(TG.getInputByIndex(k)-temp2))*OW.ON[k][i].getWeight();
				}
				deltaW = deltaW*temp;
				HW.HN[i][j].setWeight(HW.HN[i][j].getWeight() + deltaW);
			}
			deltaW = 0;
		}
	}
	

}
