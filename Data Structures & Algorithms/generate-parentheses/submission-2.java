class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        helper(sb, 0, 0, n);
        return res; 
    }
    private void helper(StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            if (open == close) {
                res.add(sb.toString());
            }
            return;
        }

        if (open < n) {
            sb.append('(');
            helper(sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            helper(sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
