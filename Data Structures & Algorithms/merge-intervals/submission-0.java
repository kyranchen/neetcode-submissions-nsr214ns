class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        if (n <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        
        for (int i = 1; i < n; i++) {
            if (isOverlapped(curr, intervals[i])) {
                curr = new int[]{curr[0], Math.max(curr[1], intervals[i][1])};
            } else {
                res.add(curr);
                curr = intervals[i];
            }
        }

        res.add(curr);

        return res.toArray(new int[res.size()][]);
    }

    private boolean isOverlapped(int[] a, int[] b) {
        return b[0] <= a[1];
    }
}
