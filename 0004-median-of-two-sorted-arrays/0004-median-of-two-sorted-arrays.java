class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List <Integer> arr = new ArrayList<>();
        double median = 0;

        for (int i = 0; i < nums1.length; i++){
            arr.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++){
            arr.add(nums2[i]);
        }


        Collections.sort(arr);

        if (arr.size() % 2 == 0) {
            median = (arr.get(arr.size()/2 - 1) + arr.get(arr.size()/2))/2.0; 
        } else {
           median = arr.get(arr.size()/2);
        }

        return median;
    }
}