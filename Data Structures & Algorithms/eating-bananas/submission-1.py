from math import ceil
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def calculateTime(piles: List[int], k: int) -> int:
            time = 0
            for pile in piles:
                time += ceil(pile/k)
            return time

        low = 1
        high = max(piles)
        ans = high
        while low <= high:
            k = low + (high - low) // 2
            time = calculateTime(piles, k)

            if time <= h:
                ans = k
                high = k - 1
            else:
                low = k + 1
        return ans 