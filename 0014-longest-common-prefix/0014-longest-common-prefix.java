class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String s = "";

        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < Math.min(strs[0].length(), strs[1].length()); i++) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                s = s + strs[0].charAt(i);
            } else {
                break;
            }
        }

        for (int i = 2; i < strs.length; i++) {
            int min = Math.min(s.length(), strs[i].length());
            for (int j = 0; j < min; j++) {
                if (strs[i].charAt(j) != s.charAt(j)) {
                    s = s.substring(0, j);
                    break;
                }
            }

            if(s.length() > min){
                s = s.substring(0,min);
            }
        }

        return s;
    }
}
