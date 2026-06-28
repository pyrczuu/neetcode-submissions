class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, memo, 0);
    }
    private int dfs(int[] nums, int[] memo, int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];

        memo[i] = Math.max(dfs(nums, memo, i+1), nums[i] + dfs(nums, memo, i+2));
        return memo[i];
    }
}