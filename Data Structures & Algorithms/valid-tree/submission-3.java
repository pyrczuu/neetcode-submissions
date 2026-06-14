class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    Set<Integer> visit = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return edges.length == n -1 && dfs(0, -1) && visit.size() == n;
    }
    private boolean dfs(int node, int parent) {
        if (visit.contains(node)) return false;

        visit.add(node);
        if (adj.get(node).isEmpty()) return true;

        for (int n : adj.get(node)) {
            if (n == parent) continue;
            if (!dfs(n, node)) return false;
        }
        return true;
    }
}
