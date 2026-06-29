class Solution {
    int[] DIRS = new int[]{1, 0, -1, 0, 1};
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh += 1;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (fresh == 0) return 0;

        int time = 1;

        while (!queue.isEmpty()) {
            List<int[]> cells = new ArrayList<>();
            while (!queue.isEmpty()) {
                cells.add(queue.poll());
            }

            for (int[] cell : cells) {
                int x = cell[0];
                int y = cell[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + DIRS[i];
                    int ny = y + DIRS[i + 1];

                    if (nx >= m || nx < 0 || ny >= n || ny < 0 || grid[nx][ny] != 1) {
                        continue;
                    } else {
                        grid[nx][ny] = 2;
                        fresh -= 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            if (fresh == 0) return time;
            time += 1;
        }

        return fresh == 0 ? time : -1;
    }
}
