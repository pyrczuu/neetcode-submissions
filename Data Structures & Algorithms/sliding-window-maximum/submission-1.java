class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int[] res = new int[nums.length-k+1];
        int cur_max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            cur_max = Math.max(cur_max, nums[i]);
            queue.add(nums[i]);
        }
        res[0] = cur_max;

        for (int i = 1; i < nums.length - k + 1; i++) {
            queue.add(nums[i+k-1]);
            queue.remove(nums[i-1]);
            res[i] = queue.peek();
        }
        return res;
    }
}
