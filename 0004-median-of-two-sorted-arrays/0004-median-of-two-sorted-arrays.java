class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] brr = new int[n+m];
        for(int i = 0; i < n ; i++) brr[i] = nums1[i];
        for(int j = 0 ; j < m ; j++) brr[n+j] = nums2[j];

        Arrays.sort(brr);
        double median;
        int k = brr.length;
        int h = k/2;
        if(k % 2 == 0){
            median = (brr[h] + brr[h - 1]) / 2.0;
            return median;
        }
        else{
            median = brr[h];
            return median;
        }
    }
}