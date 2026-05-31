class Solution {

    private static final int [][] directions = {{1, 0}, {-1, 0}, 
                                                {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length ||
         col >= grid[0].length || grid[row][col] == '0') return;

        grid[row][col] = '0';
        for (int[] direction : directions) {
            dfs(grid, row + direction[0], col + direction[1]);

        }
    }
}
