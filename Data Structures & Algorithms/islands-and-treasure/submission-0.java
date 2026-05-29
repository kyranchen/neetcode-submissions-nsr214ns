class Solution {
    public int[] DIRS = new int[]{1, 0, -1, 0, 1};
    public void islandsAndTreasure(int[][] grid) {
        // Do BFS from each treasure chest
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        int dist = 1;

        while (!queue.isEmpty()) {
            List<int[]> sources = new ArrayList<>();
            while (!queue.isEmpty()) {
                sources.add(queue.poll());
            }

            for (int[] cell : sources) {
                int x = cell[0];
                int y = cell[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + DIRS[i];
                    int ny = y + DIRS[i + 1];

                    if (nx < m && nx >= 0 && ny < n && ny >= 0 && grid[nx][ny] == 2147483647) {
                        grid[nx][ny] = dist;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            dist += 1;
        }
    }
}
