class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, curr, res);
        return res;  
    }
    private void dfs(int[] candidates, int target, int i, int sum, List<Integer> curr, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (i >= candidates.length || sum > target) return;

        curr.add(candidates[i]);
        dfs(candidates, target, i + 1, sum + candidates[i], curr, res);
        curr.remove(curr.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(candidates, target, i + 1, sum, curr, res);
    }
}
