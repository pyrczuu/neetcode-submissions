class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> neighbours = new ArrayList<>();
        for (int i = 0; i < n; i++) neighbours.add(new ArrayList<>());

        for (int[] edge : edges) {
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(visited, 0, -1, neighbours)) return false;
        return visited.size() == n;
    }
    private boolean dfs(Set<Integer> visited, int node, int parent, List<List<Integer>> neigh) {
        if (visited.contains(node)) return false;
        visited.add(node);
        for (int n : neigh.get(node)) {
            if (n == parent) continue;
            if (!dfs(visited, n, node, neigh)) return false;
        }
        return true;
    }
}
