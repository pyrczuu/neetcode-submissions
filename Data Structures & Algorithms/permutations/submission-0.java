class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    private void helper(int[] nums, List<Integer> curr, boolean[] chosen) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!chosen[i]) {
                curr.add(nums[i]);
                chosen[i] = true;
                helper(nums, curr, chosen);
                curr.remove(curr.size()-1);
                chosen[i] = false;
            }
        }
    }
}
