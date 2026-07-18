class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length()+1];
        memo[s.length()] = true;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() &&
                    s.substring(i, i + word.length()).equals(word)) {
                        memo[i] = memo[i + word.length()];
                    }
                    if (memo[i]) break;
            }
        }
        return memo[0];
    }

}

