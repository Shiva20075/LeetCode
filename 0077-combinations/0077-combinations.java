class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int arr[] = new int[n+1];

        for(int i = 0; i <= n; i++){
            arr[i] = i+1;
        }

        findCombinations(arr,k,0,l,ans);
        return ans;
    }

    public void findCombinations(int[] arr,int size,int index,List<Integer> l,List<List<Integer>> ans){

        if(index == arr.length){
            return;
        }

        if(l.size() == size){
            ans.add(new ArrayList<>(l));
            return;
        }

        l.add(arr[index]);
        findCombinations(arr,size,index+1,l,ans);
        l.remove(l.size() - 1);
        findCombinations(arr,size,index+1,l,ans);
    }
}