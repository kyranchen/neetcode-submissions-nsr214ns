class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (String str: strs) {
            res += str.length() + "#" + str;
        }

        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int N = str.length();
        int index = 0;
        while (index < N) {
            int j = index;
            while (str.charAt(j) != '#') {
                j += 1;
            }

            int length = Integer.parseInt(str.substring(index, j));
            res.add(str.substring(j + 1, j + 1 + length));
            index = j + 1 + length;
        }

        return res;
    }
}
