class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        rec = {}
        for i in range(len(nums)):
            rec[nums[i]] = i

        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in rec and rec[diff] != i:
                return [i, rec[diff]]
            