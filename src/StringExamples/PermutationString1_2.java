package StringExamples;

public class PermutationString1_2 {

	public static void main(String[] args) {
		String strA = "good";
		String strB = "ododdg";

		if (strA.length() == strB.length() == false) {
			System.out.println("Not equal");
		} else {
			if (sortedString(strA).compareTo(sortedString(strB)) != 0) {
				System.out.println("Not equal");
			}
		}
	}

	static String sortedString(String str) {
		char[] content = str.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
}
