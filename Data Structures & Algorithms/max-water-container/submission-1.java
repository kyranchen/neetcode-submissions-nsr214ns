class Solution {
    public int maxArea(int[] heights) {
        int N = heights.length;
        int max = 0;

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);

            max = Math.max(height * (right - left), max);

            if (heights[left] > heights[right]) {
                right --;
            } else {
                left ++;
            }
        }
        return max;
    }
}
