class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int i = 0 , pro = 1 , count = 0 , n = arr.length;
        for(; i < n ; i++){
            pro = 1;
            for(int j = i ; j < n && pro < k;j++){
                pro *= arr[j];
                if(pro < k ) count++;
            }
        }
        return count;
    }
}