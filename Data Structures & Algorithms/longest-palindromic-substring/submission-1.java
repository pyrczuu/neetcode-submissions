class Solution {
    public String longestPalindrome(String s) {
        int resStart = 0;
        int resEnd = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (resEnd - resStart < r - l) {
                    resStart = l;
                    resEnd = r;
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (resEnd - resStart < r - l) {
                    resStart = l;
                    resEnd = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(resStart, resEnd+1);
    }
}
