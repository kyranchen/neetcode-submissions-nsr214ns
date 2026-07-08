class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Use Kahn's Algo to find a cycle
        // As you use BFS to traverse, you use an array to keep track
        // of the nodes you processed

        int n = numCourses;
        int[] res = new int[n];
        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] req : prerequisites) {
            adj.get(req[1]).add(req[0]);
            indegree[req[0]] += 1;
        }
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[index] = course;
            index++;

            for (int neighbor : adj.get(course)) {
                indegree[neighbor] -= 1;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return index == n? res : new int[0];
    }
}
