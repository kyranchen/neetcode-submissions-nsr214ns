class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int N = strs.length;
        int base = (int)'a';

        for (int i = 0; i < N; i++) {
            String str = strs[i];
            int[] freq = new int[26];
            for (int j = 0; j < str.length(); j++) {
                freq[(int)str.charAt(j) - base] += 1;
            }

            String key = Arrays.toString(freq);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
