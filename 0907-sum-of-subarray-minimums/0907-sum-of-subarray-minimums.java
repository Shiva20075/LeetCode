class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int[] nse = findnse(arr);
        int[] pse = findpse(arr);
        int left = -1;
        int right = n;
        long ans = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < arr.length; i++){
            left = i - pse[i];
            right = nse[i] - i;
            ans = (ans + (long) left * right * arr[i]) % MOD;
        }
        return (int) ans;
    }

    public int[] findnse(int[] arr){

        int n = arr.length;
        Stack<Integer> ns = new Stack<>();
        int[] nse = new int[arr.length];

        for (int i = n - 1; i >= 0; i--){
            while (!ns.isEmpty() && arr[ns.peek()] >= arr[i]){
                ns.pop();
            }
           nse[i] = !ns.isEmpty() ? ns.peek() : n;
            ns.push(i);
        }
        return nse;
    }

        public int[] findpse(int[] arr){

        int n = arr.length;
        Stack<Integer> ps = new Stack<>();
        int[] pse = new int[arr.length];

        for (int i = 0; i < n; i++){
            while (!ps.isEmpty() && arr[ps.peek()] > arr[i]){
                ps.pop();
            }
            pse[i] = !ps.isEmpty() ? ps.peek() : -1;
            ps.push(i);
        }
        return pse;
    }
}