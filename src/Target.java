
public class Target {

	int[] target = {0,0,0,0,0,0,0,0,0,0};
	
	public void setTarget(int[] TL){
		for(int i = 0 ; i < 10 ; i++){
			target[i] = TL[i];
		}
	}
	
	public int getInputByIndex(int i){
		return target[i];
	}
	
}
