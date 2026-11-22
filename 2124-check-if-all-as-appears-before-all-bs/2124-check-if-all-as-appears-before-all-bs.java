class Solution {
    public boolean checkString(String s) {
        
        int lastA = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                lastA = i;
            }
        }

        for (int i = 0; i < lastA; i++) {
            if (s.charAt(i) == 'b') {
                return false;
            }
        }

        return true;
    }
}