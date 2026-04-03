class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(nums[b], nums[a]));
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            queue.add(i);
        }
        res[0] = nums[queue.peek()];

        for (int i = 1; i < nums.length - k + 1; i++) {
            queue.add(i+k-1);
            queue.remove(i-1);
            res[i] = nums[queue.peek()];
        }
        return res;
    }
}
