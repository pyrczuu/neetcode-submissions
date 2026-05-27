class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> part = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s, 0);
        return res;
    }
    private void helper(String s, int i) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                part.add(s.substring(i, j+1));
                helper(s, j+1);
                part.remove(part.size()-1);
            }
        }
        return;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
