class Solution {
    public int maxDepth(String s) {
        
        Stack<Character> st = new Stack<>();
        int ans = -1;
        int count = 0;

        for ( int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                st.push(s.charAt(i));
                count++;
            }

            if (s.charAt(i) == ')'){
                count--;
                st.pop();
            }

            if (count > ans){
                ans = count;
            }
        }

        return ans;
    }
}