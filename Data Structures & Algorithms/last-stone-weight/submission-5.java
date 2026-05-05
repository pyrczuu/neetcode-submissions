class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            if (stone1 > stone2) {
                pq.offer(stone1 - stone2);
            } else if (stone2 > stone1) {
                pq.offer(stone2-stone1);
            } 
        }

        return (pq.size() == 0) ? 0 : pq.peek();
    }
}
