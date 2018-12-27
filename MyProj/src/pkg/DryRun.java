package pkg;

public class DryRun {
	
	
	public static int[] countSort(int[] input) {
		int[] kArray = new int[10];
		
		for (int i = 0; i < input.length; i++) {
			int j = input[i];
			++kArray[j];
		}
		
		for (int i = 0; i < kArray.length; i++) {
			int j = kArray[i];
			if(j>0) {
			for(int k=0; k<j; k++) {
				input[i+j]=i;
				i+=1;
			}
			}
		}
		return input;
	}
	
	public static void main(String[] args) {
	        System.out.println((String) null);
	   }

}
