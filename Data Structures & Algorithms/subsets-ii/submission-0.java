class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), 0);
        return res; 
    }
    private void dfs(int[] nums, List<Integer> curr, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(nums[i]);
        dfs(nums, curr, i+1);
        curr.remove(curr.size()-1);
        
        while (i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        dfs(nums, curr, i+1);
    }
}
