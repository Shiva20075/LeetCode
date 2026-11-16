class Solution {
    public String digitSum(String s, int k) {
        
        while (s.length() > k) {

            String res = "";
            int sum = 0;

            for (int i = 0; i < s.length(); i++) {

                sum += s.charAt(i) - '0';

                if ((i + 1) % k == 0){
                    res += sum;
                    sum = 0;
                }
            }

            if (s.length() % k != 0) {
                res += sum;
            }

            s = res;
        }

        return s;
    }
}