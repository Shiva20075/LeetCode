import java.util.Stack;

class Solution {
    public int minSwaps(String s) {

        int close = 0;
        Stack<Character> S = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '[') {
                S.push('[');
            } else {

                if (!S.isEmpty()) {
                    S.pop();
                } else {
                    close++;
                }
            }
        }

        int open = S.size();

        return (open + 1) / 2;
    }
}