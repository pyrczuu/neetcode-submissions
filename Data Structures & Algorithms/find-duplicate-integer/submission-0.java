class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> appeared = new HashSet<>();

        for (int num : nums) {
            if (appeared.contains(num)) {
                return num;
            }
            appeared.add(num);
        }
        return -1;
    }
}
