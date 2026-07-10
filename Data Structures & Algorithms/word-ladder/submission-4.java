class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        if (!wordList.contains(beginWord)) wordList.add(beginWord);

        HashMap<String, List<String>> adj = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                StringBuilder pattern = new StringBuilder();
                pattern.append(word.substring(0, i))
                        .append("*")
                        .append(word.substring(i + 1));
                
                adj.computeIfAbsent(pattern.toString(), k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int steps = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String next = queue.poll();
    
                if (next.equals(endWord)) return steps;

                for (int j = 0; j < next.length(); j++) {
                    StringBuilder pattern = new StringBuilder();
                    pattern.append(next.substring(0, j))
                            .append("*")
                            .append(next.substring(j + 1));

                    for (String neighbor : adj.get(pattern.toString())) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            steps += 1;
        }

        return 0;
    }
}
