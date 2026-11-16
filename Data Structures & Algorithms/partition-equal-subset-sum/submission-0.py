class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums) % 2 != 0:
            return False
        
        def helper(nums, curr, i):
            if curr == sum(nums) / 2:
                return True
            elif curr > sum(nums) / 2:
                return False
            else:
                if i < len(nums) - 1:
                    if helper(nums, curr + nums[i], i + 1) or helper(nums, curr, i + 1):
                        return True
   
            return False
        
        return helper(nums, 0, 0)