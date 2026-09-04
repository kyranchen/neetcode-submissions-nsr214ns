class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Use a map with strings in sorted order as keys and the list of children as values
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chs = s.toCharArray();

            Arrays.sort(chs);

            String sorted = new String(chs);

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
