public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        int t = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            t = Math.max(t, wordDict.get(i).length());
        }
        return dfs(s, wordSet, memo, 0, t);
    }

    private boolean dfs(String s, Set<String> wordSet, Boolean[] memo, int i, int t) {
        if (i == s.length()) {
            return true;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        for (int j = i; j < Math.min(i + t, s.length()); j++) {
            if (wordSet.contains(s.substring(i, j + 1))) {
                if (dfs(s, wordSet, memo, j + 1, t)) {
                    memo[i] = true;
                    return true;
                }
            }
        }
        memo[i] = false;
        return false;
    }
}