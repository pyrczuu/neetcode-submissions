class Solution {
    boolean res = false;
    int length;
    int height;
    String goal;
    int goalLen; 
    public boolean exist(char[][] board, String word) {
        length = board[0].length;
        height = board.length;
        boolean[][] visited = new boolean[height][length];
        goal = word;
        goalLen = word.length();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == goal.charAt(0)) {
                    visited[i][j] = true;
                    helper(board, visited, 0, i, j);
                    visited[i][j] = false;
                    if (res) return true;
                }
            }
        }
        return res;
    }
    private void helper(char[][] board, boolean[][] visited, int wordLen, int x, int y) {
        if (x < 0 || x >= height || y < 0 || y >= length) return;
        if (goal.charAt(wordLen) != board[x][y]) return;
        if (wordLen == goalLen - 1) {
            res = true;
            return;
        }

        if (x < height - 1 && !visited[x+1][y]) {
            visited[x+1][y] = true;
            helper(board, visited, wordLen + 1, x + 1, y);
            visited[x+1][y] = false;            
        }
        if ( x > 0 && !visited[x-1][y]) {
            visited[x-1][y] = true;
            helper(board, visited, wordLen + 1, x - 1, y);
            visited[x-1][y] = false;            
        }
        if (y < length - 1 && !visited[x][y+1]) {
            visited[x][y+1] = true;
            helper(board, visited, wordLen + 1, x, y + 1);
            visited[x][y+1] = false;            
        }
        if (y > 0 && !visited[x][y-1]) {
            visited[x][y-1] = true;
            helper(board, visited, wordLen + 1, x, y - 1);
            visited[x][y-1] = false;            
        }
    }
}
