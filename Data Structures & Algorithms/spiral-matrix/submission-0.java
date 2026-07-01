class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Four bounds that shrink
        List<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m;
        int left = 0;
        int right = n;

        while (left < right && top < bottom) {
            for (int j = left; j < right; j++) {
                res.add(matrix[top][j]);
            }

            top += 1;

            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }

            right -= 1;

            if (!(left < right && top < bottom)) break;

            for (int j = right - 1; j >= left; j--) {
                res.add(matrix[bottom - 1][j]);
            }

            bottom -= 1;

            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }

            left += 1;
        }
        
        return res;
    }
}
