class Solution {
    int maxArea = 0;
    int[][] directions = {{1, 0}, {-1, 0},
                         {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, checkIslands(grid, i, j));
                }
            }
        }
        return maxArea;    
    }
    private int checkIslands(int[][]grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length ||
             col >= grid[0].length || grid[row][col] == 0) return 0;

        grid[row][col] = 0;
        int area = 1;

        for (int[] direction : directions) {
            area += checkIslands(grid, row + direction[0], col + direction[1]);
        }
        return area;
    }
}
