package StringExamples;

public class StringCompression {

	public static void main(String[] args) {
		String str = "AABBDDDDLLPPSSSS";
		
		char charToTraverse = str.charAt(0);
		int count = 0;
		for (int index = 0; index < str.length(); index++) {
			
			if (charToTraverse == str.charAt(index) ) {
				count++;
			} else {
				System.out.println(charToTraverse + " " + count);
				charToTraverse = str.charAt(index);
				count=1;
			}
		}
		System.out.println(str.charAt(str.length()-1) + " " + count);
	}

}
