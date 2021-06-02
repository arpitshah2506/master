package RevisitingConcepts;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        exist(board, "ABCCED");
    }

    private static void exist(char[][] board, String word) {
        boolean firstChar = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(j) == board[i][j]) {
                    //firstCharFound = true;
                }
            }
        }
    }
}
