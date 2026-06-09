class Solution {
    Map<Integer, List<Integer>> prereq = new HashMap<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            prereq.put(i, new ArrayList<>());
        }

        for (int[] prq : prerequisites) {
            prereq.get(prq[0]).add(prq[1]);
        }

        Set<Integer> cycle = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, cycle, visited, output)) return new int[0];
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = output.get(i);
        }
        return res;
    } 
    private boolean dfs(int course, Set<Integer> cycle, Set<Integer> visited, List<Integer> output) {
        if (cycle.contains(course)) return false;
        if (visited.contains(course)) return true;

        cycle.add(course);
        for (int pre : prereq.get(course)) {
            if (!dfs(pre, cycle, visited, output)) return false;
        }
        cycle.remove(course);
        visited.add(course);
        output.add(course);
        return true;
    }
}
