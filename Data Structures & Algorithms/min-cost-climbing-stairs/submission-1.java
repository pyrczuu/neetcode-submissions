class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int oneStep = cost[0];
        int twoSteps = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int curr = cost[i] + Math.min(oneStep, twoSteps);
            oneStep = twoSteps;
            twoSteps = curr;
        }

        return Math.min(oneStep, twoSteps);
    }
}
