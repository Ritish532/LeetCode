class Solution {
    public int longestOnes(int[] arr, int k) {
        int i = 0 , j = 0 , count = 0 , maxLen = 0 , n = arr.length;
        while(j < n){
            if(arr[j] == 0) count++;
            while(count > k){
                if(arr[i] == 0) count--;
                i++;
            }
            maxLen = Math.max(maxLen , j-i+1);
            j++;
        }
        return maxLen;
    }
}