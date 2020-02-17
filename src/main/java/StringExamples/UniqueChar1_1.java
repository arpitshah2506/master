package StringExamples;

public class UniqueChar1_1 {

	public static void main(String[] args) {
		String str = "ABCDEF";
		boolean[] charArr = new boolean[128];

		for (int index = 0;index<str.length();index++) {
			if (charArr[str.charAt(index)]) {
				System.out.println("Not all the characters are unique");
				break;
			} else {
				charArr[str.charAt(index)] = true;
			}
			
		}
	}

}
