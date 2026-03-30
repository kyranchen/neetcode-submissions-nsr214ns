class Solution {
    private Set<Integer> visited = new HashSet<>();
    private Set<Integer> visiting = new HashSet<>();
    private HashMap<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] prereq: prerequisites) {
            int pre = prereq[1];
            int course = prereq[0];

            map.putIfAbsent(pre, new ArrayList<>());
            map.get(pre).add(course);

        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) return false;

        if (visited.contains(course)) return true;

        visiting.add(course);

        List<Integer> prereqs = map.getOrDefault(course, new ArrayList<>());
        
        for (int pre: prereqs) {
            if (!dfs(pre)) return false;
        }

        visiting.remove(course);

        visited.add(course);
        return true;
    } 
}
