class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                switch (grid[i][j]) {
                    case 1:
                    fresh++;
                    break;
                    case 2:
                    q.offer(new int[] {i, j});
                    break;
                    default:
                    break;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0},
                            {0, 1}, {0, -1}};

        while (fresh > 0 && !q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row >= 0 && col >= 0 && row < grid.length &&
                        col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[] {row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }

}
