class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(s.length(), 1);
        return dfs(s, 0, memo);
    }
    private int dfs(String s, int i, Map<Integer, Integer> memo) {
        if (memo.containsKey(i)) return memo.get(i);
        if (s.charAt(i) == '0') return 0;

        int res = dfs(s, i+1, memo);
        if (i < s.length()-1) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7') {
                res += dfs(s, i+2, memo);
            }
        }
        memo.put(i, res);
        return res;
    }
}

