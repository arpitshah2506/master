public class MinDeletionSize {
    public static void main(String[] args) {
        String[] A = {"xycpp","xxaqq","xxbrr"};
        int colToDel = 0;
        boolean isAtLeastSingleCharacterSame;
        int previousCharIndex = 0;
        int eachLoopSeq;
        for (int out = 0; out <A[0].length(); out++) { // characters
            isAtLeastSingleCharacterSame = false;
            eachLoopSeq = 0;
            for (int index = 1; index < A.length; index++) { //strings
                if (colToDel > 0) {
                    previousCharIndex = colToDel - 1;
                }
                if ((out > 0 && A[index -1].charAt(previousCharIndex) == A[index].charAt(previousCharIndex)) || out == 0)
                {
                    if ( A[index -1].charAt(out) > A[index].charAt(out)) {
                        eachLoopSeq = eachLoopSeq + 1;
                        colToDel = colToDel + 1;
                        break;
                    }

                    if (isAtLeastSingleCharacterSame == false && A[index -1].charAt(out) == A[index].charAt(out)) { //same character need to check for next order
                        isAtLeastSingleCharacterSame = true;
                    }
                }
            }
            if (eachLoopSeq == 0 && isAtLeastSingleCharacterSame == false)
            {
                break;
            }
        }
        System.out.println(colToDel);
    }
}
