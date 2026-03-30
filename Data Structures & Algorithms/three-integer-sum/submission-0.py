class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums = sorted(nums)
        res = list()

        for i in range(len(nums)):
            obj = nums[i]
            if (obj > 0):
                break
            if i > 0 and obj == nums[i-1]:
                continue

            head = i+1
            tail = len(nums)-1

            while head < tail:
                threeSum = obj + nums[head] + nums[tail]
                print(obj, nums[head], nums[tail])
                if threeSum > 0:
                    tail -= 1
                elif threeSum < 0:
                    head += 1
                else:
                    res.append([obj, nums[head], nums[tail]])
                    head += 1
                    tail -= 1
                    while nums[head] == nums[head - 1] and head < tail:
                        head += 1

        return res

