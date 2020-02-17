package StringExamples;

public class PelindromePermutation1_4 {

	public static void main(String[] args) {
		String str = "ABCCsBA";
		int[] intArr = new int[128]; // this array could be taken from 67-95 depending on character added
		for (int index = 0; index < str.length(); index++) {			
			intArr[(int)str.charAt(index)]++; 
		}
		
		for (int index=0; index < intArr.length; index++) {
			if ((intArr[index] % 2 == 0) == false) {
				System.out.println("false");
			}
		}
	}

}
