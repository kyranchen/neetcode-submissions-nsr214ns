class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int num = nums[i];
            if (num - 1 == i) {
                i++;
            } else {
                if (num == nums[num - 1]) return num;
                swap(i, num - 1, nums);
            }
        }

        return nums[n - 1];
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
