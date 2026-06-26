class DSU {
    int[] parents;
    int[] rank;

    public DSU(int n) {
        parents = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        int res = node;
        while (res != parents[res]) {
            parents[res] = parents[parents[res]];
            res = parents[res];
        }
        return res;
    }
    public boolean union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);
        if (p1 == p2) return false; 
        if (rank[p2] > rank[p1]) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        } 
        parents[p1] = p2;
        rank[p2] += rank[p1];
        return true;
    }
}


class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;

        for (int[] e : edges) {
            if (dsu.union(e[0], e[1])) res--;
        }
        return res;
    }
}
