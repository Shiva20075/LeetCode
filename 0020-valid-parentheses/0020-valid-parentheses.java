class Solution {
    public boolean isValid(String s) {

        Stack<Character> S = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {

                S.push(s.charAt(i));

            } else {

                if (S.isEmpty()) return false;

                if (s.charAt(i) == ')' && S.peek() == '(') {

                    S.pop();
                    
                } else if (s.charAt(i) == '}' && S.peek() == '{') {
                    S.pop();
                } else if (s.charAt(i) == ']' && S.peek() == '[') {
                    S.pop();
                } else {
                    return false;
                }
                
            }

        }

        return S.isEmpty() ? true : false;

    }
}