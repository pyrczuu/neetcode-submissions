class Solution {
    List<String> res = new ArrayList<>();
    int size; 
    public List<String> generateParenthesis(int n) {
        size = 2 * n;
        helper("", 0, 0);
        return res; 
    }
    private void helper(String curr, int open, int close) {
        if (open > size || open != size && close > open) return;
        if (curr.length() == size) {
            if (open == close) res.add(curr);
            return;
        }

        helper(curr + "(", open + 1, close);
        helper(curr + ")", open, close + 1);
    }
}
