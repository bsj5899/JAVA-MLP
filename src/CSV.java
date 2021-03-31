import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class CSV {
 
    public static int[][] GetTrainData() {
        int[][] indat = new int[60000][784];
        
        try {
            String path = System.getProperty("user.dir");
            String fileName = "\\mnist_train.csv";
            File csv = new File(path + fileName);
            // File csv = new File("c:\\mnist_train.csv");
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            int row =0 ,i;

            while ((line = br.readLine()) != null) {
            	
                String[] token = line.split(",", -1);
                
                for(i=0; i<784; i++)    
                	indat[row][i] = Integer.parseInt(token[i]);
                
                row++;
            }
            
            
            br.close();
 
            
            return indat;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } 
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }        
 
    
    public static int[][] GetTrainLabel(){
    	int[][] indat = new int[60000][1];
    	
    	  
        try {
            String path = System.getProperty("user.dir");
            String fileName = "\\mnist_train_label.csv";
            File csv = new File(path + fileName);
            // File csv = new File("c:\\mnist_train_label.csv");
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            int row = 0 ,i;

            while ((line = br.readLine()) != null) {
            	
                String[] token = line.split(",", -1);
                
                for(i=0; i<1; i++)    
                	indat[row][i] = Integer.parseInt(token[i]);
                
                row++;
                
            }
            
            
            br.close();
 
            
            return indat;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } 
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    	
    }

    public static int[][] GetTestData() {
        int[][] indat = new int[10000][784];
        
        try {
            String path = System.getProperty("user.dir");
            String fileName = "\\mnist_test.csv";
            File csv = new File(path + fileName);
            // File csv = new File("c:\\mnist_test.csv");
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            int row =0 ,i;

            while ((line = br.readLine()) != null) {
            	
                String[] token = line.split(",", -1);
                
                for(i=0; i<784; i++)    
                	indat[row][i] = Integer.parseInt(token[i]);
                
                row++;
            }
            
            
            br.close();
 
            
            return indat;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } 
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }     
    public static int[][] GetTestLabel(){
    	int[][] indat = new int[10000][1];
    	
    	  
        try {
            String path = System.getProperty("user.dir");
            String fileName = "\\mnist_test_label.csv";
            File csv = new File(path + fileName);
            // File csv = new File("c:\\mnist_test_label.csv");
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";
            int row = 0 ,i;

            while ((line = br.readLine()) != null) {
            	
                String[] token = line.split(",", -1);
                
                for(i=0; i<1; i++)    
                	indat[row][i] = Integer.parseInt(token[i]);
                
                row++;
                
            }
            
            
            br.close();
 
            
            return indat;
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } 
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    	
    }

}