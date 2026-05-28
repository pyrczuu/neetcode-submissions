class Solution {

    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {        

        if (!digits.isEmpty()) backtrack(0, new StringBuilder(), digits);

        return res;
    }
    private void backtrack(int i, StringBuilder curr, String digits) {
        if (i >= digits.length()) {
            res.add(curr.toString());
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            curr.append(c);
            backtrack(i + 1, curr, digits);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
