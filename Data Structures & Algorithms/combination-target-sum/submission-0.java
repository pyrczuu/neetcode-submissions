class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, res, curr, 0, 0, target);
        return res; 
    }

    private void dfs(int[] nums, List<List<Integer>>  res, List<Integer> curr, int i, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (i >= nums.length || sum > target) return;

        curr.add(nums[i]);
        dfs(nums, res, curr, i, sum + nums[i], target);
        curr.remove(curr.size() - 1);
        dfs(nums, res, curr, i + 1, sum, target);
    }
}
