class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        vals = set()

        for num in nums:
            if num in vals:
                vals.remove(num)
            else:
                vals.add(num)
        
        for e in vals:
            break
        return e