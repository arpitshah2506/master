package StringExamples;

public class OneAway1_5 {

	public static void main(String[] args) {
		String a = "Hello world";
		String b = "Helo world";
		
		int size = (a.length() < b.length()) ? b.length() : a.length();
		int indexA = 0;
		int indexB = 0;
		
		boolean oneAwayChar = false;
		
		for (int index = 0; index < size ; index++) {
			if (a.charAt(indexA) == b.charAt(indexB)) {
				indexA++;
				indexB++;
			} else {
				if (oneAwayChar == false) {					
					indexA++;
					oneAwayChar = true;
				} else {
					System.out.println("Mismatching strings");
					break;
				}
			}
		}
	}

}
