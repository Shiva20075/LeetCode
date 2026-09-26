class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        String ans = "";
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(')', i);
                String key = s.substring(i + 1, j);

                if (map.containsKey(key)) {
                    ans += map.get(key);
                } else {
                    ans += "?";
                }

                i = j + 1;
            } else {
                ans += s.charAt(i);
                i++;
            }
        }

        return ans;
    }
}