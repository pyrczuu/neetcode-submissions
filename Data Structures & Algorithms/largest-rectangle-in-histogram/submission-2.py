class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        max_area = 0

        for i, height in enumerate(heights):
            l = i
            r = i

            while l > 0 and heights[l-1] >= height:
                l -= 1
            while r < len(heights) - 1 and heights[r+1] >= height:
                r += 1
            
            area = height * (r - l + 1)
            max_area = max(max_area, area)
        
        return max_area