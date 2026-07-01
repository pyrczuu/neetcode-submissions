class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] arr1 = new int[n-1];
        System.arraycopy(nums, 0, arr1, 0, n - 1);
        int[] arr2 = new int[n-1];
        System.arraycopy(nums, 1, arr2, 0, n - 1);
        int[] memo1 = new int[n-1];
        Arrays.fill(memo1, -1);
        int[] memo2 = new int[n-1];
        Arrays.fill(memo2, -1);
        return Math.max(dfs(arr1, memo1, 0), dfs(arr2, memo2, 0));
    }
    private int dfs(int[] nums, int[] memo, int i) {
        if (i >= nums.length)
            return 0;
        if (memo[i] != -1)
            return memo[i];

        memo[i] = Math.max(dfs(nums, memo, i + 1), nums[i] + dfs(nums, memo, i + 2));
        return memo[i];
    }
}
