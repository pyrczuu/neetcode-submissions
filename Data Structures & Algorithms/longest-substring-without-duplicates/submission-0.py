class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashset = {}
        ans = 0

        l = 0
        r = 0

        while r < len(s):
            while s[r] in hashset.keys():
                hashset.pop(s[l])
                l += 1
            hashset[s[r]] = 1
            ans = max(ans, r - l + 1)
            r += 1
        return ans