class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        chars = {}
        l = 0
        ans = 0
        
        for r, char in enumerate(s):
            if char not in chars:
                chars[char] = 1
            else:
                chars[char] += 1
            while (r - l + 1) - max(chars.values()) > k:
                chars[s[l]] -= 1
                l += 1
            ans = max(ans, r - l + 1)
        return ans